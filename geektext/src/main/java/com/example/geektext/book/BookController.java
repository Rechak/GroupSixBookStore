package com.example.geektext.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/vi/book")
public class BookController {
    private final BookService bookService;

    //Unsure what this means
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping(path = "/")
    public List<Book> sortBookByGenre(@RequestParam(required = false) String genre){ return bookService.sortBooksByGenre(genre); }

    @PostMapping
    public void registerNewBook(@RequestBody Book book) {
        bookService.addNewBook(book);
    }

    @DeleteMapping(path = "{bookId}")
    public void deleteBook(@PathVariable("bookId") Long bookId) {
        bookService.deleteBook(bookId);
    }

    @PutMapping(path = "{bookId}")
    public void updateBook(@PathVariable("bookId") Long bookId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String title) {
        bookService.updateBook(bookId, name, title);
    }
}