package com.booster.demos.sbbankaccount.events;

import org.springframework.data.annotation.Id;

import java.util.UUID;

public abstract class Event {
    @Id
    private String id;

    public abstract UUID getEntityId();
}
