package com.twu.biblioteca;

public class User {
    private String name;
    private String libraryNumber;
    private String password;
    private boolean isLibrarian;

    public User(String name, String libraryNumber, String password, boolean isLibrarian) {
        this.name = name;
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.isLibrarian = isLibrarian;
    }

    @Override
    public String toString() {
        return name + ": " + libraryNumber;
    }
}
