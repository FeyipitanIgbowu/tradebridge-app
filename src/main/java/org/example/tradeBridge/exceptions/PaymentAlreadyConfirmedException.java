package org.example.tradeBridge.exceptions;

public class PaymentAlreadyConfirmedException extends TradeBridgeException {
    public PaymentAlreadyConfirmedException(String message) {
        super(message);
    }
}
