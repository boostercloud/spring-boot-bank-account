package com.booster.demos.sbbankaccount.entities;

import java.util.UUID;

public class BankAccount {
    private final UUID iban;
    private final UUID owner;
    private final int balance;

    public BankAccount(UUID iban, UUID owner, int balance) {
        this.iban = iban;
        this.owner = owner;
        this.balance = balance;
    }

    public UUID getIban() {
        return iban;
    }

    public UUID getOwner() {
        return owner;
    }

    public int getBalance() {
        return balance;
    }
}
