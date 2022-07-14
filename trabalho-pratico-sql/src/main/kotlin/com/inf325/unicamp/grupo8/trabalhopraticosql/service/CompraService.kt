package com.inf325.unicamp.grupo8.trabalhopraticosql.service

import com.inf325.unicamp.grupo8.trabalhopraticosql.configuration.FeignClient
import com.inf325.unicamp.grupo8.trabalhopraticosql.domain.Compra
import com.inf325.unicamp.grupo8.trabalhopraticosql.repository.CompraRepository
import org.springframework.stereotype.Service

@Service
class CompraService(private val compraRepository: CompraRepository, private val feignClient: FeignClient) {

    fun buscarCompras(): List<Compra> {
        return compraRepository.findAll()
    }

    fun salvarCompra(compra: Compra): Compra {
        this.agregarCache(compra)
        return compraRepository.save(compra)
    }


    fun buscarCompra(compraId: Long): Compra {
        return compraRepository.findById(compraId).get()
    }

    private fun agregarCache(compra: Compra) {
        feignClient.salvarCompraCache(compra)
    }

    fun buscarMaisVendidos(): List<Compra> {
        return compraRepository.findAll()
    }

}
