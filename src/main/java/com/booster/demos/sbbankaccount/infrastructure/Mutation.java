package com.booster.demos.sbbankaccount.infrastructure;

import com.booster.demos.sbbankaccount.commands.Command;
import com.booster.demos.sbbankaccount.commands.CreateBankAccount;
import com.booster.demos.sbbankaccount.commands.Deposit;
import com.booster.demos.sbbankaccount.commands.Withdraw;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {
    private final CommandSender commandSender;

    @Autowired
    public Mutation(CommandSender commandSender) {
        this.commandSender = commandSender;
    }

    @PreAuthorize("hasAuthority('SCOPE_BANK_TELLER')")
    public boolean CreateBankAccount(GraphQLInputs.CreateBankAccount input) {
        return send(new CreateBankAccount(input.owner));
    }

    @PreAuthorize("hasAuthority('SCOPE_CLIENT') or hasAuthority('SCOPE_BANK_TELLER')")
    public boolean Deposit(GraphQLInputs.Deposit input) {
        return send(new Deposit(input.iban, input.amount));
    }

    @PreAuthorize("hasAuthority('SCOPE_CLIENT') or hasAuthority('SCOPE_BANK_TELLER')")
    public boolean Withdraw(GraphQLInputs.Withdraw input) {
        return send(new Withdraw(input.iban, input.amount));
    }

    private boolean send(Command command) {
        try {
            return commandSender.send(command);
        } catch (UnknownCommandException e) {
            e.printStackTrace();
            return false;
        }
    }
}
