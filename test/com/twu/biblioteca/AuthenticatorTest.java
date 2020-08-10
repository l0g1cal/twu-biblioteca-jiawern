package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AuthenticatorTest {

    @Test
    public void testUserLoginWithCorrectCredentials() {
        String libraryNumber = "123-45678";
        String password = "hello123";
        Authenticator authenticator = new Authenticator();

        User user = authenticator.login(libraryNumber, password);

        assertEquals("123-45678", user.getLibraryNumber());
        assertEquals("hello123", user.getPassword());
    }
}
