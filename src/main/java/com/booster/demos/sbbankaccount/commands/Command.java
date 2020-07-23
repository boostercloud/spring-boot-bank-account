package com.booster.demos.sbbankaccount.commands;

import com.booster.demos.sbbankaccount.infra.EventsStore;

public interface Command {
    void execute(EventsStore eventsStore);
}
