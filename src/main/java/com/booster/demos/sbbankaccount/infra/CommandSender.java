package com.booster.demos.sbbankaccount.infra;

import com.booster.demos.sbbankaccount.commands.Command;
import com.booster.demos.sbbankaccount.commands.CreateBankAccount;
import com.booster.demos.sbbankaccount.commands.Deposit;
import com.booster.demos.sbbankaccount.commands.Withdraw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(CommandsProcessor.class)
public class CommandSender {
    private final CommandsProcessor router;

    @Autowired
    public CommandSender(CommandsProcessor commandsProcessor) {
        this.router = commandsProcessor;
    }

    public boolean send(Command command) throws UnknownCommandException {
        Message<Command> message = MessageBuilder.withPayload(command).build();
        switch (command.getClass().getSimpleName()) {
            case "CreateBankAccount":
                return router.createBankAccountOutput().send(message);
            case "Deposit":
                return router.depositOutput().send(message);
            case "Withdraw":
                return router.withdrawOutput().send(message);
            default:
                throw new UnknownCommandException(command.getClass().getSimpleName());
        }
    }

    public boolean withdraw(Withdraw command) {
        return router.createBankAccountOutput().send(MessageBuilder.withPayload(command).build());
    }
}
