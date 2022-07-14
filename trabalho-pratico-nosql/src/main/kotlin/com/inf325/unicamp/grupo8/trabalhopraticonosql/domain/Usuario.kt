package com.inf325.unicamp.grupo8.trabalhopraticonosql.domain

import com.inf325.unicamp.grupo8.trabalhopraticonosql.domain.enums.TipoDocumento
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

@Document(collation = "usuario")
data class Usuario(
    val _id: String? = UUID.randomUUID().toString(),
    var nome: String,
    var senha: String,
    var email: String,
    var dataNascimento: LocalDate,
    @CreatedDate
    var dataCriacao: LocalDateTime? = LocalDateTime.now(),
    @LastModifiedDate
    var dataAtualizacao: LocalDateTime? = null,
    var endereco: String,
    var dadosVendas: Vendas? = null,
    val documento: Documento
)

data class Documento(
    val tipo: TipoDocumento,
    val numero: String
)

data class Vendas(
    val quantidadeTotal: Int,
    val avalicao: Avaliacao? = null
)

data class Avaliacao(
    val otima: Int,
    val boa: Int,
    val media: Int,
    val ruim: Int,
    val pessima: Int
) {
    fun avaliacaoMedia(quantidadeTotal: Int): Int = (otima+boa+media+ruim+pessima)/quantidadeTotal
}

data class UsuarioRequest(
    var nome: String,
    var senha: String,
    var email: String,
    var dataNascimento: LocalDate,
    var endereco: String,
    var dadosVendas: Vendas? = null,
    val documento: Documento
)
