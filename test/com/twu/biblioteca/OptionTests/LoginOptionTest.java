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

import static com.twu.biblioteca.Constants.LOGIN_SUCCESS_MESSAGE;
import static org.junit.Assert.assertEquals;

public class LoginOptionTest {
    private ArrayList<User> users = new ArrayList<User>();
    private Authenticator authenticator;
    private ByteArrayInputStream inContent;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private Scanner scanner;

    @Before
    public void setUpStreams() {
        String input = "123-45678,p1";
        inContent = new ByteArrayInputStream(input.getBytes());

        System.setIn(inContent);
        System.setOut(new PrintStream(outContent));
        scanner = new Scanner(System.in);
    }

    @Before
    public void setUp() {
        User user1 = new User("user1", "123-45678", "p1", true);
        User user2 = new User("user2", "234-56789", "p2", false);
        users.add(user1);
        users.add(user2);
        authenticator = new Authenticator(users);
    }

    @Test
    public void loginOptionWhenRunAndValidUserShouldReturnUserAndOutputSuccessMessage() {
        Option loginOption = new LoginOption();
        loginOption.run(null, scanner, authenticator);
        String expectedOutput = "Please enter your login details ... Or type 'back' to go back to options\n" +
                "Format: libraryNumber,password\n" +
                "Eg: 111-11111,passWORD\n\n" +
                LOGIN_SUCCESS_MESSAGE + "\n";
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
