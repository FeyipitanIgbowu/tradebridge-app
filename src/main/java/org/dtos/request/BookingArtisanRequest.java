package org.dtos.request;

import lombok.Data;
import org.data.model.Artisan;
import org.data.model.Customer;
import org.data.model.ServiceType;
import org.data.model.Status;
import org.example.tradeBridge.data.models.PaymentStatus;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

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


