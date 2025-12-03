package org.data.repositories;

import org.data.model.Artisan;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import java.util.Optional;

public interface ArtisanRepository extends MongoRepository<Artisan, String> {

    Optional<Artisan> findByEmail(String email);

    List<Artisan> findByAvailable(boolean available);
}
