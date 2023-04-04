package com.bookstore.userprofile.UserProfiles;
import org.springframework.stereotype.Service;
import java.util.List;

//Service layer
@Service //what needs to be instantiated, Service improves readability
public class ProfileService {
    public List<UserProfiles> getUserProfiles(){
        return List.of(new UserProfiles(
                "marySmith101",
                "theOneandOnlymary",
                "Mary Smith",
                "MSmith@gmail.com",
                "12345 Falcon Dr, Somewhere, Fl, 12345"
        ));
    }
}
