package com.inf325.unicamp.grupo8.trabalhopraticonosql.domain

import java.math.BigDecimal

data class Compra (
    val id: Long? = null,
    val anuncioId: String,
    val desconto: Double? = 0.0,
    val valor: BigDecimal? = BigDecimal.ZERO,
    val lojista: Usuario,
    val comprador: Usuario,
    val enderecoEntrega: String
)
