package com.bookstore.userprofile.UserProfiles;
import jakarta.transaction.Transactional;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

//Service layer
@Service //what needs to be instantiated, Service improves readability
public class ProfileService {

    private final ProfileRepository profileRepository;
    @Autowired
    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    //Gets all userprofiles
    public List<UserProfiles> getUserProfiles(){
        return profileRepository.findAll();
    }

    //posts new students
    public void addNewProfile(UserProfiles profiles) {
        Optional<UserProfiles> profileOptional =
                profileRepository.findProfileByUsername(profiles.getUsername());

        if(profileOptional.isPresent()){
            throw new IllegalStateException("Username taken");
        }
        profileRepository.save(profiles);
    }

    //Deletes existing students
    public void deleteProfile(String profileUsername) {
        boolean exists = profileRepository.existsById(profileUsername);

        if(!exists){
            throw new IllegalStateException("Username with " + profileUsername + "does not exist");
        }
        profileRepository.deleteById(profileUsername);
    }

    @Transactional
    public void updateProfile(String profileUsername,
                              String username,
                              String password,
                              String fullName,
                              String homeAddress) {
        UserProfiles userProfiles = profileRepository.findById(profileUsername)
                .orElseThrow(() -> new IllegalStateException(
                        "Profile with username " + profileUsername + " does not exist"));

        if(username != null
                && username.length() > 0
                && !Objects.equals(userProfiles.getUsername(), username)){
            userProfiles.setUsername(username);
        }
        if(password != null
                && password.length() > 0
                && !Objects.equals(userProfiles.getPassword(), password)){
            userProfiles.setPassword(password);
        }
        if(fullName != null
                && fullName.length() > 0
                && !Objects.equals(userProfiles.getFullName(), fullName)){
            userProfiles.setFullName(fullName);
        }
        if(homeAddress != null
                && homeAddress.length() > 0
                && !Objects.equals(userProfiles.getHomeAddress(), homeAddress)){
            userProfiles.setHomeAddress(homeAddress);
        }
    }
}
