package com.example.hp.nopain.models;

public class User {

    private int id;
    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private String password;


    public User(String firstname, String lastname, String username, String email, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(int id, String firstname, String lastname){
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.email = email;
    }

    public User(int id, String firstname, String lastname, String username, String email, String password) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstname;
    }

    public String getLastName() {
        return lastname;
    }

    public String getUserName() {
        return username;
    }


    public String getEmail() {
        return email;
    }

    public String getPassword(){
        return password;
    }

}