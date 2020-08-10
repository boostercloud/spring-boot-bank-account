package com.booster.demos.sbbankaccount.infrastructure.message;

import com.booster.demos.sbbankaccount.commands.CreateBankAccount;
import com.booster.demos.sbbankaccount.infrastructure.EventStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(CommandsProcessor.class)
public class CreateBankAccountHandler extends CommandHandler {
    @Autowired
    public CreateBankAccountHandler(EventStore eventsStore) {
        super(eventsStore);
    }

    @StreamListener(CommandsProcessor.CREATE_BANK_ACCOUNT)
    public void handleCreateBankAccount(CreateBankAccount command) {
        execute(command);
    }
}
