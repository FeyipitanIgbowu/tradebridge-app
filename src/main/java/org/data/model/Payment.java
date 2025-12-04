package org.data.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
@ToString
public class Payment {
        @Id
        String id;
        String bookingId;
        String customerId;
        double price;
        Status bookingStatus;
        PaymentStatus paymentStatus;
        boolean isPaid;
        LocalDateTime paymentDate;

}
