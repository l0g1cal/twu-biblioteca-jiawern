package com.twu.biblioteca.option;

import com.twu.biblioteca.Authenticator;
import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.Movie;

import java.util.ArrayList;
import java.util.Scanner;

import static com.twu.biblioteca.Constants.MOVIE_LIST_MESSAGE;

public class DisplayMoviesOption implements Option {

    @Override
    public void run(Library library, Scanner scanner, Authenticator authenticator) {
        ArrayList<Movie> movies = library.getMovies();
        String moviesString = library.pprint(movies);
        BibliotecaApp.printToCommandLine(MOVIE_LIST_MESSAGE);
        BibliotecaApp.printToCommandLine(moviesString);
    }
}
