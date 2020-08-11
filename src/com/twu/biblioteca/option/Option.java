package com.twu.biblioteca.option;

import com.twu.biblioteca.Authenticator;
import com.twu.biblioteca.Library;

import java.util.Scanner;

public interface Option {
    void run(Library library, Scanner scanner, Authenticator authenticator);
}
