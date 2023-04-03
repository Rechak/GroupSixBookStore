package group6.bookstore.BookDetails;

import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    Book findByFirstName(String firstName);
}
