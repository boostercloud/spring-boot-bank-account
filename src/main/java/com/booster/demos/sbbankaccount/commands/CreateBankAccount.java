package com.booster.demos.sbbankaccount.commands;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.UUID;

public class CreateBankAccount implements Command {
    public UUID owner;

    @JsonCreator
    public CreateBankAccount(UUID owner) {
        this.owner = owner;
    }

    @Override
    public void execute() {
        System.out.println(this.owner);
    }
}
