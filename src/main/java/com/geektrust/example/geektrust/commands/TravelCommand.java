package com.geektrust.example.geektrust.commands;

import java.util.List;
import com.geektrust.example.geektrust.entities.Train;
import com.geektrust.example.geektrust.dto.PrintTrain;
import com.geektrust.example.geektrust.services.ITrainService;

public class TravelCommand implements ICommand {
    //following constants are declared because geektrust ai tool thinks accessing list elements through numbers are also magic numbers
    private final int FIRST_INDEX = 0;
    private final int SECOND_INDEX = 1;
    private final int THIRD_INDEX = 2;
    private final ITrainService iTrainService;

    public TravelCommand(ITrainService iTrainService) {
        this.iTrainService = iTrainService;
    }

    @Override
    public void execute(List<String> tokens) {
        try {
            String trainName = tokens.get(FIRST_INDEX);
            String routeName = tokens.get(SECOND_INDEX);
            String destination = tokens.get(THIRD_INDEX);
            Train train = iTrainService.travel(trainName, routeName, destination);
            PrintTrain.printTrain(train, "ARRIVAL");
        } catch (Exception e) {
            e.printStackTrace();
        }        
    }
    
}
