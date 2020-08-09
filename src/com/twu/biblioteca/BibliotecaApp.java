package com.twu.biblioteca;

import com.twu.biblioteca.option.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static com.twu.biblioteca.Constants.*;

public class BibliotecaApp {
    private static Library library;
    private static Map<Integer, Option> optionMap = new HashMap<>();
    private static Map<Integer, String> optionDescMap = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        createNewLibrary();
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

    private static void createUserOptions() {
        optionMap.put(DISPLAY_BOOKS_OPTION, new DisplayBooksOption());
        optionDescMap.put(DISPLAY_BOOKS_OPTION, DISPLAY_BOOKS_OPTION_DESC);
        optionMap.put(CHECKOUT_BOOK_OPTION, new CheckoutBookOption());
        optionDescMap.put(CHECKOUT_BOOK_OPTION, CHECKOUT_BOOK_OPTION_DESC);
        optionMap.put(RETURN_BOOK_OPTION, new ReturnBookOption());
        optionDescMap.put(RETURN_BOOK_OPTION, RETURN_BOOK_OPTION_DESC);
        optionMap.put(DISPLAY_MOVIES_OPTION, new DisplayMoviesOption());
        optionDescMap.put(DISPLAY_MOVIES_OPTION, DISPLAY_MOVIES_OPTION_DESC);
        optionMap.put(CHECKOUT_MOVIE_OPTION, new CheckoutMovieOption());
        optionDescMap.put(CHECKOUT_MOVIE_OPTION, CHECKOUT_MOVIE_OPTION_DESC);
    }

    private static void displayWelcomeMessage() {
        printToCommandLine(WELCOME_MESSAGE);
    }

    private static void awaitUserSelection() {
        printToCommandLine("Please select an option number to continue ... Or type 'exit' to end program\n");
        displayOptions();
        String userInput = getUserInput();
        verifyAndRunInput(userInput);
    }

    private static void displayOptions() {
        for (int optionNumber = 1; optionNumber <= optionMap.size(); optionNumber++) {
            String outputString = String.format("%d: %s", optionNumber, optionDescMap.get(optionNumber));
            printToCommandLine(outputString);
        }
    }

    private static String getUserInput() {
        return scanner.nextLine();
    }

    private static void verifyAndRunInput(String ipt) {
        if (ipt.equals("exit")) {
            printToCommandLine("User requested to end program. Exiting ...");
            System.exit(0);
        }
        try {
            Integer iptValue = Integer.parseInt(ipt);
            Option opt = optionMap.get(iptValue);
            opt.run(library, scanner);
        }
        catch (Exception e) {
            printToCommandLine("Please select a valid option!");
        }
    }

    public static void printToCommandLine(String message) {
        System.out.println(message);
    }
}
