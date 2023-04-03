package com.example.geektext.book;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class BookConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            BookRepository repository) { //Inject bookRepo
        return args -> {
            Book bookExample = new Book(
                    "Basic Title",
                    "Alisa C.",
                    "Thriller",
                    3456,
                    3.2,
                    LocalDate.of(1999, 4, 3),
                    "Alisa"
            );

            //Invoke repo to save
            repository.saveAll(
                    List.of(bookExample)
            );
        };
    }
}
