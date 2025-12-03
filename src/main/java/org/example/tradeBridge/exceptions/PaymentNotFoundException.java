package org.example.tradeBridge.exceptions;

public class PaymentNotFoundException extends TradeBridgeException {
    public PaymentNotFoundException(String message) {
        super(message);
    }
}
