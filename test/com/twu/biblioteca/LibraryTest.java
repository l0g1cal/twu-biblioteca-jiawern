package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class LibraryTest {
    private final ArrayList<Book> books = new ArrayList<>();
    private final ArrayList<Movie> movies = new ArrayList<>();
    private User currentUser;
    private Library library;

    @Before
    public void setUp() {
        Book book1 = new Book("title1", "author1", "2020");
        books.add(book1);

        Movie movie1 = new Movie("title1", "2020", "director1");
        movies.add(movie1);

        library = new Library(books, movies);
        currentUser = new User("user1", "123-45678", "p1", "user1@gmail.com", "12345678", true);
    }

    @Test
    public void checkoutBookWhenBookAvailableShouldReturnTrueAndMakeBookUnavailable() {
        assertEquals(1, library.totalBooksInLibrary());
        assertEquals(0, library.totalBorrowedBooks(currentUser));

        Book bookToCheckout = books.get(0);
        boolean output = library.checkoutBook(bookToCheckout, currentUser);
        assertTrue(output);
        assertEquals(0, library.totalBooksInLibrary());
        assertEquals(1, library.totalBorrowedBooks(currentUser));
    }

    @Test
    public void checkoutBookWhenBookUnavailableShouldReturnFalse() {
        assertEquals(1, library.totalBooksInLibrary());
        assertEquals(0, library.totalBorrowedBooks(currentUser));

        Book bookToCheckout = books.get(0);
        library.checkoutBook(bookToCheckout, currentUser);
        assertEquals(0, library.totalBooksInLibrary());
        assertEquals(1, library.totalBorrowedBooks(currentUser));

        boolean output_unavailable = library.checkoutBook(bookToCheckout, currentUser);
        assertFalse(output_unavailable);
        assertEquals(0, library.totalBooksInLibrary());
        assertEquals(1, library.totalBorrowedBooks(currentUser));
    }

    @Test
    public void returnBookWhenBookBelongsToLibraryShouldReturnTrueAndMakeBookAvailable() {
        assertEquals(1, library.totalBooksInLibrary());
        assertEquals(0, library.totalBorrowedBooks(currentUser));

        Book bookToCheckout = books.get(0);
        library.checkoutBook(bookToCheckout, currentUser);
        assertEquals(0, library.totalBooksInLibrary());
        assertEquals(1, library.totalBorrowedBooks(currentUser));

        boolean returnOutput = library.returnBook(bookToCheckout, currentUser);
        assertTrue(returnOutput);
        assertEquals(1, library.totalBooksInLibrary());
        assertEquals(0, library.totalBorrowedBooks(currentUser));
    }

    @Test
    public void returnBookWhenBookDoesNotBelongToLibraryShouldReturnFalse() {
        assertEquals(1, library.totalBooksInLibrary());
        assertEquals(0, library.totalBorrowedBooks(currentUser));

        Book bookToCheckout = books.get(0);
        library.checkoutBook(bookToCheckout, currentUser);
        library.returnBook(bookToCheckout, currentUser);
        assertEquals(1, library.totalBooksInLibrary());
        assertEquals(0, library.totalBorrowedBooks(currentUser));

        boolean returnOutput = library.returnBook(bookToCheckout, currentUser);
        assertFalse(returnOutput);
        assertEquals(1, library.totalBooksInLibrary());
        assertEquals(0, library.totalBorrowedBooks(currentUser));
    }
}
