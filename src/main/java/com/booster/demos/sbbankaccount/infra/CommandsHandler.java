package com.booster.demos.sbbankaccount.infra;

import com.booster.demos.sbbankaccount.commands.Command;
import com.booster.demos.sbbankaccount.commands.CreateBankAccount;
import com.booster.demos.sbbankaccount.commands.Deposit;
import com.booster.demos.sbbankaccount.commands.Withdraw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(CommandsProcessor.class)
public class CommandsHandler {
    private final EventsStore eventsStore;

    @Autowired
    public CommandsHandler(EventsStore eventsStore) {
        this.eventsStore = eventsStore;
    }

    @StreamListener(CommandsProcessor.CREATE_BANK_ACCOUNT)
    public void handleCreateBankAccount(CreateBankAccount command) {
        execute(command);
    }

    @StreamListener(CommandsProcessor.DEPOSIT)
    public void handleDeposit(Deposit command) {
        execute(command);
    }

    @StreamListener(CommandsProcessor.DEPOSIT)
    public void handleWithdraw(Withdraw command) {
        execute(command);
    }

    private void execute(Command command) {
        command.execute(eventsStore);
    }
}
