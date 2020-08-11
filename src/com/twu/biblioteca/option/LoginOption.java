package com.twu.biblioteca.option;

import com.twu.biblioteca.Authenticator;
import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.User;

import java.util.Scanner;

import static com.twu.biblioteca.Constants.*;

public class LoginOption implements Option {

    @Override
    public void run(Library library, Scanner scanner, Authenticator authenticator) {
        while (true) {
            BibliotecaApp.printToCommandLine(LOGIN_MESSAGE);
            String ipt = scanner.nextLine();
            String inputLibraryNumber = getInputLibraryNumber(ipt);
            String inputPassword = getInputPassword(ipt);
            boolean isLogin = login(authenticator, inputLibraryNumber, inputPassword);
            if (isLogin) break;
        }
    }

    private boolean login(Authenticator authenticator, String libraryNumber, String password) {
        User currentUser = authenticator.login(libraryNumber, password);
        if (currentUser != null) {
            BibliotecaApp.setCurrentUser(currentUser);
            BibliotecaApp.printToCommandLine(LOGIN_SUCCESS_MESSAGE);
            return true;
        }
        BibliotecaApp.printToCommandLine(LOGIN_FAILURE_MESSAGE);
        return false;
    }

    private String getInputLibraryNumber(String ipt) {
        try {
            String inputLibraryNumber = ipt.split(",", 2)[0];
            return inputLibraryNumber;
        }
        catch (Exception e) {
            return "";
        }
    }

    private String getInputPassword(String ipt) {
        try {
            String inputPassword = ipt.split(",", 2)[1];
            return inputPassword;
        }
        catch (Exception e) {
            return "";
        }
    }
}
