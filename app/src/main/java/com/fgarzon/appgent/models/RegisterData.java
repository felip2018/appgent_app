package com.fgarzon.appgent.models;

public class RegisterData {

     private int documentTypeId;
     private long document;
     private int cityId;
     private String address;
     private String firstName;
     private String secondName;
     private String firstLastname;
     private String secondLastname;
     private String phone;
     private String email;
     private int profileId;
     private String password;


    public RegisterData() {
         this.cityId = 3;
         this.address = "no_data";
         this.profileId = 2;
     }

    public int getDocumentTypeId() {
        return documentTypeId;
    }

    public void setDocumentTypeId(int documentTypeId) {
        this.documentTypeId = documentTypeId;
    }

    public long getDocument() {
        return document;
    }

    public void setDocument(long document) {
        this.document = document;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
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

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "RegisterData{" +
                "documentTypeId=" + documentTypeId +
                ", document=" + document +
                ", cityId=" + cityId +
                ", address='" + address + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", firstLastname='" + firstLastname + '\'' +
                ", secondLastname='" + secondLastname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", profileId=" + profileId +
                ", password='" + password + '\'' +
                '}';
    }
}
