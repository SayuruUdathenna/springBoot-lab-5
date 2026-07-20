package com.mycompany.book_api;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class BookRepository {

    private final Map<Long, Book> books = new ConcurrentHashMap<>();
    private final AtomicLong idCounter = new AtomicLong();

    // Return all books
    public List<Book> findAll() {
        return new ArrayList<>(books.values());
    }

    // Find one book by id (Optional means "might be there, might not")
    public Optional<Book> findById(Long id) {
        return Optional.ofNullable(books.get(id));
    }

    // Save a new book (assigns a fresh id)
    public Book save(Book book) {
        Long newId = idCounter.incrementAndGet();
        book.setId(newId);
        books.put(newId, book);
        return book;
    }

    // Update an existing book
    public Book update(Long id, Book book) {
        book.setId(id);
        books.put(id, book);
        return book;
    }

    // Delete by id; returns true if something was actually removed
    public boolean deleteById(Long id) {
        return books.remove(id) != null;
    }

    // Check if a book exists
    public boolean existsById(Long id) {
        return books.containsKey(id);
    }
}
