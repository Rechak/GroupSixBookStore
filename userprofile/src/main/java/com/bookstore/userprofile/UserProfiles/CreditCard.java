package com.bookstore.userprofile.UserProfiles;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;

@Entity
@Table(name = "credit_card")
public class CreditCard{
    @Id
    @GenericGenerator(name = "username", strategy = "username2")
    //@Column(name = "username")
    @JoinColumn(name = "user_profiles_username")
    private String username;
    private String fullName;
    private String ccNumber;
    private String ccCVV;
    private LocalDate ccExpire;

    public CreditCard(){
    }
    public CreditCard(String username,
                      String fullName,
                      String ccNumber,
                      String ccCVV,
                      LocalDate ccExpire){
        this.username = username;
        this.fullName = fullName;
        this.ccNumber = ccNumber;
        this.ccCVV = ccCVV;
        this.ccExpire = ccExpire;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getCcNumber() {
        return ccNumber;
    }

    public void setCcNumber(String ccNumber) {
        this.ccNumber = ccNumber;
    }

    public String getCcCVV() {
        return ccCVV;
    }

    public void setCcCVV(String ccCVV) {
        this.ccCVV = ccCVV;
    }

    public LocalDate getCcExpire() {
        return ccExpire;
    }

    public void setCcExpire(LocalDate ccExpire) {
        this.ccExpire = ccExpire;
    }
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "username='" + username + '\'' +
                ", fullName='" + fullName + '\'' +
                ", ccNumber='" + ccNumber + '\'' +
                ", ccCVV='" + ccCVV + '\'' +
                ", ccExpire='" + ccExpire + '\'' +
                '}';

    }

}
