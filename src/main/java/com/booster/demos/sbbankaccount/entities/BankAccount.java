package com.booster.demos.sbbankaccount.entities;

import com.booster.demos.sbbankaccount.events.BankAccountCreated;
import com.booster.demos.sbbankaccount.events.DepositPerformed;
import com.booster.demos.sbbankaccount.events.WithdrawPerformed;

import java.util.UUID;

public class BankAccount {
    public final UUID iban;
    public final UUID owner;
    public final int balance;

    public BankAccount(UUID iban, UUID owner, int balance) {
        this.iban = iban;
        this.owner = owner;
        this.balance = balance;
    }

    public static BankAccount reduceBankAccountCreated(BankAccountCreated event) {
        return new BankAccount(event.iban, event.owner, 0);
    }

    public static BankAccount reduceDepositPerformed(DepositPerformed event, BankAccount currentAccount) {
        int newBalance = currentAccount.balance + event.amount;
        return new BankAccount(currentAccount.iban, currentAccount.owner, newBalance);
    }

    public static BankAccount reduceWithdrawPerformed(WithdrawPerformed event, BankAccount currentAccount) {
        int newBalance = currentAccount.balance - event.amount;
        return new BankAccount(currentAccount.iban, currentAccount.owner, newBalance);
    }
}
