package org.dtos.request;

import lombok.Data;
import org.data.model.ServiceType;

import java.time.LocalDateTime;

@Data
public class BookingArtisanRequest {
        private String customerId;
        private String artisanId;
        private ServiceType serviceType;
        private LocalDateTime bookingTime;
    }


