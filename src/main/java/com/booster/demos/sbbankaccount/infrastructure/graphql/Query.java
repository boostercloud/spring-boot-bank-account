package com.booster.demos.sbbankaccount.infrastructure.graphql;

import com.booster.demos.sbbankaccount.infrastructure.mongo.BankAccountRepository;
import com.booster.demos.sbbankaccount.readmodels.BankAccountReadModel;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class Query implements GraphQLQueryResolver {
    private final BankAccountRepository repository;

    @Autowired
    public Query(BankAccountRepository repository) {
        this.repository = repository;
    }

    @PreAuthorize("hasAuthority('SCOPE_CLIENT') or hasAuthority('SCOPE_BANK_TELLER')")
    public Optional<BankAccountReadModel> BankAccountReadModel(UUID owner) {
        return repository.findByOwner(owner)
                .map(BankAccountReadModel::new);
    }
}
