package com.booster.demos.sbbankaccount.commands;

import java.io.Serializable;

public interface Command extends Serializable {
    boolean execute();
}
