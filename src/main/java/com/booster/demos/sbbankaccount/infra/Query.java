package com.booster.demos.sbbankaccount.infra;

import com.booster.demos.sbbankaccount.entities.BankAccount;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {
    public BankAccount BankAccount() {
        return null;
    }
}
