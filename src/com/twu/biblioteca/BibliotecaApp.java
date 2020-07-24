package com.twu.biblioteca;

import java.util.ArrayList;

import static com.twu.biblioteca.Constants.WELCOME_MESSAGE;

public class BibliotecaApp {
    private static Library library;

    private BibliotecaApp() {
        library = createNewLibrary();
    }

    public static void main(String[] args) {
        createNewBiblioteca();
        displayWelcomeMessage();
        displayAllBooks();
    }

    private static BibliotecaApp createNewBiblioteca() {
        return new BibliotecaApp();
    }

    private static void displayWelcomeMessage() {
        System.out.println(WELCOME_MESSAGE);
    }

    private static void displayAllBooks() {
        String booksString = library.getBooksString();
        System.out.println("Here is the list of books in this Biblioteca");
        System.out.println(booksString);
    }

    private static Library createNewLibrary() {
        return new Library(createNewBooks());
    }

    private static ArrayList<Book> createNewBooks() {
        ArrayList<Book> books = new ArrayList<Book>();
        Book book1 = new Book("title1", "author1", "2020");
        Book book2 = new Book("title2", "author2", "2020");
        books.add(book1);
        books.add(book2);
        return books;
    }

}
