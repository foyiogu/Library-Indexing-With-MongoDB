package com.francis.bottomfeeder.repository;

import com.francis.bottomfeeder.model.Role;
import com.francis.bottomfeeder.model.enums.ERole;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);
}
