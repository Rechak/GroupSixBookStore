package com.bookstore.userprofile.UserProfiles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CreditCardRepository
        extends JpaRepository<CreditCard,String> {
    //In postgres = SELECT * FROM user_profiles WHERE username = ?
    @Query("SELECT p FROM CreditCard p WHERE p.username = ?1")
    public abstract Optional<CreditCard> findCCByUsername(String username);
}
