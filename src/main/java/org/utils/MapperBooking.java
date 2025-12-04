package org.utils;

import org.data.model.Booking;
import org.data.model.PaymentStatus;
import org.data.model.Status;
import org.dtos.request.BookingArtisanRequest;
import org.dtos.response.BookingArtisanResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Component
public class MapperBooking {


    public static Booking map(BookingArtisanRequest request) {
        Booking booking = new Booking();

        booking.setCustomerId(request.getCustomer().getId());
        booking.setArtisanId(request.getArtisan());
        booking.setScheduledDate(LocalDateTime.now());
        booking.setBookingStatus(Status.PENDING);
        return booking;
    }

    public static BookingArtisanResponse map(Booking booking) {
        BookingArtisanResponse response = new BookingArtisanResponse();

        response.setId(booking.getId());
        response.setArtisanName(booking.getArtisan().getFullName());
        response.setCustomerName(booking.getCustomer().getFullName());
        response.setServiceType(booking.getServiceType());
        response.setPaymentStatus(booking.getPaymentStatus());
        if (response.getPaymentStatus() == PaymentStatus.Confirmed) {
            response.setStatus(Status.CONFIRMED);
        }
        return response;
    }
}