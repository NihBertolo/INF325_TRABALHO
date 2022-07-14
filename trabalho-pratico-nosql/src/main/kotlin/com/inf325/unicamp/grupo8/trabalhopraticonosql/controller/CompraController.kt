package com.inf325.unicamp.grupo8.trabalhopraticonosql.controller

import com.inf325.unicamp.grupo8.trabalhopraticonosql.domain.Anuncio
import com.inf325.unicamp.grupo8.trabalhopraticonosql.domain.AnuncioAgregado
import com.inf325.unicamp.grupo8.trabalhopraticonosql.domain.Compra
import com.inf325.unicamp.grupo8.trabalhopraticonosql.domain.Usuario
import com.inf325.unicamp.grupo8.trabalhopraticonosql.service.CompraService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/v1/compras")
class CompraController(private val compraService: CompraService) {

    @GetMapping()
    fun buscarCompras(): ResponseEntity<Flux<Compra>> {
        return ResponseEntity.ok(compraService.buscarCompras())
    }

    @PostMapping()
    fun efetuarCompra(
        @RequestParam("anuncioId") anuncioId: String,
        @RequestParam("desconto") desconto: Double,
        @RequestParam("compradorId") compradorId: String): ResponseEntity<Unit> {
        return ResponseEntity(compraService.efetuarCompra(anuncioId, desconto, compradorId), HttpStatus.CREATED)
    }

    @GetMapping("/{id}")
    fun buscarCompra(@PathVariable("id") compraId: Long): ResponseEntity<Mono<Compra>> {
        return ResponseEntity.ok(compraService.buscarCompra(compraId))
    }

    @PostMapping("/cache")
    fun salvarCache(@RequestBody compra: Compra): ResponseEntity<Mono<AnuncioAgregado>> {
        return ResponseEntity(compraService.salvarCache(compra), HttpStatus.CREATED)
    }

    @GetMapping("teste")
    fun buscarMaisVendidos(): ResponseEntity<Flux<AnuncioAgregado>> {
        return ResponseEntity.ok(compraService.buscarMaisVendidos())
    }
}