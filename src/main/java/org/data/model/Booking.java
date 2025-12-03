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
    String id;
    String customerId;
    Artisan artisanId;
    Status bookingStatus;
    double price;
    LocalDateTime scheduledDate;
}

