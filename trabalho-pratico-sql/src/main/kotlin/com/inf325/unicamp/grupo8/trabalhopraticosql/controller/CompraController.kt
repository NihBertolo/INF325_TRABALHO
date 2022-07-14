package com.inf325.unicamp.grupo8.trabalhopraticosql.controller

import com.inf325.unicamp.grupo8.trabalhopraticosql.domain.Compra
import com.inf325.unicamp.grupo8.trabalhopraticosql.service.CompraService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/compras")
class CompraController(private val compraService: CompraService) {

    @GetMapping
    fun buscarCompras(): List<Compra> {
        return compraService.buscarCompras()
    }

    @PostMapping
    fun efetuarCompra(@RequestBody compra: Compra): Compra {
        return compraService.salvarCompra(compra)
    }

    @GetMapping("/{id}")
    fun buscarCompra(@PathVariable("id") compraId: Long): Compra {
        return compraService.buscarCompra(compraId)
    }

    @GetMapping("/mais-vendidos")
    fun buscarMaisVendidos(): List<Compra> {
        return compraService.buscarMaisVendidos()
    }

}