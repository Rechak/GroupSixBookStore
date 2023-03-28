package com.bookstore.userprofile.UserProfiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping(path = "api/v1/userprofile")
public class ProfileController {

    @Autowired //instantiates profileService
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    private final ProfileService profileService;
    @GetMapping()
    public List<UserProfiles> getUserProfiles(){
        return profileService.getUserProfiles();
    }

}
