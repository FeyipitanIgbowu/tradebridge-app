package org.exceptions;

public class PaymentIDNotMatched extends RuntimeException {
    public PaymentIDNotMatched(String message) {
        super(message);
    }
}
