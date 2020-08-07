package com.booster.demos.sbbankaccount.entities;

import javax.validation.constraints.NotNull;
import java.util.List;

public class User extends Entity {
    @NotNull
    public final String username;
    @NotNull
    public final String password;
    public final List<String> roles;

    protected User(String id, String username, String password, List<String> roles) {
        super(id);
        this.username = username;
        this.password = password;
        this.roles = roles;
    }
}
