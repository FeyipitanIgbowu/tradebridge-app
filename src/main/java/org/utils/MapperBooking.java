package org.utils;

import org.data.model.Booking;
import org.dtos.request.BookingArtisanRequest;
import org.dtos.response.BookingArtisanResponse;
import org.springframework.stereotype.Component;

@Component
public class MapperBooking {

    public static Booking map(BookingArtisanRequest request) {
        Booking booking = new Booking();
        booking.setCustomer(request.getCustomer());
        booking.setArtisan(request.getArtisan());
        booking.setServiceType(request.getServiceType());
        booking.setLocation(request.getLocation());
        booking.setPaymentStatus(request.getPaymentStatus());
        return booking;
    }

    public static BookingArtisanResponse map(Booking booking) {
        BookingArtisanResponse response = new BookingArtisanResponse();
        response.setId(booking.getId());
        response.setCustomerName(booking.getCustomer() != null ? booking.getCustomer().getFullName() : "");
        response.setArtisanName(booking.getArtisan() != null ? booking.getArtisan().getFullName() : "");
        response.setStatus(booking.getStatus());
        response.setServiceType(booking.getServiceType());
        response.setPaymentStatus(booking.getPaymentStatus());
        return response;
    }
}
