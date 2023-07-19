package com.geektrust.example.geektrust.dto;

import java.util.ArrayList;
import java.util.List;
import com.geektrust.example.geektrust.entities.Bogie;
import com.geektrust.example.geektrust.entities.Train;

public class PrintTrainDTO {
    public static void printTrain(Train t, String arrivalOrDeparture){
        List<String> bogies = new ArrayList<String>();
        for(Bogie bogie :t.getBogies()){
            if(bogie.getdestinationStation() == null){
                bogies.add("ENGINE");
            }else{
                bogies.add(bogie.getdestinationStationCode());
            }
        }
        System.out.print(arrivalOrDeparture + " "+ t.getTrainName() + " " + String.join(" ",bogies));
        System.out.println();
    }    
}
