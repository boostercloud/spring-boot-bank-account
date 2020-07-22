package com.booster.demos.sbbankaccount.infra;

import com.booster.demos.sbbankaccount.commands.CreateBankAccount;
import com.booster.demos.sbbankaccount.commands.Deposit;
import com.booster.demos.sbbankaccount.commands.Withdraw;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {
    public boolean CreateBankAccount(Inputs.CreateBankAccount input) {
        return new CreateBankAccount(input.owner).execute();
    }

    public boolean Deposit(Inputs.Deposit input) {
        return new Deposit(input.iban, input.amount).execute();
    }

    public boolean Withdraw(Inputs.Withdraw input) {
        return new Withdraw(input.iban, input.amount).execute();
    }
}
