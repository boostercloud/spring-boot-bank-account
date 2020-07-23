package com.booster.demos.sbbankaccount.infra;

import com.booster.demos.sbbankaccount.commands.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(CommandsOutput.class)
public class CommandsSender {
    private final CommandsOutput commandsOutput;

    @Autowired
    public CommandsSender(CommandsOutput commandsOutput) {
        this.commandsOutput = commandsOutput;
    }

    public boolean send(Command payload) {
        return commandsOutput.output().send(MessageBuilder.withPayload(payload).build());
    }
}
