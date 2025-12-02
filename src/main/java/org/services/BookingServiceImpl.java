package Services;

import org.data.repositories.ArtisanRepository;
import org.data.repositories.BookingRepository;
import org.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.utils.BookingMapper;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ArtisanRepository artisianRepository;

    @Autowired
    private BookingMapper bookingMapper;

    @Autowired
    private CustomerService customerService;


    @Override
    public BookArtisanResponse bookArtisan(BookArtisanRequest request) {
        artisianRepository.findById(request.getArtisanId())
                .orElseThrow(() -> new IllegalArgumentException("Artisan not found"));

        customerService.findCustomerById(request.getCustomerId());

        Booking booking = new Booking(
                request.getCustomerId(),
                request.getArtisanId(),
                request.getAmount()
        );

        booking.setStatus(BookingStatus.CONFIRMED);

        bookingRepository.save(booking);

        BookArtisanResponse response = new BookArtisanResponse();
        response.setBookingId(booking.getId());
        response.setCustomerId(booking.getCustomerId());
        response.setArtisanId(booking.getArtisanId());
        response.setAmount(booking.getAmount());
        response.setStatus(booking.getStatus());

        return response;
    }


    @Override
    public CancelBookingResponse cancelBooking(CancelBookingRequest request) {

        Booking booking = bookingRepository.findById(request.getBookingId())
                .orElseThrow(() -> new IllegalArgumentException("Booking not found"));

        booking.setStatus(BookingStatus.CANCELLED);
        bookingRepository.save(booking);

        CancelBookingResponse response = new CancelBookingResponse();
        response.setBookingId(booking.getId());
        response.setStatus(booking.getStatus());

        return response;
    }


    @Override
    public PayArtisanResponse payArtisan(PayArtisanRequest request) {

        Booking booking = bookingRepository.findById(request.getBookingId())
                .orElseThrow(() -> new IllegalArgumentException("Booking not found"));

        if (booking.getStatus() != BookingStatus.COMPLETED) {
            throw new IllegalArgumentException("Booking must be COMPLETED before paying artisan");
        }

        return new PayArtisanResponse(
                booking.getId(),
                booking.getArtisanId(),
                booking.getAmount(),
                "Payment successful"
        );
    }
}
