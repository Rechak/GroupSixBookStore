package group6.bookstore.BookDetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long>  {
    Book findByISBN(String ISBN);
}



