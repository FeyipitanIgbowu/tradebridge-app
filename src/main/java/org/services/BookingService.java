package org.services;

public interface BookingService {

    BookArtisanResponse bookArtisan(BookArtisanRequest request);

    CancelBookingResponse cancelBooking(CancelBookingRequest request);

    PayArtisanResponse payArtisan(PayArtisanRequest request);
}
