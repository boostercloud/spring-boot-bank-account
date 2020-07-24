package com.booster.demos.sbbankaccount.infra;

public class UnknownEventException extends RuntimeException {
    public UnknownEventException(String event) {
        super(event);
    }
}
