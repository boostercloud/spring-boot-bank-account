package com.booster.demos.sbbankaccount.commands;

import com.booster.demos.sbbankaccount.infra.EventStore;
import com.booster.demos.sbbankaccount.events.WithdrawPerformed;

import java.util.UUID;

public class Withdraw implements Command {
    public UUID iban;
    public int amount;

    public Withdraw(UUID iban, int amount) {
        this.iban = iban;
        this.amount = amount;
    }

    @Override
    public void execute(EventStore eventsStore) {
        eventsStore.append(new WithdrawPerformed(iban, amount));
    }
}
