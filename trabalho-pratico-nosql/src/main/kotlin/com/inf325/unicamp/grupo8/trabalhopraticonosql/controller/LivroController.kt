package com.inf325.unicamp.grupo8.trabalhopraticonosql.controller

import com.inf325.unicamp.grupo8.trabalhopraticonosql.domain.Livro
import com.inf325.unicamp.grupo8.trabalhopraticonosql.domain.LivroRequest
import com.inf325.unicamp.grupo8.trabalhopraticonosql.service.LivroService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/v1/livros")
class LivroController(private val bookService: LivroService) {

    @GetMapping()
    fun buscarLivros(): ResponseEntity<Flux<Livro>> {
        return ResponseEntity.ok(bookService.getAllBooks())
    }

    @PostMapping
    fun salvarLivro(@RequestBody book: LivroRequest): ResponseEntity<Mono<Livro>> {
        return ResponseEntity<Mono<Livro>>(bookService.saveBook(book.toDomain()), HttpStatus.CREATED)
    }

    @GetMapping("/{id}")
    fun buscarLivro(@PathVariable("id") bookId: String): ResponseEntity<Mono<Livro>> {
        return ResponseEntity.ok(bookService.getBookById(bookId))
    }

    @PatchMapping("/{id}")
    fun atualizarLivro(
        @PathVariable("id") bookId: String,
        @RequestBody livro: LivroRequest
    ): ResponseEntity<Mono<Livro>> {
        return ResponseEntity.ok(bookService.updateBook(bookId, livro))
    }

    @DeleteMapping("/{id}")
    fun deletarLivro(@PathVariable("id") bookId: String): ResponseEntity<Unit> {
        return ResponseEntity<Unit>(bookService.deleteById(bookId), HttpStatus.NO_CONTENT)
    }

}