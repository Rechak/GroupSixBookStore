package com.bookstore.userprofile.UserProfiles;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class CreditCardConfig {
    @Bean
    CommandLineRunner commandLineRunnerCC(CreditCardRepository creditCardRepository) {
        return args -> {
            CreditCard Max = new CreditCard(
                    "MadMaxThePhoto",
                    "Max Price",
                    "1234 5678 9101 1121",
                    "123",
                    LocalDate.of(2025, 10, 1));
            CreditCard Jean = new CreditCard(
                    "jeanboy104",
                    "Jean Doe",
                    "1234 5678 9101 1121",
                    "333",
                    LocalDate.of(2024, 11, 22));
            CreditCard Jane = new CreditCard(
                    "janeSmith101",
                    "Jane Smith",
                    "1234 5678 9101 1121",
                    "321",
                    LocalDate.of(2030, 1, 20));

            creditCardRepository.saveAll(
                    List.of(Jane, Jean, Max)
            );
        };

    }
}
