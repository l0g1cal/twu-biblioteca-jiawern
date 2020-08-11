package com.twu.biblioteca;

import com.twu.biblioteca.option.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static com.twu.biblioteca.Constants.*;

public class BibliotecaApp {
    private static Library library;
    private static Authenticator authenticator;
    private static User currentUser;
    private static Map<Integer, Option> generalOptionMap = new HashMap<>();
    private static Map<Integer, String> generalOptionDescMap = new HashMap<>();
    private static Map<Integer, Option> afterLoginOptionMap = new HashMap<>();
    private static Map<Integer, String> afterLoginOptionDescMap = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        createNewLibrary();
        createNewAuthenticator();
        createUserOptions();
        displayWelcomeMessage();

        while (true) {
            awaitUserSelection();
        }
    }

    private static void createNewLibrary() {
        library = new Library(createNewBooks(), createNewMovies());
    }

    private static ArrayList<Book> createNewBooks() {
        ArrayList<Book> books = new ArrayList<Book>();
        Book book1 = new Book("title1", "author1", "2020");
        Book book2 = new Book("title2", "author2", "2020");
        books.add(book1);
        books.add(book2);
        return books;
    }

    private static ArrayList<Movie> createNewMovies() {
        ArrayList<Movie> movies = new ArrayList<Movie>();
        Movie movie1 = new Movie("title1","2020", "director1");
        Movie movie2 = new Movie("title2","2020", "director2", 9);
        movies.add(movie1);
        movies.add(movie2);
        return movies;
    }

    private static void createNewAuthenticator() {
        authenticator = new Authenticator(createNewUsers());
    }

    private static ArrayList<User> createNewUsers() {
        ArrayList<User> users = new ArrayList<User>();
        User user1 = new User("user1", "123-45678", "p1", "user1@gmail.com", "12345678", true);
        User user2 = new User("user2", "234-56789", "p2", "user2@gmail.com", "87654321",false);
        users.add(user1);
        users.add(user2);
        return users;
    }

    private static void createUserOptions() {
        createGeneralUserOptions();
        createAfterLoginUserOptions();
    }

    private static void createGeneralUserOptions() {
        generalOptionMap.put(DISPLAY_BOOKS_OPTION, new DisplayBooksOption());
        generalOptionDescMap.put(DISPLAY_BOOKS_OPTION, DISPLAY_BOOKS_OPTION_DESC);
        generalOptionMap.put(DISPLAY_MOVIES_OPTION, new DisplayMoviesOption());
        generalOptionDescMap.put(DISPLAY_MOVIES_OPTION, DISPLAY_MOVIES_OPTION_DESC);
        generalOptionMap.put(LOGIN_OPTION, new LoginOption());
        generalOptionDescMap.put(LOGIN_OPTION, LOGIN_OPTION_DESC);
    }

    private static void createAfterLoginUserOptions() {
        afterLoginOptionMap.put(CHECKOUT_BOOK_OPTION, new CheckoutBookOption());
        afterLoginOptionDescMap.put(CHECKOUT_BOOK_OPTION, CHECKOUT_BOOK_OPTION_DESC);
        afterLoginOptionMap.put(RETURN_BOOK_OPTION, new ReturnBookOption());
        afterLoginOptionDescMap.put(RETURN_BOOK_OPTION, RETURN_BOOK_OPTION_DESC);
        afterLoginOptionMap.put(CHECKOUT_MOVIE_OPTION, new CheckoutMovieOption());
        afterLoginOptionDescMap.put(CHECKOUT_MOVIE_OPTION, CHECKOUT_MOVIE_OPTION_DESC);
        afterLoginOptionMap.put(VIEW_USER_INFO_OPTION, new ViewUserInfoOption());
        afterLoginOptionDescMap.put(VIEW_USER_INFO_OPTION, VIEW_USER_INFO_OPTION_DESC);
    }

    private static void displayWelcomeMessage() {
        printToCommandLine(WELCOME_MESSAGE);
    }

    private static void awaitUserSelection() {
        printToCommandLine(SELECT_OPTION_MESSAGE);
        displayOptions();
        String userInput = getUserInput();
        verifyAndRunInput(userInput);
    }

    private static void displayOptions() {
        if (currentUser == null) {
            displayGeneralOptions();
            printNewLine();
        } else {
            displayGeneralOptions();
            displayLoginOptions();
            printNewLine();
        }
    }

    private static void displayGeneralOptions() {
        for (int optionNumber = 1; optionNumber <= generalOptionMap.size(); optionNumber++) {
            String outputString = String.format("%d: %s", optionNumber, generalOptionDescMap.get(optionNumber));
            printToCommandLine(outputString);
        }
    }

    private static void displayLoginOptions() {
        int loginOptionsStartingNumber = generalOptionMap.size() + 1;
        int loginOptionsSize = afterLoginOptionMap.size();

        for (int optionNumber = loginOptionsStartingNumber; optionNumber < loginOptionsStartingNumber + loginOptionsSize; optionNumber++) {
            String outputString = String.format("%d: %s", optionNumber, afterLoginOptionDescMap.get(optionNumber));
            printToCommandLine(outputString);
        }
    }

    private static String getUserInput() {
        return scanner.nextLine();
    }

    private static void verifyAndRunInput(String ipt) {
        if (ipt.equals("exit")) {
            printToCommandLine(EXIT_MESSAGE);
            System.exit(0);
        }
        try {
            Integer iptValue = Integer.parseInt(ipt);
            if (currentUser == null && iptValue > 3) { // if not logged-in, can only choose 3 options
                printToCommandLine(INCORRECT_OPTION_MESSAGE);
            } else {
                Option opt = getOption(iptValue);
                opt.run(library, scanner, authenticator);
            }
        }
        catch (Exception e) {
            printToCommandLine(INCORRECT_OPTION_MESSAGE);
        }
    }

    private static Option getOption(Integer ipt) {
        if (ipt <= generalOptionMap.size()) {
            return generalOptionMap.get(ipt);
        }
        return afterLoginOptionMap.get(ipt);
    }

    public static void printToCommandLine(String message) {
        System.out.println(message);
    }

    private static void printNewLine() {
        System.out.println();
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User user) {
        currentUser = user;
    }
}
