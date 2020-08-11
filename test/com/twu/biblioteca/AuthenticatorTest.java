package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class AuthenticatorTest {
    private ArrayList<User> users = new ArrayList<User>();
    private Authenticator authenticator;

    @Before
    public void setUp() {
        User user1 = new User("user1", "123-45678", "p1", "user1@gmail.com", "12345678", true);
        User user2 = new User("user2", "234-56789", "p2", "user2@gmail.com", "87654321",false);
        users.add(user1);
        users.add(user2);

        authenticator = new Authenticator(users);
    }

    @Test
    public void authenticateUserWhenCorrectCredentialsShouldReturnUser() {
        String libraryNumber = "123-45678";
        String password = "p1";

        User user = authenticator.login(libraryNumber, password);

        assertEquals("123-45678", user.getLibraryNumber());
        assertEquals("p1", user.getPassword());
    }

    @Test
    public void testUserLoginWithIncorrectCredentials() {
        String libraryNumber = "123-45678";
        String password = "p1234";

        User user = authenticator.login(libraryNumber, password);

        assertNull(user);
    }
}
