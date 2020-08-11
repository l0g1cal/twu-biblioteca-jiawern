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

import static com.twu.biblioteca.Constants.CHECKOUT_MOVIE_SUCCESS_MESSAGE;
import static org.junit.Assert.assertEquals;

public class CheckoutMovieOptionTest {
    private ArrayList<Book> books = new ArrayList<Book>();
    private ArrayList<Movie> movies = new ArrayList<Movie>();
    private Library library;
    private Movie movie1;
    private Movie movie2;
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
        movie1 = new Movie("title1","2020", "director1");
        movie2 = new Movie("title2","2020", "director2", 9);
        movies.add(movie1);
        movies.add(movie2);

        library = new Library(books, movies);
    }

    @Test
    public void checkoutMovieOptionWhenRunAndMovieAvailableShouldReturnListOfMoviesAndOutputSuccessMessage() {
        Option checkoutMovieOption = new CheckoutMovieOption();
        checkoutMovieOption.run(library, scanner, null);
        String expectedOutput = "Select a movie that you would like to checkout ... Or type 'back' to go back to options\n" +
                "Here is the list of movies in this Biblioteca\n" +
                "0) title1,2020,director1\n" +
                "1) title2,2020,director2,9\n\n" +
                CHECKOUT_MOVIE_SUCCESS_MESSAGE + "\n";
        String actualOutput = outContent.toString().trim() + "\n";
        assertEquals(expectedOutput, actualOutput);
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

}
