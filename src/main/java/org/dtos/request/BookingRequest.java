package org.dtos.request;

import lombok.Data;
import org.data.model.ServiceType;

import java.time.LocalDateTime;

@Data
public class BookingRequest {
    private String customerId;
    private String artisanId;
    private ServiceType serviceType;
    private LocalDateTime bookingTime;
}
