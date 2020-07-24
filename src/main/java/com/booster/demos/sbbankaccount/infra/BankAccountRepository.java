package com.booster.demos.sbbankaccount.infra;

import com.booster.demos.sbbankaccount.entities.BankAccount;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.UUID;

public interface BankAccountRepository extends MongoRepository<BankAccount, UUID> {
    Optional<BankAccount> findByIban(UUID iban);

    Optional<BankAccount> findByOwner(UUID owner);
}
