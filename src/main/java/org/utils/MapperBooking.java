package org.utils;

import org.springframework.stereotype.Component;
import dto.BookingRequest;
import dto.BookingResponse;
import entity.Booking;

@Component
public class MapperBooking {

    public Booking map(BookingRequest request) {
        Booking booking = new Booking();
        booking.setCustomerId(request.getCustomerId());
        booking.setArtisanId(request.getArtisanId());
        booking.setServiceType(request.getServiceType());
        booking.setBookingTime(request.getBookingTime());
        return booking;
    }

    public BookingResponse map(Booking booking, String customerName, String artisanName) {
        BookingResponse response = new BookingResponse();
        response.setId(booking.getId());
        response.setCustomerName(customerName);
        response.setArtisanName(artisanName);
        response.setStatus(booking.getStatus());
        response.setPayment(request.payment());
        return response;
    }
}
