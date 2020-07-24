package com.booster.demos.sbbankaccount.infrastructure;

public class UnknownEventException extends RuntimeException {
    public UnknownEventException(String event) {
        super(event);
    }
}
