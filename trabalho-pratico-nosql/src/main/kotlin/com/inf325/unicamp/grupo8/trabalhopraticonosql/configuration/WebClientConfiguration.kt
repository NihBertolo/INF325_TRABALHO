package com.inf325.unicamp.grupo8.trabalhopraticonosql.configuration

import com.inf325.unicamp.grupo8.trabalhopraticonosql.domain.Compra
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class WebClientConfiguration(
    @Value("\${compras.base-url}") private val baseUrl: String,
    @Value("\${compras.path}") private val path: String
) {

    @Bean
    fun comprasClient() = WebClient.create(baseUrl).post()
        .uri(path)
        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)

    @Bean
    fun buscarComprasClient() = WebClient.create(baseUrl).get()
        .uri(path)
        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
        .retrieve()
        .bodyToFlux(Compra::class.java)

    fun buscarCompraClient(compraId: Long) = WebClient.create(baseUrl).get()
        .uri(path, compraId)
        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
        .retrieve()
        .bodyToMono(Compra::class.java)
}