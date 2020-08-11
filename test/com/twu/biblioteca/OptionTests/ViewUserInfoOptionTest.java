package com.twu.biblioteca.OptionTests;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.User;
import com.twu.biblioteca.option.Option;
import com.twu.biblioteca.option.ViewUserInfoOption;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static com.twu.biblioteca.Constants.USER_INFO_LIST_MESSAGE;
import static org.junit.Assert.assertEquals;

public class ViewUserInfoOptionTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Before
    public void setUp() {
        User user1 = new User("user1", "123-45678", "p1", "user1@gmail.com", "12345678", true);
        BibliotecaApp.setCurrentUser(user1);
    }

    @Test
    public void displayMoviesOptionWhenRunShouldReturnListOfMovies() {
        Option viewUserInfoOption = new ViewUserInfoOption();
        viewUserInfoOption.run(null, null, null);
        String expectedOutput = USER_INFO_LIST_MESSAGE + "\n" +
                "user1,user1@gmail.com,12345678\n";
        String actualOutput = outContent.toString().trim() + "\n";
        assertEquals(expectedOutput, actualOutput);
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}
