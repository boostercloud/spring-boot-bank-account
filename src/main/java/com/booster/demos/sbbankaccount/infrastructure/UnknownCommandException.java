package com.booster.demos.sbbankaccount.infrastructure;

public class UnknownCommandException extends Throwable {
    public UnknownCommandException(String commandName) {
        super(commandName);
    }
}
