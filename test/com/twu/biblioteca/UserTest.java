package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {

    @Test
    public void loginUserWhenCorrectCredentialsShouldReturnTrue() {
        User user1 = new User("user1", "123-45678", "p1", "user1@gmail.com", "12345678", true);

        assertEquals(true, user1.login("123-45678", "p1"));
    }
}
