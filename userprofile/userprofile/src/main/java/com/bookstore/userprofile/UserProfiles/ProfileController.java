package com.bookstore.userprofile.UserProfiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

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

    @GetMapping(path = "creditcard")
    public List<CreditCard> getUserCreditCards(){
        return profileService.getuserprofileCC();
    }
    //user by id
    @GetMapping(path = "{profileUsername}")
    public Optional<UserProfiles> profileById(@PathVariable("profileUsername") String profileUsername) {
        return profileService.profileById(profileUsername);
    }
    @GetMapping(path = "creditcard/{profileUsername}")
    public Optional<CreditCard> creditCardById(@PathVariable("profileUsername") String profileUsername) {
        return profileService.creditCardById(profileUsername);
    }
    @PostMapping
    public void registerNewProfile(@RequestBody UserProfiles profiles){
        profileService.addNewProfile(profiles);
    }

    @PostMapping(path = "/creditcard")
    public void registerNewCC(@RequestBody CreditCard creditCard){
        profileService.addNewCC(creditCard);
    }

    @DeleteMapping(path = "{profileUsername}")
    public void deleteProfile(@PathVariable("profileUsername") String profileUsername){
        profileService.deleteProfile(profileUsername);
        profileService.deleteCreditCard(profileUsername);
    }

    @PutMapping(path = "{profileUsername}")
    public void updateProfile(
            @PathVariable("profileUsername") String profileUsername,
            @RequestParam(required = false) String password,
            @RequestParam(required = false) String fullName,
            @RequestParam(required = false) String homeAddress
    )
    {
        profileService.updateProfile(profileUsername, password, fullName, homeAddress);
    }
}
