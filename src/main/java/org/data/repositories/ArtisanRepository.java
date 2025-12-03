package org.data.repositories;

import org.data.model.Artisan;
import org.data.model.ServiceType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ArtisanRepository extends MongoRepository<Artisan, String> {

    List<Artisan> findBySpecialization(ServiceType specialization);

    List<Artisan> findBySpecializationAndIsAvailableTrue(ServiceType specialization);

}
