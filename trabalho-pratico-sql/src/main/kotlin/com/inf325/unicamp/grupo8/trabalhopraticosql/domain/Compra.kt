package com.inf325.unicamp.grupo8.trabalhopraticosql.domain

import java.math.BigDecimal
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
data class Compra (
    @Id
    val id: Long? = null,
    val anuncioId: String,
    val desconto: Double? = 0.0,
    val valor: BigDecimal? = BigDecimal.ZERO,
    val lojistaId: String,
    @ManyToOne
    val lojista: Usuario,
    @ManyToOne
    val comprador: Usuario,
    val enderecoEntrega: String
)
