package com.booster.demos.sbbankaccount.events;

import java.util.UUID;

public class DepositPerformed extends Event {
    private UUID iban;
    private int amount;

    public DepositPerformed(UUID iban, int amount) {
        this.iban = iban;
        this.amount = amount;
    }
}
