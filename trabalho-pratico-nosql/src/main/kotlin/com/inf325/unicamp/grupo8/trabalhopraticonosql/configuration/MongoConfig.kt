package com.inf325.unicamp.grupo8.trabalhopraticonosql.configuration

import com.inf325.unicamp.grupo8.trabalhopraticonosql.repository.AnuncioRepository
import com.inf325.unicamp.grupo8.trabalhopraticonosql.repository.EventRepository
import com.mongodb.reactivestreams.client.MongoClients
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.ReactiveMongoDatabaseFactory
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.core.convert.MappingMongoConverter
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories


@Configuration
@EnableReactiveMongoRepositories(basePackageClasses = arrayOf(AnuncioRepository::class))
class MongoConfig : AbstractReactiveMongoConfiguration() {

    override fun getDatabaseName() = "INF325"

    @Bean
    fun mongoClient() = MongoClients.create()
}