package org.dtos.request;

import lombok.Data;

@Data
public class AdminConfirmPaymentRequest {
    private String paymentId;
    private String customerId;
    private String artisanId;
    private String bookingId;
    private boolean isPaid;
}
