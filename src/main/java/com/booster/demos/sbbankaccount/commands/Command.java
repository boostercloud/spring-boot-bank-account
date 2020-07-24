package com.booster.demos.sbbankaccount.commands;

import com.booster.demos.sbbankaccount.infrastructure.EventStore;

public interface Command {
    void execute(EventStore eventsStore);
}
