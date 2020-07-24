package com.booster.demos.sbbankaccount.events;

public class UnknownEvent extends RuntimeException {
    public UnknownEvent(String event) {
        super(event);
    }
}
