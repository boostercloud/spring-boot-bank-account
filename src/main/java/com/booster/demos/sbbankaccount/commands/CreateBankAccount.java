package com.booster.demos.sbbankaccount.commands;

import com.booster.demos.sbbankaccount.infrastructure.EventStore;
import com.booster.demos.sbbankaccount.events.BankAccountCreated;
import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.UUID;

public class CreateBankAccount implements Command {
    public UUID owner;

    @JsonCreator
    public CreateBankAccount(UUID owner) {
        this.owner = owner;
    }

    @Override
    public void execute(EventStore events) {
        events.append(new BankAccountCreated(UUID.randomUUID(), this.owner));
    }
}
