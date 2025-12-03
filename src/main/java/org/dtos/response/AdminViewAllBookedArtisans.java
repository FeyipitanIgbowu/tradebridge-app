package org.dtos.response;

import lombok.Data;
import org.data.model.Artisan;
import org.data.model.Status;

import java.time.LocalDateTime;

@Data
public class AdminViewAllBookedArtisans {
    private String id;
    private String customerId;
    private Artisan artisanId;
    private Status bookingStatus;
    private double price;
    private LocalDateTime scheduledDate;
}
