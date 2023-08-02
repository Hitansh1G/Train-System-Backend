package com.geektrust.example.geektrust.commands;

import java.util.List;
import com.geektrust.example.geektrust.services.ITrainService;

public class LoadTrainDataCommand implements ICommand {
    private final ITrainService iTrainService;

    public LoadTrainDataCommand(ITrainService iTrainService) {
        this.iTrainService = iTrainService;
    }

    @Override
    public void execute(List<String> tokens) {
        try {
            int FIRST = 0;
            iTrainService.createTrain(tokens.get(FIRST), tokens.subList(1, tokens.size()));
        } catch (Exception e) {
//            e.printStackTrace();
        }        
    }
    
}
