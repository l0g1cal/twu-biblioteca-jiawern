package com.twu.biblioteca;

public final class Constants {

    private Constants() {}

    public static final String WELCOME_MESSAGE = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    public static final String CHECKOUT_BOOK_SUCCESS_MESSAGE = "Thank you! Enjoy the book!";
    public static final String CHECKOUT_BOOK_FAILURE_MESSAGE = "Sorry, that book is unavailable";
    public static final String RETURN_BOOK_SUCCESS_MESSAGE = "Thank you for returning the book.";
    public static final String RETURN_BOOK_FAILURE_MESSAGE = "That is not a valid book to return.";
    public static final String CHECKOUT_MOVIE_SUCCESS_MESSAGE = "Thank you! Enjoy the movie!";
    public static final String CHECKOUT_MOVIE_FAILURE_MESSAGE = "Sorry, that movie is unavailable";

    public static final Integer DISPLAY_BOOKS_OPTION = 1;
    public static final String DISPLAY_BOOKS_OPTION_DESC = "List of books";

    public static final Integer CHECKOUT_BOOK_OPTION = 2;
    public static final String CHECKOUT_BOOK_OPTION_DESC = "Checkout book";

    public static final Integer RETURN_BOOK_OPTION = 3;
    public static final String RETURN_BOOK_OPTION_DESC = "Return book";

    public static final Integer DISPLAY_MOVIES_OPTION = 4;
    public static final String DISPLAY_MOVIES_OPTION_DESC = "List of movies";

    public static final Integer CHECKOUT_MOVIE_OPTION = 5;
    public static final String CHECKOUT_MOVIE_OPTION_DESC = "Checkout movie";
}
