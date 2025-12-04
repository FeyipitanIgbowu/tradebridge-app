package org.dtos.request;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class PayArtisanRequest {

    @Id
    private String id;
    private String bookingId;
}
