package com.inf325.unicamp.grupo8.trabalhopraticosql.repository

import com.inf325.unicamp.grupo8.trabalhopraticosql.domain.Compra
import org.springframework.data.jpa.repository.JpaRepository

interface CompraRepository: JpaRepository<Compra, Long> {

}
