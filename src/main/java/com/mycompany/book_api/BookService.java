package com.mycompany.book_api;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    // Spring automatically provides the repository here (dependency injection)
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Optional<Book> updateBook(Long id, Book book) {
        if (bookRepository.existsById(id)) {
            return Optional.of(bookRepository.update(id, book));
        }
        return Optional.empty();
    }

    public boolean deleteBook(Long id) {
        return bookRepository.deleteById(id);
    }
}
