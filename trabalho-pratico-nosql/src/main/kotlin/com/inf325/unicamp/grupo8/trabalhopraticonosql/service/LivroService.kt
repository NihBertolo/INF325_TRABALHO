package com.inf325.unicamp.grupo8.trabalhopraticonosql.service

import com.inf325.unicamp.grupo8.trabalhopraticonosql.domain.Livro
import com.inf325.unicamp.grupo8.trabalhopraticonosql.domain.LivroRequest
import com.inf325.unicamp.grupo8.trabalhopraticonosql.repository.BookRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class LivroService(private val bookRepository: BookRepository) {

    fun getAllBooks(): Flux<Livro>? {
        return bookRepository.findAll()
    }

    fun saveBook(book: Livro): Mono<Livro> {
        return bookRepository.insert(book)
    }

    fun getBookById(bookId: String): Mono<Livro> {
        return bookRepository.findById(bookId)
    }

    fun deleteById(bookId: String) {
        bookRepository.deleteById(bookId)
    }

    fun updateBook(bookId: String, book: LivroRequest): Mono<Livro> {
        return bookRepository.findById(bookId).map {
            run {
                it.titulo = book.titulo
                it.ISBN = book.ISBN
                it.editora = book.editora
                it.descricao = book.descricao
                it.idioma = book.idioma
                it.generos = book.generos
                it.dataPublicacao = book.dataPublicacao
                bookRepository.save(it)
            }
            it
        }
    }
}
