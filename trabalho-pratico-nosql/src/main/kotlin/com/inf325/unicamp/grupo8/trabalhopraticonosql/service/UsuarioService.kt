package com.inf325.unicamp.grupo8.trabalhopraticonosql.service

import com.inf325.unicamp.grupo8.trabalhopraticonosql.domain.Usuario
import com.inf325.unicamp.grupo8.trabalhopraticonosql.domain.UsuarioRequest
import com.inf325.unicamp.grupo8.trabalhopraticonosql.repository.UsuarioRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class UsuarioService(private val usuarioRepository: UsuarioRepository) {
    fun buscarUsuarios(): Flux<Usuario>? {
        return usuarioRepository.findAll()
    }

    fun salvarUsuario(usuario: Usuario): Mono<Usuario> {
        return usuarioRepository.save(usuario)
    }

    fun buscarUsuario(usuarioId: String): Mono<Usuario> {
        return usuarioRepository.findById(usuarioId)
    }

    fun alterarUsuario(usuarioId: String, usuario: UsuarioRequest): Mono<Usuario>? {
        return usuarioRepository.findById(usuarioId).map {
            run {
                it.nome = usuario.nome
                it.email = usuario.email
                it.endereco = usuario.endereco
                it.dadosVendas = usuario.dadosVendas
                it.dataNascimento = usuario.dataNascimento
                usuarioRepository.save(it)
            }
            it
        }
    }

    fun deletarUsuario(usuarioId: String) {
        usuarioRepository.deleteById(usuarioId)
    }

}
