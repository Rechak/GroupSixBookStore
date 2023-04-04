package com.bookstore.userprofile.UserProfiles;

import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public void registerNewProfile(@RequestBody UserProfiles profiles){
        profileService.addNewProfile(profiles);
    }
    @DeleteMapping(path = "{profileUsername}")
    public void deleteProfile(@PathVariable("profileUsername") String profileUsername){
        profileService.deleteProfile(profileUsername);
    }

    public void updateProfile(
            @PathVariable("profileUsername") String profileUsername,
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String password,
            @RequestParam(required = false) String fullName,
            @RequestParam(required = false) String homeAddress){
        profileService.updateProfile(profileUsername, username, password, fullName, homeAddress);
    }

}
