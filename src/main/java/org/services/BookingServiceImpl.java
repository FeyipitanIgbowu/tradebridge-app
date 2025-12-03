package org.services;

import org.data.model.*;
import org.data.repositories.BookingRepository;
import org.data.repositories.CustomerRepository;
import org.dtos.request.BookingArtisanRequest;
import org.dtos.request.CancelBookingRequest;
import org.dtos.response.BookingArtisanResponse;
import org.dtos.response.CancelBookingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import static org.utils.MapperBooking.map;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public BookingArtisanResponse bookArtisan(BookingArtisanRequest request) {

        if (customerRepository.findById(request.getCustomer().getId()).isEmpty())
            throw new IllegalArgumentException("Customer not found");

        Booking booking = map(request);
        bookingRepository.save(booking);

        return map(booking);
    }


    @Override
    public CancelBookingResponse cancelBooking(CancelBookingRequest request) {

        Optional<Booking> booking = bookingRepository.findById(request.getBookingId());
        if (booking.isEmpty()) throw new IllegalArgumentException("Booking not found");

        booking.get().setBookingStatus(Status.CANCELLED);
        bookingRepository.save(booking.get());

        CancelBookingResponse response = new CancelBookingResponse();
        response.setBookingId(booking.get().getId());
        response.setStatus(booking.get().getBookingStatus());

        return response;
    }
}
