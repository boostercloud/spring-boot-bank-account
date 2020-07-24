package com.booster.demos.sbbankaccount.infrastructure.commandhandlers;

import com.booster.demos.sbbankaccount.commands.Command;
import com.booster.demos.sbbankaccount.infrastructure.EventStore;

abstract public class CommandHandler {
    protected final EventStore eventsStore;

    public CommandHandler(EventStore eventsStore) {
        this.eventsStore = eventsStore;
    }

    protected void execute(Command command) {
        command.execute(eventsStore);
    }
}
