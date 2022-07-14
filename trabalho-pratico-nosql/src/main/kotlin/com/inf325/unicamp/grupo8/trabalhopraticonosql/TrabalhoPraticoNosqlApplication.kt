package com.inf325.unicamp.grupo8.trabalhopraticonosql

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories
import org.springframework.web.reactive.config.EnableWebFlux

@SpringBootApplication
class TrabalhoPraticoNosqlApplication

fun main(args: Array<String>) {
	runApplication<TrabalhoPraticoNosqlApplication>(*args)
}
