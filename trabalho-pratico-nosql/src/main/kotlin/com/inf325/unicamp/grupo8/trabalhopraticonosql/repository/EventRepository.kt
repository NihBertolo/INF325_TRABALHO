package com.inf325.unicamp.grupo8.trabalhopraticonosql.repository

import com.inf325.unicamp.grupo8.trabalhopraticonosql.domain.Event
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface EventRepository: ReactiveMongoRepository<Event, String> {

}
