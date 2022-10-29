package com.fgarzon.appgent.models;

public class UserData {

    private String document;
    private String address;
    private String firstName;
    private String secondName;
    private String firstLastname;
    private String secondLastname;
    private String phone;
    private String email;
    private String userId;
    private String personId;
    private String profileId;
    private String username;
    private String validateAccount;
    private String registerStatus;
    private String profile;
    private String abbreviation;
    private String city;

    public UserData() {}

    public UserData(String document,
                    String address,
                    String firstName,
                    String secondName,
                    String firstLastname,
                    String secondLastname,
                    String phone,
                    String email,
                    String userId,
                    String personId,
                    String profileId,
                    String username,
                    String validateAccount,
                    String registerStatus,
                    String profile,
                    String abbreviation,
                    String city) {
        this.document = document;
        this.address = address;
        this.firstName = firstName;
        this.secondName = secondName;
        this.firstLastname = firstLastname;
        this.secondLastname = secondLastname;
        this.phone = phone;
        this.userId = userId;
        this.email = email;
        this.personId = personId;
        this.profileId = profileId;
        this.username = username;
        this.validateAccount = validateAccount;
        this.registerStatus = registerStatus;
        this.profile = profile;
        this.abbreviation = abbreviation;
        this.city = city;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFirstLastname() {
        return firstLastname;
    }

    public void setFirstLastname(String firstLastname) {
        this.firstLastname = firstLastname;
    }

    public String getSecondLastname() {
        return secondLastname;
    }

    public void setSecondLastname(String secondLastname) {
        this.secondLastname = secondLastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getValidateAccount() {
        return validateAccount;
    }

    public void setValidateAccount(String validateAccount) {
        this.validateAccount = validateAccount;
    }

    public String getRegisterStatus() {
        return registerStatus;
    }

    public void setRegisterStatus(String registerStatus) {
        this.registerStatus = registerStatus;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
