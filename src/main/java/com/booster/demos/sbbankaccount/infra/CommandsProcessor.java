package com.booster.demos.sbbankaccount.infra;


import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface CommandsProcessor {
    String CREATE_BANK_ACCOUNT = "commands.create-bank-account";
    String DEPOSIT = "commands.deposit";
    String WITHDRAW = "commands.withdraw";

    @Output(CommandsProcessor.CREATE_BANK_ACCOUNT)
    MessageChannel createBankAccountOutput();

    @Input(CommandsProcessor.CREATE_BANK_ACCOUNT)
    SubscribableChannel createBankAccountInput();

    @Output(CommandsProcessor.DEPOSIT)
    MessageChannel depositOutput();

    @Output(CommandsProcessor.WITHDRAW)
    MessageChannel withdrawOutput();
}