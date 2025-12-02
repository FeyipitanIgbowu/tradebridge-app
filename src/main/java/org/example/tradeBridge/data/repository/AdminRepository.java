package org.example.tradeBridge.data.repository;

import org.example.tradeBridge.data.models.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends MongoRepository<Admin, String> {
    Admin findByUserName(String userName);
}
