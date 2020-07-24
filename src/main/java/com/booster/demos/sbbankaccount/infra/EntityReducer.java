package com.booster.demos.sbbankaccount.infra;

import com.booster.demos.sbbankaccount.entities.BankAccount;
import com.booster.demos.sbbankaccount.events.*;
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
            handleBankAccountCreated((BankAccountCreated) event);
        } else if (event instanceof DepositPerformed) {
            handleDepositPerformed((DepositPerformed) event);
        } else if (event instanceof WithdrawPerformed) {
            handleWithdrawPerformed((WithdrawPerformed) event);
        } else {
            throw new UnknownEventException(event.getClass().getSimpleName());
        }
    }

    private void handleBankAccountCreated(BankAccountCreated event) {
        accountRepository.insert(BankAccount.reduceBankAccountCreated(event));
    }

    private void handleDepositPerformed(DepositPerformed event) {
        accountRepository.findByIban(event.iban)
                .map(currentAccount -> BankAccount.reduceDepositPerformed(event, currentAccount))
                .ifPresent(accountRepository::save);
    }

    private void handleWithdrawPerformed(WithdrawPerformed event) {
        accountRepository.findByIban(event.iban)
                .map(currentAccount -> BankAccount.reduceWithdrawPerformed(event, currentAccount))
                .ifPresent(accountRepository::save);
    }
}
