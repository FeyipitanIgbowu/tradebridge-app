package org.example.tradeBridge.dtos.response;

import lombok.Data;
import lombok.ToString;
import org.example.tradeBridge.data.models.Artisan;
import org.example.tradeBridge.data.models.BookingStatus;

import java.time.LocalDateTime;

@Data
@ToString
public class AdminViewAllBookedArtisans {
    private String id;
    private String customerId;
    private Artisan artisanId;
    private String bookingStatus;
    private double price;
    private LocalDateTime scheduledDate;
}
