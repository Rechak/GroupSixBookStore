package group6.bookstore.BookDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    public void addNewBook(Book book) {
        Optional<Book> bookOptional = bookRepository.findBookBybookName(book.getBookName());
        if (bookOptional.isPresent()){
            throw new IllegalStateException("Book Already Present");
        }
        bookRepository.save(book);
    }

    public void deleteBook(Long bookISBN) {
        boolean exists = bookRepository.existsById(bookISBN);
        if (!exists){
            throw new IllegalStateException("book ISBN:" + bookISBN +" does not exist");
        }
        bookRepository.deleteById(bookISBN);
    }
}
