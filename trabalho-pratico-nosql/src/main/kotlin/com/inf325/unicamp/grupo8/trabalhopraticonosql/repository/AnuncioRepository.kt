package com.inf325.unicamp.grupo8.trabalhopraticonosql.repository

import com.inf325.unicamp.grupo8.trabalhopraticonosql.domain.Anuncio
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface AnuncioRepository: ReactiveMongoRepository<Anuncio, String> {

}
