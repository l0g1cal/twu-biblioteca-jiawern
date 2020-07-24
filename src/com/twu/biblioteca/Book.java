package com.twu.biblioteca;

public class Book {
    private String title;
    private String author;
    private String publishingYear;

    public Book(String title, String author, String publishingYear) {
        this.title = title;
        this.author = author;
        this.publishingYear = publishingYear;
    }

    @Override
    public String toString() {
        return title + "," + author + "," + publishingYear;
    }
}
