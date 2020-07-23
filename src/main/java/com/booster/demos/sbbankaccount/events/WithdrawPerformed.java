package com.booster.demos.sbbankaccount.events;

import java.util.UUID;

public class WithdrawPerformed extends Event {
    private UUID iban;
    private int amount;

    public WithdrawPerformed(UUID iban, int amount) {
        this.iban = iban;
        this.amount = amount;
    }
}
