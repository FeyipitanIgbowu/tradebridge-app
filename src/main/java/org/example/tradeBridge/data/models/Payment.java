package org.example.tradeBridge.data.models;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
public class Payment {
    String id;
    String bookingId;
    PaymentStatus status;
    String customerId;
    double price;
    BookingStatus bookingStatus;
    boolean isPaid;
    LocalDateTime paymentDate;
}
