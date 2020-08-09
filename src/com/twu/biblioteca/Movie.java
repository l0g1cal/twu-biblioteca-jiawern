package com.twu.biblioteca;

public class Movie {
    private String name;
    private String year;
    private String director;
    private int rating;

    public Movie(String name, String year, String director) {
        this.name = name;
        this.year = year;
        this.director = director;
    }

    public Movie(String name, String year, String director, int rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    @Override
    public String toString() {
        if (rating != 0) {
            return name + "," + year + "," + director + "," + rating;
        }
        return name + "," + year + "," + director;
    }
}
