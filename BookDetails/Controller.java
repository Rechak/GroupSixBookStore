package group6.bookstore.BookDetails;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping("/books")
    public List<Book> getBooks() {
        return (List<Book>) bookRepository.findAll();
    }
    @PostMapping("/books")
    public Book addBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }
    @GetMapping("/books/{isbn}")
    public Book getBookByISBN(@PathVariable String isbn) {
        return bookRepository.findByISBN(isbn);
    }

    @GetMapping("/authors")
    public List<Author> getAuthors() {
        return (List<Author>) authorRepository.findAll();
    }
    @PostMapping("/authors")
    public Author addAuthor(@RequestBody Author author) {
        return authorRepository.save(author);
    }
}
