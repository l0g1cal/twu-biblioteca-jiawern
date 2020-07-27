package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static com.twu.biblioteca.Constants.*;

public class BibliotecaApp {
    private static Library library;
    private static Map<Integer, Option> optionMap = new HashMap<>();
    private static Map<Integer, String> optionDescMap = new HashMap<>();

    public static void main(String[] args) {
        createNewBiblioteca();
        displayWelcomeMessage();

        while (true) {
            awaitUserSelection();
        }
    }

    private static BibliotecaApp createNewBiblioteca() {
        return new BibliotecaApp();
    }

    private BibliotecaApp() {
        createNewLibrary();
        createUserOptions();
    }

    private static void displayWelcomeMessage() {
        printToCommandLine(WELCOME_MESSAGE);
    }

    private static void awaitUserSelection() {
        printToCommandLine("Please select an option number to continue ... Or type 'exit' to end program\n");
        displayOptions();
        String line = getUserInput();
        verifyAndRunInput(line);
    }

    private static void displayOptions() {
        for (int optionNumber = 1; optionNumber <= optionMap.size(); optionNumber++) {
            String outputString = String.format("%d: %s", optionNumber, optionDescMap.get(optionNumber));
            printToCommandLine(outputString);
        }
    }

    private static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
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
            opt.run();
        }
        catch (Exception e) {
            printToCommandLine("Please select a valid option!");
        }
    }

    private static void createNewLibrary() {
        library = new Library(createNewBooks());
    }

    private static ArrayList<Book> createNewBooks() {
        ArrayList<Book> books = new ArrayList<Book>();
        Book book1 = new Book("title1", "author1", "2020");
        Book book2 = new Book("title2", "author2", "2020");
        books.add(book1);
        books.add(book2);
        return books;
    }

    private static void createUserOptions() {
        optionMap.put(DISPLAY_BOOKS_OPTION, new DisplayBooksOption());
        optionDescMap.put(DISPLAY_BOOKS_OPTION, DISPLAY_BOOKS_OPTION_DESC);
    }

    private static class DisplayBooksOption implements Option {
        @Override
        public void run() {
            String booksString = library.pprintBooks();
            printToCommandLine("Here is the list of books in this Biblioteca");
            printToCommandLine(booksString);
        }
    }

    private static void printToCommandLine(String message) {
        System.out.println(message);
    }
}
