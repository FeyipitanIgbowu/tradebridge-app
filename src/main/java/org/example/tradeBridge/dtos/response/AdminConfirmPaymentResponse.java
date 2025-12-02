package org.example.tradeBridge.dtos.response;

import lombok.Data;
import lombok.ToString;
import org.example.tradeBridge.data.models.PaymentStatus;

import java.time.LocalDateTime;

@Data
@ToString
public class AdminConfirmPaymentResponse {
    private String paymentId;
    private String customerId;
    private double price;
    private PaymentStatus status;
    private LocalDateTime confirmationDate;

}
