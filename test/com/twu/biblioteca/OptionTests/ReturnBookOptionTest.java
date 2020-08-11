package com.twu.biblioteca.OptionTests;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.Movie;
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

import static com.twu.biblioteca.Constants.RETURN_BOOK_SUCCESS_MESSAGE;
import static org.junit.Assert.assertEquals;

public class ReturnBookOptionTest {
    private ArrayList<Book> books = new ArrayList<Book>();
    private ArrayList<Movie> movies = new ArrayList<Movie>();
    private Library library;
    private Book book1;
    private Book book2;
    private ByteArrayInputStream inContent;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private Scanner scanner;

    @Before
    public void setUpStreams() {
        String input = "0";
        inContent = new ByteArrayInputStream(input.getBytes());

        System.setIn(inContent);
        System.setOut(new PrintStream(outContent));
        scanner = new Scanner(System.in);
    }

    @Before
    public void setUp() {
        book1 = new Book("title1", "author1", "2020");
        book2 = new Book("title2", "author2", "2020");
        books.add(book1);
        books.add(book2);

        library = new Library(books, movies);
        library.checkoutBook(book1);
    }

    @Test
    public void returnBookOptionWhenRunAndBookBelongsToLibraryShouldOutputSuccessMessage() {
        Option returnBookOption = new ReturnBookOption();
        returnBookOption.run(library, scanner, null);
        String expectedOutput = "Select a book that you would like to return ... Or type 'back' to go back to options\n" +
                "0) title1,author1,2020\n\n" +
                RETURN_BOOK_SUCCESS_MESSAGE + "\n";
        String actualOutput = outContent.toString().trim() + "\n";
        assertEquals(expectedOutput, actualOutput);
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }
}
