package com.twu.biblioteca;

public class User {
    private String name;
    private String libraryNumber;
    private String password;
    private String email;
    private String phoneNumber;
    private boolean isLibrarian;

    public User(String name, String libraryNumber, String password, String email, String phoneNumber, boolean isLibrarian) {
        this.name = name;
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.isLibrarian = isLibrarian;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public String getPassword() {
        return password;
    }

    public boolean login(String libraryNumber, String password) {
        return this.libraryNumber.equals(libraryNumber) && this.password.equals(password);
    }

    public boolean isUserLibrarian() {
        return isLibrarian;
    }

    @Override
    public String toString() {
        return name + ": " + libraryNumber;
    }

    public String pprintUserInfo() {
        return name + "," + email + "," + phoneNumber + "\n";
    }
}
