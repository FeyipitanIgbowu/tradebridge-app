package org.dtos.request;
@Data
public class BookingArtisanRequest {
        private String customerId;
        private String artisanId;
        private ServiceType serviceType;
        private LocalDateTime bookingTime;
    }


