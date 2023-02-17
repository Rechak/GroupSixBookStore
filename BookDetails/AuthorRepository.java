package group6.bookstore.BookDetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT s FROM Author s WHERE s.firstName = ?1")
    Optional<Author> findAuthorByfirstName(String firstName);
}