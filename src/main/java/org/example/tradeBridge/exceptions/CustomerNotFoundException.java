package org.example.tradeBridge.exceptions;

public class CustomerNotFoundException extends TradeBridgeException{
    public CustomerNotFoundException(String message) {
        super(message);
    }
}
