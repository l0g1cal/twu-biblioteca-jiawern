package com.twu.biblioteca.OptionTests;

import com.twu.biblioteca.*;
import com.twu.biblioteca.option.Option;
import com.twu.biblioteca.option.ViewBorrowedBooksOption;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static com.twu.biblioteca.Constants.VIEW_BORROWED_BOOKS_MESSAGE;
import static org.junit.Assert.assertEquals;

public class ViewBorrowedBooksOptionTest {
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
        Book book3 = new Book("title3", "author3", "2020");
        books.add(book1);
        books.add(book2);
        books.add(book3);

        library = new Library(books, movies);
        User user1 = new User("user1", "123-45678", "p1", "user1@gmail.com", "12345678", false);
        User user2 = new User("user2", "234-56789", "p2", "user2@gmail.com", "87654321", false);

        library.checkoutBook(book1, user1);
        library.checkoutBook(book2, user2);
        library.checkoutBook(book3, user2);
    }

    @Test
    public void returnBookOptionWhenRunAndBookBelongsToLibraryShouldOutputSuccessMessage() {
        Option viewBorrowedBooksOption = new ViewBorrowedBooksOption();
        viewBorrowedBooksOption.run(library, null, null);
        String expectedOutput = VIEW_BORROWED_BOOKS_MESSAGE + "\n" +
                "Details: user1,user1@gmail.com,12345678\n" +
                "Library Number: 123-45678\n" +
                "0) title1,author1,2020\n\n" +
                "Details: user2,user2@gmail.com,87654321\n" +
                "Library Number: 234-56789\n" +
                "0) title2,author2,2020\n" +
                "1) title3,author3,2020\n";
        String actualOutput = outContent.toString().trim() + "\n";
        assertEquals(expectedOutput, actualOutput);
    }
}
