@Data
public class BookingRequest {
    private String customerId;
    private String artisanId;
    private ServiceType serviceType;
    private LocalDateTime bookingTime;
}
