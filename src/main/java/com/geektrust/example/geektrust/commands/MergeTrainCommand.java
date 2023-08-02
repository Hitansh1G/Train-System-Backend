package com.geektrust.example.geektrust.commands;

import java.util.List;
import com.geektrust.example.geektrust.entities.Train;
import com.geektrust.example.geektrust.dtos.PrintTrainDTO;
import com.geektrust.example.geektrust.services.ITrainService;

import static com.geektrust.example.geektrust.Constants.Constants.DEPARTURE;

public class MergeTrainCommand implements ICommand {
    private final ITrainService iTrainService;

    public MergeTrainCommand(ITrainService iTrainService) {
        this.iTrainService = iTrainService;
    }

    @Override
    public void execute(List<String> tokens) {
        try {
            String trainA = tokens.get(0);
            String trainB = tokens.get(1);
            Train train = iTrainService.mergeTrain(trainA, trainB);
            PrintTrainDTO.printTrain(train, DEPARTURE);
        } catch (Exception ignored) {
        }
        
    }
    
}
