package org.example;

import java.sql.Connection;
import java.util.Date;

public class User {
    // Nome dell'utente
    private String name;
    // Cognome dell'utente
    private String surname;
    // Email dell'utente || Unique
    private String email;
    // Password
    private String password;
    // Numero di telefono dell'utente || Unique
    private String phone_number;
    // Stato dell'utente
    private Boolean active;
    // Data di registrazione (Ha senso??)
    private Date date_of_registration;
    private String address;
    private String country;

    public User(String name, String surname, String email, String password, String phone_number, Boolean active, Date date_of_registration,String address, String country) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.phone_number = phone_number;
        this.active = active;
        this.date_of_registration = date_of_registration;
        this.address = address;
        this.country = country;
    }

    // Metodi Getter
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getActive() {
        return active;
    }

    public Date getDate_of_registration() {
        return date_of_registration;
    }

    public String getPhone_number() {
        return phone_number;
    }

    // Metodi Setter
    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAddress() {
        return address;
    }

    public String getCountry() {
        return country;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void login(String email, String password){

    }

    public boolean register(){
        //Connection co
        return true;
    }

}
