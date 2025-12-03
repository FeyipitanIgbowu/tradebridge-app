package org.utils;

import org.data.model.Booking;
import org.data.model.PaymentStatus;
import org.data.model.Status;
import org.dtos.request.BookingArtisanRequest;
import org.dtos.response.BookingArtisanResponse;
import org.springframework.stereotype.Component;



@Component
public class BookingMapper {

    public static Booking map(BookingArtisanRequest request) {
        Booking booking = new Booking();

        booking.setCustomer(request.getCustomer());
        booking.setServiceType(request.getServiceType());
        booking.setLocation(request.getLocation());
        booking.setStatus(Status.PENDING);
        booking.setPaymentStatus(PaymentStatus.Pending);
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