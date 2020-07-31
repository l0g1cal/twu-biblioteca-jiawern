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
    private static Scanner scanner = new Scanner(System.in);

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
        optionMap.put(CHECKOUT_BOOK_OPTION, new CheckoutBookOption());
        optionDescMap.put(CHECKOUT_BOOK_OPTION, CHECKOUT_BOOK_OPTION_DESC);
        optionMap.put(RETURN_BOOK_OPTION, new ReturnBookOption());
        optionDescMap.put(RETURN_BOOK_OPTION, RETURN_BOOK_OPTION_DESC);

    }

    private static class DisplayBooksOption implements Option {
        @Override
        public void run() {
            ArrayList<Book> books = library.getBooks();
            String booksString = library.pprintBooks(books);
            printToCommandLine("Here is the list of books in this Biblioteca");
            printToCommandLine(booksString);
        }
    }

    private static class CheckoutBookOption implements Option {
        @Override
        public void run() {
            while (true) {
                printToCommandLine("Select a book that you would like to checkout ... Or type 'back' to go back to options");
                ArrayList<Book> books = library.getBooks();
                String booksString = library.pprintBooks(books);
                printToCommandLine("Here is the list of books in this Biblioteca");
                printToCommandLine(booksString);
                String ipt = scanner.nextLine();
                if (ipt.equals("back")) {
                    break;
                }
                try {
                    Book selectedBook = books.get(Integer.parseInt(ipt));
                    boolean isCheckout = library.checkoutBook(selectedBook);
                    if (isCheckout) {
                        printToCommandLine("Thank you! Enjoy the book!");
                        break;
                    } else {
                        printToCommandLine("Sorry, that book is unavailable");
                    }

                } catch (IndexOutOfBoundsException e) {
                    e.printStackTrace();
                    printToCommandLine("Sorry, that book is unavailable");
                }
            }

        }
    }

    private static class ReturnBookOption implements Option {
        @Override
        public void run() {
            while (true) {
                printToCommandLine("Select a book that you would like to return ... Or type 'back' to go back to options");
                ArrayList<Book> borrowedBooks = library.getBorrowedBooks();
                String borrowedBooksString = library.pprintBooks(borrowedBooks);
                printToCommandLine(borrowedBooksString);
                String ipt = scanner.nextLine();
                if (ipt.equals("back")) {
                    break;
                }
                try {
                    Book selectedBook = borrowedBooks.get(Integer.parseInt(ipt));
                    boolean isReturn = library.returnBook(selectedBook);
                    if (isReturn) {
                        printToCommandLine("Thank you for returning the book.");
                        break;
                    } else {
                        printToCommandLine("That is not a valid book to return.");
                    }

                } catch (IndexOutOfBoundsException e) {
                    e.printStackTrace();
                    printToCommandLine("That is not a valid book to return.");
                }
            }

        }
    }

    private static void printToCommandLine(String message) {
        System.out.println(message);
    }
}
