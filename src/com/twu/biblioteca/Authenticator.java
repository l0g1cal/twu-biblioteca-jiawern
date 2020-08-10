package com.twu.biblioteca;

import java.util.ArrayList;

public class Authenticator {
    private ArrayList<User> users;

    public Authenticator(ArrayList<User> users) {
        this.users = users;
    }

    public User login(String libraryNumber, String password) {
        for (User user : users) {
            boolean isLoginSuccessful = user.login(libraryNumber, password);

            if (isLoginSuccessful) {
                return user;
            }
        }
        return null;
    }
}
