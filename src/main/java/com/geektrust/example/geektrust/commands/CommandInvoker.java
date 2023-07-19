package com.geektrust.example.geektrust.commands;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.geektrust.example.geektrust.exceptions.NotFoundException;

public class CommandInvoker {
    private static final Map<String, ICommand> commandMap = new HashMap<>();

    // put command into hashmap
    public void register(String commandName, ICommand command) {
        commandMap.put(commandName, command);
    }

    // find the registered command
    private ICommand get(String commandName) {
        return commandMap.get(commandName);
    }

    // execute the command
    public void executeCommand(String commandName, List<String> tokens) throws NotFoundException {
        ICommand command = get(commandName);
        if (command == null) {
            throw new NotFoundException();
        }
        command.execute(tokens);
    }
    
}
