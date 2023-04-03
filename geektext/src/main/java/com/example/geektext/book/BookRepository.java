package com.example.geektext.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository
        extends JpaRepository<Book, Long> { //The type we want to work with our id

    @Query("SELECT s FROM Book s WHERE s.title = ?1")
    Optional<Book> findBookByTitle(String title);

    @Query("SELECT s FROM Book s WHERE s.genre = ?1")
    List<Book> findBookByGenre(String genre);

}
