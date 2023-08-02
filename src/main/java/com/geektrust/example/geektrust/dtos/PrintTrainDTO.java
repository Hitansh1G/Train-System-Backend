package com.geektrust.example.geektrust.dtos;

import java.util.ArrayList;
import java.util.List;
import com.geektrust.example.geektrust.entities.Bogie;
import com.geektrust.example.geektrust.entities.Train;

import static com.geektrust.example.geektrust.Constants.Constants.ENGINE;
import static com.geektrust.example.geektrust.Constants.Constants.space;

public class PrintTrainDTO {
    public static void printTrain(Train t, String arrivalOrDeparture){
        List<String> bogies = new ArrayList<>();
        for(Bogie bogie :t.getBogies()){
            if(bogie.getdestinationStation() == null){
                bogies.add(ENGINE);
            }else{
                bogies.add(bogie.getdestinationStationCode());
            }
        }
        System.out.print(arrivalOrDeparture + space + t.getTrainName() + space + String.join(space,bogies));
        System.out.println();
    }    
}
