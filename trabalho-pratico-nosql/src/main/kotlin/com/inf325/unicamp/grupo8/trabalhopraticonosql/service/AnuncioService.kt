package com.inf325.unicamp.grupo8.trabalhopraticonosql.service

import com.inf325.unicamp.grupo8.trabalhopraticonosql.domain.Anuncio
import com.inf325.unicamp.grupo8.trabalhopraticonosql.domain.AnuncioRequest
import com.inf325.unicamp.grupo8.trabalhopraticonosql.repository.AnuncioRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class AnuncioService(private val anuncioRepository: AnuncioRepository) {

    fun buscarAnuncios(): Flux<Anuncio> {
        return anuncioRepository.findAll()
    }

    fun salvarAnuncio(anuncio: Anuncio): Mono<Anuncio> {
        return anuncioRepository.save(anuncio)
    }

    fun buscarAnuncio(anuncioId: String): Mono<Anuncio> {
        return anuncioRepository.findById(anuncioId)
    }

    fun alterarAnuncio(anuncioId: String, anuncio: AnuncioRequest): Mono<Anuncio> {
        return anuncioRepository.findById(anuncioId).map {
            run {
                it.condicao = anuncio.condicao
                it.preco = anuncio.preco
                it.urlsfotos = anuncio.urlsfotos
                anuncioRepository.save(it)
            }
            it
        }
    }

    fun deletarAnuncio(anuncioId: String) {
        anuncioRepository.deleteById(anuncioId)
    }

}
