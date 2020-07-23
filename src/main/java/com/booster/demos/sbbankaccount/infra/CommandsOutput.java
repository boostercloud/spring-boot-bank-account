package com.booster.demos.sbbankaccount.infra;


import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface CommandsOutput {
    String OUTPUT = "commands";

    @Output(CommandsOutput.OUTPUT)
    MessageChannel output();
}
