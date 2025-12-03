package org.example.tradeBridge.dtos.requests;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AdminConfirmPaymentRequest {
    private String paymentId;
    private String customerId;
    private String artisanId;
    private String bookingId;
    private boolean isPaid;
}
