package group6.bookstore.BookDetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT s FROM Book s WHERE s.bookName = ?1")
    Optional<Book> findBookBybookName(String bookName);
}