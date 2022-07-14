package com.inf325.unicamp.grupo8.trabalhopraticosql

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class TrabalhoPraticoSqlApplication

fun main(args: Array<String>) {
	runApplication<TrabalhoPraticoSqlApplication>(*args)
}
