package com.bookstore.userprofile.UserProfiles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository
        extends JpaRepository<UserProfiles, String> {
    //In postgres = SELECT * FROM user_profiles WHERE username = ?
    @Query("SELECT p FROM UserProfiles p WHERE p.username = ?1")
    Optional<UserProfiles> findProfileByUsername(String username);


}
