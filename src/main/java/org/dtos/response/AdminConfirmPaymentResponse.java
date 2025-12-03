package org.dtos.response;

import lombok.Data;
import org.data.model.PaymentStatus;

import java.time.LocalDateTime;

@Data
public class AdminConfirmPaymentResponse {
    private String paymentId;
    private String customerId;
    private double price;
    private PaymentStatus status;
    private LocalDateTime confirmationDate;

}
