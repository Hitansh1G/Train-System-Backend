package com.geektrust.example.geektrust.dto;

import java.util.ArrayList;
import java.util.List;
import com.geektrust.example.geektrust.entities.Bogie;
import com.geektrust.example.geektrust.entities.Train;

public class PrintTrain {
    public static void printTrain(Train t, String arrivalOrDeparture){
        List<String> boggies = new ArrayList<String>();
        for(Bogie bogie :t.getBoggies()){
            if(bogie.getdestinationStation() == null){
                boggies.add("ENGINE");
            }else{
                boggies.add(bogie.getdestinationStationCode());
            }
        }
        System.out.print(arrivalOrDeparture + " "+ t.getTrainName() + " " + String.join(" ",boggies));
        System.out.println();
    }    
}
