package com.francis.bottomfeeder.repository;

import com.francis.bottomfeeder.model.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<UserEntity, String> {

//    @Query("{'first_name': ?0}")
//    Optional<UserEntity> findByFirstName(String name);

    boolean existsByEmail(String email);

    Optional<UserEntity> findByEmail(String email);
}
