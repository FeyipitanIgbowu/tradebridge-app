package org.data.model;
import lombok.Data;
import org.springframework.data.annotation.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@Data

public class Booking {

    @Id

    private String id;
    private Customer customer;
    private Artisan artisan;
    private LocalTime bookingTime;
    private LocalDate bookedDate;
    private Status status;
    private String location;
    private String description;
    private double price;
    private ServiceType specialization;
}

