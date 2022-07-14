package com.inf325.unicamp.grupo8.trabalhopraticonosql.controller

import com.inf325.unicamp.grupo8.trabalhopraticonosql.domain.Anuncio
import com.inf325.unicamp.grupo8.trabalhopraticonosql.domain.AnuncioRequest
import com.inf325.unicamp.grupo8.trabalhopraticonosql.service.AnuncioService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/v1/anuncios")
class AnuncioController(private val anuncioService: AnuncioService) {

    @GetMapping
    fun buscarAnuncios(): ResponseEntity<Flux<Anuncio>> {
        return ResponseEntity.ok(anuncioService.buscarAnuncios())
    }

    @PostMapping
    fun salvarAnuncio(anuncio: Anuncio): ResponseEntity<Mono<Anuncio>> {
        return ResponseEntity(anuncioService.salvarAnuncio(anuncio), HttpStatus.CREATED)
    }

    @GetMapping("/{id}")
    fun buscarAnuncio(@PathVariable("id") anuncioId: String): ResponseEntity<Mono<Anuncio>> {
        return ResponseEntity.ok(anuncioService.buscarAnuncio(anuncioId))
    }

    @PatchMapping("/{id}")
    fun atualizarLivro(
        @PathVariable("id") anuncioId: String,
        @RequestBody anuncio: AnuncioRequest
    ): ResponseEntity<Mono<Anuncio>> {
        return ResponseEntity.ok(anuncioService.alterarAnuncio(anuncioId, anuncio))
    }

    @DeleteMapping("/{id}")
    fun deletarLivro(@PathVariable("id") anuncioId: String): ResponseEntity<Unit> {
        return ResponseEntity(anuncioService.deletarAnuncio(anuncioId), HttpStatus.NO_CONTENT)
    }
}