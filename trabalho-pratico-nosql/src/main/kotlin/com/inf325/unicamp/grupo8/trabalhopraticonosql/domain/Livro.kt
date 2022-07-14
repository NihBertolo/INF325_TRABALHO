package com.inf325.unicamp.grupo8.trabalhopraticonosql.domain

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.UUID

@Document(collation = "livro")
data class Livro(
    @Id
    val _id: String? = UUID.randomUUID().toString(),
    var titulo: String,
    var descricao: String? = "",
    var autor: String,
    var editora: String,
    var idioma: String,
    var ISBN: String,
    var generos: List<String>,
    var dataPublicacao: LocalDate,
    @CreatedDate
    val createdDate: LocalDateTime? = LocalDateTime.now(),
    @LastModifiedDate
    var updateDate: LocalDate? = null
)

data class LivroRequest(
    val titulo: String,
    val descricao: String,
    val autor: String,
    val editora: String,
    val idioma: String,
    val ISBN: String,
    val generos: List<String>,
    val dataPublicacao: LocalDate
) {
    fun toDomain(): Livro {
        return Livro(
            _id = UUID.randomUUID().toString(),
            titulo = titulo,
            descricao = descricao,
            autor = autor,
            editora = editora,
            idioma = idioma,
            ISBN = ISBN,
            generos = generos,
            dataPublicacao = dataPublicacao
        )
    }
}
