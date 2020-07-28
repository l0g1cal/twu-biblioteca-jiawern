package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;;
    private ArrayList<Book> borrowedBooks = new ArrayList<Book>();;

    public Library(ArrayList<Book> books) {
        this.books = books;
    }

    public int totalBooksInLibrary() {
        return books.size();
    }

    public String checkoutBook(Book book) {
        for (Book b : books) {
            if (b.equals(book)) {
                books.remove(b);
                borrowedBooks.add(b);
                return "Thank you! Enjoy the book";
            }
        }
        return "Book is unavailable";
    }

    public String pprintBooks() {
        String prettyBookList = "";
        for (Book book : books) {
            prettyBookList = prettyBookList + book.toString() + '\n';
        }
        return prettyBookList;
    }
}
