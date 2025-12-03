package org.dtos.response;

import lombok.Data;
import org.data.model.PaymentStatus;
import org.data.model.ServiceType;
import org.data.model.Status;

@Data
public class BookingArtisanResponse {
        private String id;
        private String customerName;
        private String artisanName;
        private Status status;
        private ServiceType serviceType;
        private PaymentStatus paymentStatus;
    }
