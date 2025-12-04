package org.exceptions;

public class CustomerAlreadyExist extends RuntimeException {
    public CustomerAlreadyExist(String message) {
        super("Email Already Exist, Login Instead.");

    }
}
