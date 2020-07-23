package com.booster.demos.sbbankaccount.commands;

import java.util.UUID;

public class Deposit implements Command{
    public UUID iban;
    public int amount;

    public Deposit(UUID iban, int amount) {
        this.iban = iban;
        this.amount = amount;
    }

    @Override
    public boolean execute() {
        return false;
    }
}
