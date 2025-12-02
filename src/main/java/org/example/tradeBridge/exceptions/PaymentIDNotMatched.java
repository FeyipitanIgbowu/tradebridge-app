package org.example.tradeBridge.exceptions;

import org.springframework.transaction.TransactionException;

public class PaymentIDNotMatched extends TradeBridgeException{
    public PaymentIDNotMatched(String message) {
        super(message);
    }
}
