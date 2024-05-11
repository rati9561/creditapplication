package com.shreeganeshfinance.creditapplication.pojo;



import java.util.Date;

import com.shreeganeshfinance.creditapplication.validation.ValidUserName;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private Long id;
    @NotNull(message = "Username cannot be blank/null")
    @NotBlank(message = "Username cannot be blank/null")
    @ValidUserName(message = "The username should be of greater than 3 characters and lessthan or equal to 20 characters")
    @Column(name = "username")
    private String username;
    @NotBlank(message = "message = first name cannot be blank/null")
    @Column(name = "first_name")
    private String firstName;
    @NotBlank(message = "message = middle name cannot be blank/null")
    @Column(name = "middle_name")
    private String middleName;
    @NotBlank(message = "message = last name cannot be blank/null")
    @Column(name = "last_name")
    private String lastName;
    @NotBlank(message = "message = phone number cannot be blank/null")
    @Column(name = "phone_number")
    private String phoneNumber;
    @NotBlank(message = "message = adhaar number cannot be blank/null")
    @Column(name = "adhaar")
    private String adhaar;
    @NotBlank(message = "message = PAN cannot be blank/null")
    @Column(name = "pan")
    private String pan;
    @NotBlank(message = "message = address cannot be blank/null")
    @Column(name = "address")
    private String address;
    @Column(name = "gender")
    private String gender;
    @Column(name = "dob")
    private Date dob;
    @Column(name = "password")
    private String password;
    @Column(name = "timestamp")
    private Date timeStamp;




    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getMiddleName() {
        return middleName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getAdhaar() {
        return adhaar;
    }
    public void setAdhaar(String adhaar) {
        this.adhaar = adhaar;
    }
    public String getPan() {
        return pan;
    }
    public void setPan(String pan) {
        this.pan = pan;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public Date getDob() {
        return dob;
    }
    public void setDob(Date dob) {
        this.dob = dob;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }


    
}
