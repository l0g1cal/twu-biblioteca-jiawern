package com.twu.biblioteca.OptionTests;

import com.twu.biblioteca.*;
import com.twu.biblioteca.option.Option;
import com.twu.biblioteca.option.ReturnBookOption;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import static com.twu.biblioteca.Constants.RETURN_BOOK_MESSAGE;
import static com.twu.biblioteca.Constants.RETURN_BOOK_SUCCESS_MESSAGE;
import static org.junit.Assert.assertEquals;

public class ReturnBookOptionTest {
    private final ArrayList<Book> books = new ArrayList<>();
    private final ArrayList<Movie> movies = new ArrayList<>();
    private Library library;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private Scanner scanner;

    @Before
    public void setUpStreams() {
        String input = "0";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());

        System.setIn(inContent);
        System.setOut(new PrintStream(outContent));
        scanner = new Scanner(System.in);
    }

    @Before
    public void setUp() {
        Book book1 = new Book("title1", "author1", "2020");
        Book book2 = new Book("title2", "author2", "2020");
        books.add(book1);
        books.add(book2);

        library = new Library(books, movies);
        User currentUser = new User("user1", "123-45678", "p1", "user1@gmail.com", "12345678", true);

        library.checkoutBook(book1, currentUser);
        BibliotecaApp.setCurrentUser(currentUser);
    }

    @Test
    public void returnBookOptionWhenRunAndBookBelongsToLibraryShouldOutputSuccessMessage() {
        Option returnBookOption = new ReturnBookOption();
        returnBookOption.run(library, scanner, null);
        String expectedOutput = RETURN_BOOK_MESSAGE + "\n" +
                "0) title1,author1,2020\n\n" +
                RETURN_BOOK_SUCCESS_MESSAGE;
        String actualOutput = outContent.toString().trim() + "\n";
        assertEquals(expectedOutput, actualOutput);
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }
}
