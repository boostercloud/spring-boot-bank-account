package com.booster.demos.sbbankaccount.entities;

import com.booster.demos.sbbankaccount.events.BankAccountCreated;
import com.booster.demos.sbbankaccount.events.DepositPerformed;
import com.booster.demos.sbbankaccount.events.WithdrawPerformed;

import java.util.UUID;

public class BankAccount extends Entity {
    public final UUID iban;
    public final UUID owner;
    public final int balance;

    public BankAccount(String id, UUID iban, UUID owner, int balance) {
        super(id);
        this.iban = iban;
        this.owner = owner;
        this.balance = balance;
    }

    public static BankAccount reduce(BankAccountCreated event, BankAccount currentAccount) {
        return new BankAccount(null, event.iban, event.owner, 0);
    }

    public static BankAccount reduce(DepositPerformed event, BankAccount currentAccount) {
        int newBalance = currentAccount.balance + event.amount;
        return new BankAccount(currentAccount.id, currentAccount.iban, currentAccount.owner, newBalance);
    }

    public static BankAccount reduce(WithdrawPerformed event, BankAccount currentAccount) {
        int newBalance = currentAccount.balance - event.amount;
        return new BankAccount(currentAccount.id, currentAccount.iban, currentAccount.owner, newBalance);
    }
}
