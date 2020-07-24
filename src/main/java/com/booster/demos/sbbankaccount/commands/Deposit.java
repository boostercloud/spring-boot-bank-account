package com.booster.demos.sbbankaccount.commands;

import com.booster.demos.sbbankaccount.infra.EventStore;
import com.booster.demos.sbbankaccount.events.DepositPerformed;

import java.util.UUID;

public class Deposit implements Command {
    public UUID iban;
    public int amount;

    public Deposit(UUID iban, int amount) {
        this.iban = iban;
        this.amount = amount;
    }

    @Override
    public void execute(EventStore eventsStore) {
        eventsStore.append(new DepositPerformed(iban, amount));
    }
}
