package com.geektrust.example.geektrust.commands;

import java.util.List;
import com.geektrust.example.geektrust.entities.Train;
import com.geektrust.example.geektrust.dtos.PrintTrainDTO;
import com.geektrust.example.geektrust.services.ITrainService;

import static com.geektrust.example.geektrust.Constants.Constants.ARRIVAL;

public class TravelCommand implements ICommand {
    private final ITrainService iTrainService;

    public TravelCommand(ITrainService iTrainService) {
        this.iTrainService = iTrainService;
    }

    @Override
    public void execute(List<String> tokens) {
        try {
//            int FIRST = 0;
//            int SECOND = 1;
//            int THIRD = 2;
            String trainName = tokens.get(0);
            String routeName = tokens.get(1);
            String destination = tokens.get(2);
            Train train = iTrainService.travel(trainName, routeName, destination);
            PrintTrainDTO.printTrain(train, ARRIVAL);
        } catch (Exception ignored) {
        }
    }
    
}
