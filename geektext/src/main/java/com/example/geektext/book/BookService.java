package com.example.geektext.book;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public void addNewBook(Book book) {
        Optional<Book> bookOptional = bookRepository.findBookByTitle(book.getTitle());
        if (bookOptional.isPresent()) {
            throw new IllegalStateException("Title Taken");
        }
        bookRepository.save(book);
    }

    public void deleteBook(Long bookId) {
        boolean exists = bookRepository.existsById(bookId);
        if (!exists) {
            throw new IllegalStateException("book with id " + bookId + " does not exist.");
        }
        bookRepository.deleteById(bookId);
    }

    @Transactional //Entity goes into a managed state [Spring JPA course]
    public void updateBook(Long bookId, String name, String title) {
        Book book = bookRepository.findById(bookId).orElseThrow(
                () -> new IllegalStateException("book with id " + bookId + " does not exist.")
        );

        if (name != null && name.length() > 0 && !Objects.equals(book.getTitle(), title)) {
            Optional<Book> bookOptional = bookRepository.findBookByTitle(title);

            if (bookOptional.isPresent()) {
                throw new IllegalStateException("title taken");
            }
            book.getTitle();
        }
    }

    public List<Book> sortBooksByGenre(String genre) {
        List<Book> bookOptional = null;
        ArrayList<Book> books = new ArrayList<>();
        for (Book book : getBooks()) {
            if (book.getGenre().equals(genre)) {
                bookOptional = bookRepository.findBookByGenre(book.getGenre());
            }
        }
        return bookOptional;
    }
}
