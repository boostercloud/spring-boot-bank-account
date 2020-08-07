package com.booster.demos.sbbankaccount.infrastructure.message;

public class UnknownCommandException extends Throwable {
    public UnknownCommandException(String commandName) {
        super(commandName);
    }
}
