package org.services;

import org.dtos.request.BookingArtisanRequest;
import org.dtos.request.CancelBookingRequest;
import org.dtos.response.BookingArtisanResponse;
import org.dtos.response.CancelBookingResponse;

public interface BookingService {

    BookingArtisanResponse bookArtisan(BookingArtisanRequest request);

    CancelBookingResponse cancelBooking(CancelBookingRequest request);
}
