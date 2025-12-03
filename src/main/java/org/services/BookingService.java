package org.services;

import org.dtos.request.BookingArtisanRequest;
import org.dtos.request.CancelBookingRequest;
import org.dtos.request.PayArtisanRequest;
import org.dtos.response.BookingArtisanResponse;
import org.dtos.response.CancelBookingResponse;
import org.dtos.response.PayArtisanResponse;

public interface BookingService {

    BookingArtisanResponse bookArtisan(BookingArtisanRequest request);

    CancelBookingResponse cancelBooking(CancelBookingRequest request);

//    PayArtisanResponse payArtisan(PayArtisanRequest request);
}
