package com.inf325.unicamp.grupo8.trabalhopraticonosql.service

import com.inf325.unicamp.grupo8.trabalhopraticonosql.configuration.WebClientConfiguration
import com.inf325.unicamp.grupo8.trabalhopraticonosql.domain.Anuncio
import com.inf325.unicamp.grupo8.trabalhopraticonosql.domain.AnuncioAgregado
import com.inf325.unicamp.grupo8.trabalhopraticonosql.domain.Compra
import com.inf325.unicamp.grupo8.trabalhopraticonosql.repository.AnuncioAgregadoRepository
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.BodyInserters
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.math.BigDecimal

@Service
class CompraService(
    private val usuarioService: UsuarioService,
    private val anuncioService: AnuncioService,
    private val anuncioAgregadoRepository: AnuncioAgregadoRepository,
    private val webClient: WebClientConfiguration
) {
    fun buscarCompras(): Flux<Compra> {
        return webClient.buscarComprasClient()
    }

    fun efetuarCompra(anuncioId: String, desconto: Double, compradorId: String) {
        val findAnuncio = anuncioService.buscarAnuncio(anuncioId)
        val comprador = usuarioService.buscarUsuario(compradorId)

        findAnuncio.map { anuncio ->
            if (anuncio != null) comprador.map { usuario ->
                if (usuario != null) {
                    val compra = Compra(
                        id = null,
                        anuncioId = anuncio._id!!,
                        desconto = desconto,
                        valor = anuncio.preco!! - (anuncio.preco!! * BigDecimal(desconto)),
                        lojista = anuncio.anunciante,
                        comprador = usuario,
                        enderecoEntrega = usuario.endereco
                    )
                    webClient.comprasClient()
                        .body(BodyInserters.fromValue(compra))
                        .retrieve()
                        .bodyToMono(Compra::class.java)
                }
            }
        }
    }

    fun buscarCompra(compraId: Long): Mono<Compra>? {
        return webClient.buscarCompraClient(compraId)
    }

    fun salvarCache(compra: Compra): Mono<AnuncioAgregado> {
        return anuncioAgregadoRepository.findById(compra.anuncioId).flatMap {
            if (it != null) {
                anuncioAgregadoRepository.save(AnuncioAgregado(it.anuncioId, it.quantidadeVendidos++))
            } else {
                anuncioAgregadoRepository.save(AnuncioAgregado(compra.anuncioId, 1))
            }
        }
    }

    fun buscarMaisVendidos(): Flux<AnuncioAgregado>? {
        return null
    }

}
