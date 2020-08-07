package com.booster.demos.sbbankaccount.infrastructure.mongo;

import com.booster.demos.sbbankaccount.entities.BankAccount;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface BankAccountRepository extends MongoRepository<BankAccount, UUID> {
    @Query("{ 'iban': ?0 }")
    Optional<BankAccount> findByEntityId(UUID entityId);

    Optional<BankAccount> findByOwner(UUID owner);
}
