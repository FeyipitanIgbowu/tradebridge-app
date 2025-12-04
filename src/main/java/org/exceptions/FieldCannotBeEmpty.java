package org.exceptions;

public class FieldCannotBeEmpty extends CustomerAlreadyExist {

    public FieldCannotBeEmpty(String message) {
        super("input username and password");
    }
}
