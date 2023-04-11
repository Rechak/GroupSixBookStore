package com.bookstore.userprofile.UserProfiles;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class ProfileConfig {
    @Bean
    CommandLineRunner commandLineRunner(ProfileRepository repository) {
        return args -> {
            UserProfiles Jane = new UserProfiles(
                    "janeSmith101",
                    "theOneandOnlyjane",
                    "Jane Smith",
                    "JSmith@gmail.com",
                    "12345 Falcon Dr, Somewhere, Fl, 12345"
            );
            UserProfiles Jean = new UserProfiles(
                    "jeanboy104",
                    "wannabemainchar",
                    "Jean Doe",
                    "j.doe@gmail.com",
                    "12345 Horse Rd, Attica, Fl, 12245"
            );
            UserProfiles Max = new UserProfiles(
                    "MadMaxThePhoto",
                    "MaybeaRef",
                    "Max Price",
                    "MPrice@gmail.com",
                    "12345 Camera Rd, Arcadia, Fl, 15268"
            );

            repository.saveAll(
                    List.of(Jane, Jean, Max)
            );
        };

    }
}