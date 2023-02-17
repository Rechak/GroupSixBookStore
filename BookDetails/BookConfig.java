package group6.bookstore.BookDetails;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BookConfig {
    @Bean
    CommandLineRunner commandLineRunner(BookRepository repository){
        return args -> {
            Book hogwarts = new Book(
                    172839478L,
                    "Hogwarts",
                    "Harry Potter",
                    30.42,
                    "JK Rowling",
                    "Science Fiction",
                    "Paradox",
                    2004,
                    400L
            );
            Book hunger = new Book(
                    16728364172L,
                    "Hunger Games",
                    "Bow girl",
                    15.97,
                    "Katniss Everdeen",
                    "drama",
                    "WB",
                    2009,
                    9000L
            );

            repository.saveAll(
                    List.of(hunger, hogwarts)
            );
        };
    }
}
