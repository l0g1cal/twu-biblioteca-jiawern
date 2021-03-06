package com.twu.biblioteca.OptionTests;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.Movie;
import com.twu.biblioteca.option.DisplayMoviesOption;
import com.twu.biblioteca.option.Option;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static com.twu.biblioteca.Constants.MOVIE_LIST_MESSAGE;
import static org.junit.Assert.assertEquals;

public class DisplayMoviesOptionTest {
    private final ArrayList<Book> books = new ArrayList<>();
    private final ArrayList<Movie> movies = new ArrayList<>();
    private Library library;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
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
    public void displayMoviesOptionWhenRunShouldReturnListOfMovies() {
        Option displayOption = new DisplayMoviesOption();
        displayOption.run(library, null, null);
        String expectedOutput = MOVIE_LIST_MESSAGE + "\n" +
                "0) title1,2020,director1\n" +
                "1) title2,2020,director2,9\n";
        String actualOutput = outContent.toString().trim() + "\n";
        assertEquals(expectedOutput, actualOutput);
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}
