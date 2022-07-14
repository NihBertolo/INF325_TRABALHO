package com.inf325.unicamp.grupo8.trabalhopraticonosql.domain

import com.inf325.unicamp.grupo8.trabalhopraticonosql.domain.enums.CondicaoStatus
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*

@Document(collation = "anuncio")
data class Anuncio(
    @Id
    val _id: String? = UUID.randomUUID().toString(),
    val livro: Livro,
    var anunciante: Usuario,
    var preco: BigDecimal? = BigDecimal.ZERO,
    var condicao: CondicaoStatus,
    @CreatedDate
    val dataPostagem: LocalDateTime? = LocalDateTime.now(),
    @LastModifiedDate
    var dataAtualizacao: LocalDateTime? = null,
    var quantidadeEstoque: Int? = 0,
    var urlsfotos: List<String>
)

data class AnuncioRequest(
    var preco: BigDecimal? = BigDecimal.ZERO,
    var condicao: CondicaoStatus,
    var urlsfotos: List<String>
)

@Document(collation = "anuncio_cache")
data class AnuncioAgregado(
    @Id
    val anuncioId: String,
    var quantidadeVendidos: Int
)
