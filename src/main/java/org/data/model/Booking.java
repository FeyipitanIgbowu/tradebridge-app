package org.data.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@ToString
public class Booking {
    @Id
    private String id;


    private Customer customer;
    private Artisan artisan;
    private LocalTime bookingTime = LocalTime.now();
    private LocalDate bookedDate =  LocalDate.now();
    private Status status;
    private PaymentStatus paymentStatus;
    private String location;
    private ServiceType price;
    private ServiceType serviceType;
}









