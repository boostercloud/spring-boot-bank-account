package com.booster.demos.sbbankaccount.infra;

import com.booster.demos.sbbankaccount.commands.CreateBankAccount;
import com.booster.demos.sbbankaccount.commands.Deposit;
import com.booster.demos.sbbankaccount.commands.Withdraw;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {
    private final CommandsSender commandsSender;

    @Autowired
    public Mutation(CommandsSender commandsSender) {
        this.commandsSender = commandsSender;
    }

    public boolean CreateBankAccount(Inputs.CreateBankAccount input) {
        return commandsSender.send(new CreateBankAccount(input.owner));
    }

    public boolean Deposit(Inputs.Deposit input) {
        return commandsSender.send(new Deposit(input.iban, input.amount));
    }

    public boolean Withdraw(Inputs.Withdraw input) {
        return commandsSender.send(new Withdraw(input.iban, input.amount));
    }
}
