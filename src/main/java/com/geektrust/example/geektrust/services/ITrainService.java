package com.geektrust.example.geektrust.services;

import java.util.List;
import com.geektrust.example.geektrust.entities.Train;

public interface ITrainService {
    Train mergeTrain(String trainAName, String trainBName);

    Train travel(String trainName, String routeName, String dest);

    void createTrain(String trainName, List<String> bogies);
}
