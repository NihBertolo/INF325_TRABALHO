package com.inf325.unicamp.grupo8.trabalhopraticonosql.repository

import com.inf325.unicamp.grupo8.trabalhopraticonosql.domain.Livro
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface BookRepository: ReactiveMongoRepository<Livro, String> {

}
