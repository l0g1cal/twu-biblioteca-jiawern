package com.twu.biblioteca.OptionTests;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.Movie;
import com.twu.biblioteca.option.DisplayBooksOption;
import com.twu.biblioteca.option.Option;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static com.twu.biblioteca.Constants.BOOK_LIST_MESSAGE;
import static org.junit.Assert.assertEquals;

public class DisplayBooksOptionTest {
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
        Book book1 = new Book("title1", "author1", "2020");
        Book book2 = new Book("title2", "author2", "2020");
        books.add(book1);
        books.add(book2);

        library = new Library(books, movies);
    }

    @Test
    public void displayBooksOptionWhenRunShouldReturnListOfBooks() {
        Option displayOption = new DisplayBooksOption();
        displayOption.run(library, null, null);
        String expectedOutput = BOOK_LIST_MESSAGE + "\n" +
                "0) title1,author1,2020\n" +
                "1) title2,author2,2020\n";
        String actualOutput = outContent.toString().trim() + "\n";
        assertEquals(expectedOutput, actualOutput);
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}
