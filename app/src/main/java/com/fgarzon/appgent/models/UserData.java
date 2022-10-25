package com.fgarzon.appgent.models;

public class UserData {

    private String document;
    private String address;
    private String first_name;
    private String second_name;
    private String first_lastname;
    private String second_lastname;
    private String phone;
    private String email;
    private String person_id;
    private String profile_id;
    private String username;
    private String validate_account;
    private String register_status;
    private String profile;
    private String abbreviation;
    private String city;

    public UserData() {}

    public UserData(String document, String address, String first_name, String second_name, String first_lastname, String second_lastname, String phone, String email, String person_id, String profile_id, String username, String validate_account, String register_status, String profile, String abbreviation, String city) {
        this.document = document;
        this.address = address;
        this.first_name = first_name;
        this.second_name = second_name;
        this.first_lastname = first_lastname;
        this.second_lastname = second_lastname;
        this.phone = phone;
        this.email = email;
        this.person_id = person_id;
        this.profile_id = profile_id;
        this.username = username;
        this.validate_account = validate_account;
        this.register_status = register_status;
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

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public String getFirst_lastname() {
        return first_lastname;
    }

    public void setFirst_lastname(String first_lastname) {
        this.first_lastname = first_lastname;
    }

    public String getSecond_lastname() {
        return second_lastname;
    }

    public void setSecond_lastname(String second_lastname) {
        this.second_lastname = second_lastname;
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

    public String getPerson_id() {
        return person_id;
    }

    public void setPerson_id(String person_id) {
        this.person_id = person_id;
    }

    public String getProfile_id() {
        return profile_id;
    }

    public void setProfile_id(String profile_id) {
        this.profile_id = profile_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getValidate_account() {
        return validate_account;
    }

    public void setValidate_account(String validate_account) {
        this.validate_account = validate_account;
    }

    public String getRegister_status() {
        return register_status;
    }

    public void setRegister_status(String register_status) {
        this.register_status = register_status;
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
}
