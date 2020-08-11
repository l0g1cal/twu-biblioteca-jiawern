package com.twu.biblioteca.OptionTests;

import com.twu.biblioteca.*;
import com.twu.biblioteca.option.LoginOption;
import com.twu.biblioteca.option.Option;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import static com.twu.biblioteca.Constants.LOGIN_MESSAGE;
import static com.twu.biblioteca.Constants.LOGIN_SUCCESS_MESSAGE;
import static org.junit.Assert.assertEquals;

public class LoginOptionTest {
    private final ArrayList<User> users = new ArrayList<>();
    private Authenticator authenticator;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private Scanner scanner;

    @Before
    public void setUpStreams() {
        String input = "123-45678,p1";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());

        System.setIn(inContent);
        System.setOut(new PrintStream(outContent));
        scanner = new Scanner(System.in);
    }

    @Before
    public void setUp() {
        User user1 = new User("user1", "123-45678", "p1", "user1@gmail.com", "12345678", true);
        User user2 = new User("user2", "234-56789", "p2", "user2@gmail.com", "87654321",false);
        users.add(user1);
        users.add(user2);
        authenticator = new Authenticator(users);
    }

    @Test
    public void loginOptionWhenRunAndValidUserShouldReturnUserAndOutputSuccessMessage() {
        Option loginOption = new LoginOption();
        loginOption.run(null, scanner, authenticator);
        String expectedOutput = LOGIN_MESSAGE + "\n" + LOGIN_SUCCESS_MESSAGE;
        String actualOutput = outContent.toString().trim() + "\n";
        assertEquals(expectedOutput, actualOutput);

        User currentUser = BibliotecaApp.getCurrentUser();
        assertEquals("123-45678", currentUser.getLibraryNumber());
        assertEquals("p1", currentUser.getPassword());
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }
}
