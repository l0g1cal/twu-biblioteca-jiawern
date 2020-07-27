package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;

    public Library(ArrayList<Book> books) {
        this.books = books;
    }

    public String pprintBooks() {
        String prettyBookList = "";
        for (Book book : books) {
            prettyBookList = prettyBookList + book.toString() + '\n';
        }
        return prettyBookList;
    }
}
