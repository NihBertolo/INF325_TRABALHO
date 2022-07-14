package com.inf325.unicamp.grupo8.trabalhopraticonosql.repository

import com.inf325.unicamp.grupo8.trabalhopraticonosql.domain.Usuario
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface UsuarioRepository: ReactiveMongoRepository <Usuario, String> {

}
