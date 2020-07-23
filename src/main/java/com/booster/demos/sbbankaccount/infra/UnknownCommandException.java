package com.booster.demos.sbbankaccount.infra;

public class UnknownCommandException extends Throwable {
    public UnknownCommandException(String commandName) {
        super(commandName);
    }
}
