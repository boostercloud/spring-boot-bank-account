package com.booster.demos.sbbankaccount.infrastructure;

import com.booster.demos.sbbankaccount.entities.BankAccount;
import com.booster.demos.sbbankaccount.events.BankAccountCreated;
import com.booster.demos.sbbankaccount.events.DepositPerformed;
import com.booster.demos.sbbankaccount.events.Event;
import com.booster.demos.sbbankaccount.events.WithdrawPerformed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EntityReducer {
    private final BankAccountRepository accountRepository;

    @Autowired
    public EntityReducer(BankAccountRepository bankAccountRepository) {
        this.accountRepository = bankAccountRepository;
    }

    public void reduce(Event event) {
        if (event instanceof BankAccountCreated) {
            save(BankAccount.reduce((BankAccountCreated) event, currentBankAccount(event)));
        } else if (event instanceof DepositPerformed) {
            save(BankAccount.reduce((DepositPerformed) event, currentBankAccount(event)));
        } else if (event instanceof WithdrawPerformed) {
            save(BankAccount.reduce((WithdrawPerformed) event, currentBankAccount(event)));
        } else {
            throw new UnknownEventException(event.getClass().getSimpleName());
        }
    }

    private void save(BankAccount entity) {
        accountRepository.save(entity);
    }

    private BankAccount currentBankAccount(Event event) {
        return accountRepository.findByEntityId(event.getEntityId()).orElse(null);
    }
}
