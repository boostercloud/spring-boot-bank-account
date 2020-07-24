package com.booster.demos.sbbankaccount.events;

import java.util.UUID;

public class BankAccountCreated extends Event {
    public final UUID iban;
    public final UUID owner;

    public BankAccountCreated(UUID iban, UUID owner) {
        this.iban = iban;
        this.owner = owner;
    }
}
