package com.booster.demos.sbbankaccount.infrastructure.message;

import com.booster.demos.sbbankaccount.commands.Withdraw;
import com.booster.demos.sbbankaccount.infrastructure.EventStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(CommandsProcessor.class)
public class WithdrawHandler extends CommandHandler {
    @Autowired
    public WithdrawHandler(EventStore eventsStore) {
        super(eventsStore);
    }

    @StreamListener(CommandsProcessor.WITHDRAW)
    public void handleWithdraw(Withdraw command) {
        execute(command);
    }
}