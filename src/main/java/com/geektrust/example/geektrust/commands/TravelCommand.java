package com.geektrust.example.geektrust.commands;

import java.util.List;
import com.geektrust.example.geektrust.entities.Train;
import com.geektrust.example.geektrust.dtos.PrintTrainDTO;
import com.geektrust.example.geektrust.services.ITrainService;

import static com.geektrust.example.geektrust.Constants.Constants.*;

public class TravelCommand implements ICommand {
    private final ITrainService iTrainService;

    public TravelCommand(ITrainService iTrainService) {
        this.iTrainService = iTrainService;
    }

    @Override
    public void execute(List<String> tokens) {
        try {
            String trainName = tokens.get(ZERO);
            String routeName = tokens.get(FIRST);
            String destination = tokens.get(SECOND);
            Train train = iTrainService.travel(trainName, routeName, destination);
            PrintTrainDTO.printTrain(train, ARRIVAL);
        } catch (Exception ignored) {
        }
    }
    
}
