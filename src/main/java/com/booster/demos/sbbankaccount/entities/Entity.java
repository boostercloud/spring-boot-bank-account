package com.booster.demos.sbbankaccount.entities;

import org.springframework.data.annotation.Id;

public abstract class Entity {
    @Id
    protected final String id;

    protected Entity(String id) {
        this.id = id;
    }
}
