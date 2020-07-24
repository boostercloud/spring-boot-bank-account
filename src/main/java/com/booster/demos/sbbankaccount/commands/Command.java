package com.booster.demos.sbbankaccount.commands;

import com.booster.demos.sbbankaccount.infra.EventStore;

public interface Command {
    void execute(EventStore eventsStore);
}
