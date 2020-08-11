package com.twu.biblioteca.option;

import com.twu.biblioteca.Authenticator;
import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.User;

import java.util.Scanner;

import static com.twu.biblioteca.Constants.LOGIN_FAILURE_MESSAGE;
import static com.twu.biblioteca.Constants.LOGIN_SUCCESS_MESSAGE;

public class LoginOption implements Option {

    @Override
    public void run(Library library, Scanner scanner, Authenticator authenticator) {
        while (true) {
            BibliotecaApp.printToCommandLine("Please enter your login details ... Or type 'back' to go back to options\n" +
                            "Format: libraryNumber,password\n" +
                            "Eg: 111-11111,passWORD\n");
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
        return ipt.split(",", 2)[0];
    }

    private String getInputPassword(String ipt) {
        return ipt.split(",", 2)[1];
    }
}
