package com.inf325.unicamp.grupo8.trabalhopraticosql.configuration

import com.inf325.unicamp.grupo8.trabalhopraticosql.domain.Compra
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.cloud.openfeign.FeignClient

@FeignClient(name = "compra", url = "http://localhost:8091/v1/compras-cache")
interface FeignClient {

    @PostMapping
    fun salvarCompraCache(compra: Compra)
}