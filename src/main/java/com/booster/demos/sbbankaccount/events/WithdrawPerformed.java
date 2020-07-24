package com.booster.demos.sbbankaccount.events;

import java.util.UUID;

public class WithdrawPerformed extends Event {
    public final UUID iban;
    public final int amount;

    public WithdrawPerformed(UUID iban, int amount) {
        this.iban = iban;
        this.amount = amount;
    }
}
