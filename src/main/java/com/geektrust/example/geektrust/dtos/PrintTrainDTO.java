package com.geektrust.example.geektrust.dtos;

import java.util.ArrayList;
import java.util.List;
import com.geektrust.example.geektrust.entities.Bogie;
import com.geektrust.example.geektrust.entities.Train;

import static com.geektrust.example.geektrust.Constants.Constants.ENGINE;
import static com.geektrust.example.geektrust.Constants.Constants.space;

public class PrintTrainDTO {
    public static void printTrain(Train t, String arrivalOrDeparture) {
        List<String> bogies = new ArrayList<>();
        for (Bogie bogie : t.getBogies()) {
            String bogieName = bogie.getdestinationStation() == null ? ENGINE : bogie.getdestinationStationCode();
            bogies.add(bogieName);
        }
        printTrainInfo(arrivalOrDeparture, t.getTrainName(), bogies);
    }

    private static void printTrainInfo(String arrivalOrDeparture, String trainName, List<String> bogies) {
        System.out.print(arrivalOrDeparture + space + trainName + space + String.join(space, bogies));
        System.out.println();
    }
}
