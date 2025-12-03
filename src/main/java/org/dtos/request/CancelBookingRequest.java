package org.dtos.request;

import lombok.Data;

@Data
public class CancelBookingRequest {
    private String bookingId;
}
