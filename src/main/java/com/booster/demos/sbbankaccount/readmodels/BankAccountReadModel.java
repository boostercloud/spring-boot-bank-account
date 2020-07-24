package com.booster.demos.sbbankaccount.readmodels;

import com.booster.demos.sbbankaccount.entities.BankAccount;

import java.util.UUID;

public class BankAccountReadModel {
    public final UUID id;
    public final UUID iban;
    public final int balance;

    public BankAccountReadModel(BankAccount bankAccount) {
        this.id = bankAccount.owner;
        this.iban = bankAccount.iban;
        this.balance = bankAccount.balance;
    }
}
