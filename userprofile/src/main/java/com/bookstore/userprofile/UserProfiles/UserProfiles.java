package com.bookstore.userprofile.UserProfiles;
import org.hibernate.annotations.GenericGenerator;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "user_profiles")
public class UserProfiles {

    //this sets the profile ID to the username
    @Id
    @GenericGenerator(name = "username", strategy = "username2")
    @Column(name = "username")
    private String username;
    private String password;
    private String fullName;
    private String emailAddress;
    private String homeAddress;
   @OneToMany(mappedBy = "username")
    private List<CreditCard> creditCards;

    public UserProfiles() {
    }

    public UserProfiles(String username,
                        String password,
                        String fullName,
                        String emailAddress,
                        String homeAddress) {

        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.emailAddress = emailAddress;
        this.homeAddress = homeAddress;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    @Override
    public String toString() {
        return "UserProfiles{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", homeAddress='" + homeAddress + '\'' +
                '}';
    }
}


