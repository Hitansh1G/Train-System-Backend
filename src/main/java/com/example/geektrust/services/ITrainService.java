package com.example.geektrust.services;

import com.example.geektrust.entities.Train;

import java.util.List;

public interface ITrainService {
    Train mergeTrain(String trainA, String trainB);
    Train travel(String trainName, String routeName, String destinationStation);
    Train createTrain(String trainName, List<String> bogies);
}
