package com.booster.demos.sbbankaccount.infrastructure.commandhandlers;

import com.booster.demos.sbbankaccount.commands.Deposit;
import com.booster.demos.sbbankaccount.infrastructure.CommandsProcessor;
import com.booster.demos.sbbankaccount.infrastructure.EventStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(CommandsProcessor.class)
public class DepositHandler extends CommandHandler {
    @Autowired
    public DepositHandler(EventStore eventsStore) {
        super(eventsStore);
    }

    @StreamListener(CommandsProcessor.DEPOSIT)
    public void handleDeposit(Deposit command) {
        execute(command);
    }
}