package com.geektrust.example.geektrust.commands;

import static com.geektrust.example.geektrust.Constants.Constants.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;
import java.util.ArrayList;
import com.geektrust.example.geektrust.exceptions.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CommandInvokerTest {
    private CommandInvoker invoker;

    @Mock
    DataCommand dataCommand;

    @Mock
    LoadTrainDataCommand loadTrainDataCommand;

    @Mock
    TravelCommand travelCommand;

    @Mock
    MergeTrainCommand mergeTrainCommand;
    
    @BeforeEach
    void setup(){
        invoker = new CommandInvoker();
        invoker.register(LOAD_DATA, dataCommand);
        invoker.register(FIRST_TRAIN, loadTrainDataCommand);
        invoker.register(SECOND_TRAIN, loadTrainDataCommand);
        invoker.register(TRAVEL, travelCommand);
        invoker.register(MERGE, mergeTrainCommand);
    }

    @Test
    @DisplayName("execute command test")
    public void execute_command_test(){
        //Act
        invoker.executeCommand(LOAD_DATA, anyList());
        invoker.executeCommand(FIRST_TRAIN, anyList());
        invoker.executeCommand(TRAVEL, anyList());
        invoker.executeCommand(MERGE, anyList());

        //Assert
        verify(dataCommand).execute(anyList());
        verify(loadTrainDataCommand).execute(anyList());
        verify(travelCommand).execute(anyList());
        verify(mergeTrainCommand).execute(anyList());
    }

    @Test
    @DisplayName("Command not present must return exception")
    public void executeCommandMustReturnExceptionIfCommandNotPresent() {
        //Act and assert
        assertThrows(NotFoundException.class, () -> invoker.executeCommand("NOT_PRESENT", new ArrayList<String>()));
    }
}
