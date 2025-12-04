package org.dtos.response;

import lombok.Data;
import org.data.model.Status;

@Data
public class CancelBookingResponse {

    private String bookingId;
    private Status status;
}
