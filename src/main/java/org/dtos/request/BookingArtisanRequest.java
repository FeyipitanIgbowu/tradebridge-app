package org.dtos.request;

import lombok.Data;
import org.data.model.*;
import org.springframework.data.annotation.Id;

@Data
public class BookingArtisanRequest {
    @Id

    private String id;
    private Customer customer;
    private Artisan artisan;
    private PaymentStatus status;
    private Status bookingStatus;
    private PaymentStatus paymentStatus;
    private String location;
    private ServiceType serviceType;
    }


