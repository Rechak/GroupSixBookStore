package com.bookstore.userprofile.UserProfiles;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

//Service layer
@Service //what needs to be instantiated, Service improves readability
public class ProfileService {

    private final ProfileRepository profileRepository;
    private final CreditCardRepository creditCardRepository;
    @Autowired
    public ProfileService(ProfileRepository profileRepository, CreditCardRepository creditCardRepository) {
        this.profileRepository = profileRepository;
        this.creditCardRepository = creditCardRepository;
    }

    //Gets all userprofile
    public List<UserProfiles> getUserProfiles(){
        return profileRepository.findAll();
    }

    public List<CreditCard> getuserprofileCC() {return creditCardRepository.findAll();}

    //posts new students
    public void addNewProfile(UserProfiles profiles) {
        Optional<UserProfiles> profileOptional =
                profileRepository.findProfileByUsername(profiles.getUsername());

        if(profileOptional.isPresent()){
            throw new IllegalStateException("Username taken");
        }
        profileRepository.save(profiles);
    }
    public void addNewCC(CreditCard creditCard) {
        Optional<UserProfiles> profilesOptional =
                profileRepository.findById(creditCard.getUsername());

        if(!profilesOptional.isPresent()){
            throw new IllegalStateException("Username Does Not Exist");
        }
        creditCardRepository.save(creditCard);
    }


    //Deletes existing students
    public void deleteProfile(String profileUsername) {
        boolean exists = profileRepository.existsById(profileUsername);

        if(!exists){
            throw new IllegalStateException("Username with " + profileUsername + "does not exist");
        }
        profileRepository.deleteById(profileUsername);
    }
    public void deleteCreditCard(String profileUsername) {
        boolean exists = creditCardRepository.existsById(profileUsername);

        if(!exists){
            throw new IllegalStateException("Username with " + profileUsername + "does not exist");
        }
        creditCardRepository.deleteById(profileUsername);
    }

    @Transactional
    public void updateProfile(String profileUsername,
                              String password,
                              String fullName,
                              String homeAddress) {
        UserProfiles userProfiles = profileRepository.findById(profileUsername)
                .orElseThrow(() -> new IllegalStateException(
                        "Profile with username " + profileUsername + " does not exist"));

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

    public Optional<UserProfiles> profileById(String profileUsername) {
            Optional<UserProfiles> profileOptional =
                    profileRepository.findById(profileUsername);
            if(!profileOptional.isPresent()){
                throw new IllegalStateException("Id does not exist");
            }
            return profileRepository.findProfileByUsername(profileUsername);
    }
    public Optional<CreditCard> creditCardById(String profileUsername) {
        Optional<CreditCard> profileOptional =
                creditCardRepository.findById(profileUsername);
        if(!profileOptional.isPresent()){
            throw new IllegalStateException("Id does not exist");
        }
        return creditCardRepository.findCCByUsername(profileUsername);
    }
}
