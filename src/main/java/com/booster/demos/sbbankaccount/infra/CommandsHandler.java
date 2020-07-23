package com.booster.demos.sbbankaccount.infra;

import com.booster.demos.sbbankaccount.commands.CreateBankAccount;
import com.booster.demos.sbbankaccount.commands.Deposit;
import com.booster.demos.sbbankaccount.commands.Withdraw;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(CommandsProcessor.class)
public class CommandsHandler {
    @StreamListener(CommandsProcessor.CREATE_BANK_ACCOUNT)
    public void handleCreateBankAccount(CreateBankAccount command) {
        command.execute();
    }

    @StreamListener(CommandsProcessor.DEPOSIT)
    public void handleDeposit(Deposit command) {
        command.execute();
    }

    @StreamListener(CommandsProcessor.DEPOSIT)
    public void handleWithdraw(Withdraw command) {
        command.execute();
    }
}
