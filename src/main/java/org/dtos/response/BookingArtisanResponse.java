package org.dtos.response;

import lombok.Data;
import org.example.tradeBridge.data.models.BookingStatus;

@Data
public class BookingArtisanResponse {
        private String id;
        private String customerName;
        private String artisanName;
        private BookingStatus status;
    }
