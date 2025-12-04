package org.exceptions;

public class PaymentAlreadyConfirmedException extends RuntimeException {
    public PaymentAlreadyConfirmedException(String message) {
        super(message);
    }
}
