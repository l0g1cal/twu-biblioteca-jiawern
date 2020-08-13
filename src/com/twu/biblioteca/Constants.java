package com.twu.biblioteca;

public final class Constants {

    private Constants() {}

    public static final String WELCOME_MESSAGE = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    public static final String EXIT_MESSAGE = "User requested to end program. Exiting ...";
    public static final String LOGIN_MESSAGE = "Please enter your login details ... Or type 'back' to go back to options\n" +
            "Format: libraryNumber,password\n" +
            "Eg: 111-11111,passWORD\n";


    public static final String SELECT_OPTION_MESSAGE = "Please select an option number to continue ... Or type 'exit' to end program";
    public static final String INCORRECT_OPTION_MESSAGE = "Please select a valid option!\n";
    public static final String SELECT_BOOK_MESSAGE = "Select a book that you would like to checkout ... Or type 'back' to go back to options";
    public static final String SELECT_MOVIE_MESSAGE = "Select a movie that you would like to checkout ... Or type 'back' to go back to options";
    public static final String RETURN_BOOK_MESSAGE = "Select a book that you would like to return ... Or type 'back' to go back to options";
    public static final String BOOK_LIST_MESSAGE = "Here is the list of books in this Biblioteca";
    public static final String MOVIE_LIST_MESSAGE = "Here is the list of movies in this Biblioteca";
    public static final String USER_INFO_LIST_MESSAGE = "Here is the list of information";
    public static final String NO_BORROWED_BOOKS_MESSAGE = "You currently do not have any borrowed books to return\n";
    public static final String VIEW_BORROWED_BOOKS_MESSAGE = "Here is the list of books borrowed by users\n";

    public static final String CHECKOUT_BOOK_SUCCESS_MESSAGE = "Thank you! Enjoy the book!\n";
    public static final String CHECKOUT_BOOK_FAILURE_MESSAGE = "Sorry, that book is unavailable\n";
    public static final String RETURN_BOOK_SUCCESS_MESSAGE = "Thank you for returning the book.\n";
    public static final String RETURN_BOOK_FAILURE_MESSAGE = "That is not a valid book to return.\n";
    public static final String CHECKOUT_MOVIE_SUCCESS_MESSAGE = "Thank you! Enjoy the movie!\n";
    public static final String CHECKOUT_MOVIE_FAILURE_MESSAGE = "Sorry, that movie is unavailable\n";
    public static final String LOGIN_SUCCESS_MESSAGE = "Login Successful\n";
    public static final String LOGIN_FAILURE_MESSAGE = "Sorry, please try logging in again\n";

    public static final Integer DISPLAY_BOOKS_OPTION = 1;
    public static final String DISPLAY_BOOKS_OPTION_DESC = "List of books";

    public static final Integer DISPLAY_MOVIES_OPTION = 2;
    public static final String DISPLAY_MOVIES_OPTION_DESC = "List of movies";

    public static final Integer LOGIN_OPTION = 3;
    public static final String LOGIN_OPTION_DESC = "Login";

    public static final Integer CHECKOUT_BOOK_OPTION = 4;
    public static final String CHECKOUT_BOOK_OPTION_DESC = "Checkout book";

    public static final Integer RETURN_BOOK_OPTION = 5;
    public static final String RETURN_BOOK_OPTION_DESC = "Return book";

    public static final Integer CHECKOUT_MOVIE_OPTION = 6;
    public static final String CHECKOUT_MOVIE_OPTION_DESC = "Checkout movie";

    public static final Integer VIEW_USER_INFO_OPTION = 7;
    public static final String VIEW_USER_INFO_OPTION_DESC = "View user information";

    public static final Integer VIEW_BORROWED_BOOKS_OPTION = 8;
    public static final String VIEW_BORROWED_BOOKS_OPTION_DESC = "View borrowed books";
}
