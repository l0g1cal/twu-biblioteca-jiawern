package com.twu.biblioteca.OptionTests;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.Movie;
import com.twu.biblioteca.option.CheckoutMovieOption;
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

import static com.twu.biblioteca.Constants.*;
import static org.junit.Assert.assertEquals;

public class CheckoutMovieOptionTest {
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
        Movie movie1 = new Movie("title1", "2020", "director1");
        Movie movie2 = new Movie("title2", "2020", "director2", 9);
        movies.add(movie1);
        movies.add(movie2);

        library = new Library(books, movies);
    }

    @Test
    public void checkoutMovieOptionWhenRunAndMovieAvailableShouldReturnListOfMoviesAndOutputSuccessMessage() {
        Option checkoutMovieOption = new CheckoutMovieOption();
        checkoutMovieOption.run(library, scanner, null);
        String expectedOutput = SELECT_MOVIE_MESSAGE + "\n" + MOVIE_LIST_MESSAGE + "\n" +
                "0) title1,2020,director1\n" +
                "1) title2,2020,director2,9\n\n" +
                CHECKOUT_MOVIE_SUCCESS_MESSAGE;
        String actualOutput = outContent.toString().trim() + "\n";
        assertEquals(expectedOutput, actualOutput);
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

}
