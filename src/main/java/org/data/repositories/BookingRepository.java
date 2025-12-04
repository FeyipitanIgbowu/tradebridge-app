package org.data.repositories;

import org.data.model.Booking;
import org.data.model.Status;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface BookingRepository extends MongoRepository<Booking, String> {


    List<Booking> findByCustomerId(String customerId);

    List<Booking> findByArtisanId(String artisanId);

    List<Booking> findByStatus(Status status);
}
