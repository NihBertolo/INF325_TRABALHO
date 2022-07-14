package com.inf325.unicamp.grupo8.trabalhopraticonosql.controller

import com.inf325.unicamp.grupo8.trabalhopraticonosql.domain.Usuario
import com.inf325.unicamp.grupo8.trabalhopraticonosql.domain.UsuarioRequest
import com.inf325.unicamp.grupo8.trabalhopraticonosql.service.UsuarioService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/v1/usuarios")
class UsuarioController(private val usuarioService: UsuarioService) {

    @GetMapping
    fun buscarUsuarios(): ResponseEntity<Flux<Usuario>> {
        return ResponseEntity.ok(usuarioService.buscarUsuarios())
    }

    @PostMapping
    fun salvarUsuario(usuario: Usuario): ResponseEntity<Mono<Usuario>> {
        return ResponseEntity(usuarioService.salvarUsuario(usuario), HttpStatus.CREATED)
    }

    @GetMapping("/{id}")
    fun buscarUsuario(@PathVariable("id") usuarioId: String): ResponseEntity<Mono<Usuario>> {
        return ResponseEntity.ok(usuarioService.buscarUsuario(usuarioId))
    }

    @PatchMapping("/{id}")
    fun alterarUsuario(
        @PathVariable("id") usuarioId: String,
        @RequestBody usuario: UsuarioRequest
    ): ResponseEntity<Mono<Usuario>> {
        return ResponseEntity.ok(usuarioService.alterarUsuario(usuarioId, usuario))
    }

    @DeleteMapping("/{id}")
    fun deletarUsuario(@PathVariable("id") usuarioId: String): ResponseEntity<Unit> {
        return ResponseEntity(usuarioService.deletarUsuario(usuarioId), HttpStatus.NO_CONTENT)
    }
}