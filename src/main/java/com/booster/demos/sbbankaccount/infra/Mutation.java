package com.booster.demos.sbbankaccount.infra;

import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {
    public boolean CreateBankAccount(Inputs.CreateBankAccount input) {
        return true;
    }

    public boolean Deposit(Inputs.Deposit input) {
        return true;
    }

    public boolean Withdraw(Inputs.Withdraw input) {
        return true;
    }
}
