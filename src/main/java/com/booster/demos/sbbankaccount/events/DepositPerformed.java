package com.booster.demos.sbbankaccount.events;

import java.util.UUID;

public class DepositPerformed extends Event {
    public final UUID iban;
    public final int amount;

    public DepositPerformed(UUID iban, int amount) {
        this.iban = iban;
        this.amount = amount;
    }

    @Override
    public UUID getEntityId() {
        return this.iban;
    }
}
