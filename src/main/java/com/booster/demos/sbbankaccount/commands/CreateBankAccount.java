package com.booster.demos.sbbankaccount.commands;

import java.util.UUID;

public class CreateBankAccount implements Command {
    public final UUID owner;

    public CreateBankAccount(UUID owner) {
        this.owner = owner;
    }

    public boolean execute() {
        return false;
    }
}
