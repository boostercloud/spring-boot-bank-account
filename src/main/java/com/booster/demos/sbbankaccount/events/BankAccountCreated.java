package com.booster.demos.sbbankaccount.events;

import java.util.UUID;

public class BankAccountCreated extends Event {
    private UUID iban;
    private UUID owner;

    public BankAccountCreated(UUID iban, UUID owner) {
        this.iban = iban;
        this.owner = owner;
    }
}
