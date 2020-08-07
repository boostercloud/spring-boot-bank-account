package com.booster.demos.sbbankaccount.infrastructure;

import com.booster.demos.sbbankaccount.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface UsersRepository extends MongoRepository<User, UUID> {
    User findByUsername(String username);
}
