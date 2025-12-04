package org.exceptions;

public class IncorrectLogin extends FieldCannotBeEmpty {

    public IncorrectLogin(String message) {
        super("input correct username and password");
    }
}
