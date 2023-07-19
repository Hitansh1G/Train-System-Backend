package com.geektrust.example.geektrust.commands;

import java.util.List;
import com.geektrust.example.geektrust.entities.Train;
import com.geektrust.example.geektrust.dtos.PrintTrainDTO;
import com.geektrust.example.geektrust.services.ITrainService;

import static com.geektrust.example.geektrust.Util.Constants.DEPARTURE;

public class MergeTrainCommand implements ICommand {
    private final ITrainService iTrainService;

    public MergeTrainCommand(ITrainService iTrainService) {
        this.iTrainService = iTrainService;
    }

    @Override
    public void execute(List<String> tokens) {
        try {
            int FIRST = 0;
            String trainA = tokens.get(FIRST);
            int SECOND = 1;
            String trainB = tokens.get(SECOND);
            Train train = iTrainService.mergeTrain(trainA, trainB);
            PrintTrainDTO.printTrain(train, DEPARTURE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
