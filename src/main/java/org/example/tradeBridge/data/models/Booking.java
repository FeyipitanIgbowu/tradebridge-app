package org.example.tradeBridge.data.models;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
public class Booking {
    String id;
    String customerId;
    Artisan artisanId;
    BookingStatus bookingStatus;
    double price;
    LocalDateTime scheduledDate;
}