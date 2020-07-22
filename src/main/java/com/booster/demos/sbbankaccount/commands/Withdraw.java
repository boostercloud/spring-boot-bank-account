package com.booster.demos.sbbankaccount.commands;

import java.util.UUID;

public class Withdraw implements Command {
    public final UUID iban;
    public final int amount;

    public Withdraw(UUID iban, int amount) {
        this.iban = iban;
        this.amount = amount;
    }

    @Override
    public boolean execute() {
        return false;
    }
}
