package com.inf325.unicamp.grupo8.trabalhopraticosql.domain

import java.time.LocalDate
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Usuario(
    @Id
    val _id: String? = UUID.randomUUID().toString(),
    var nome: String,
    var senha: String,
    var email: String,
    var dataNascimento: LocalDate,
    var endereco: String
)