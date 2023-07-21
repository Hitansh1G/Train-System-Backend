package com.geektrust.example.geektrust.dtos;

import java.util.LinkedList;
import java.util.List;
import com.geektrust.example.geektrust.entities.Bogie;
import com.geektrust.example.geektrust.entities.Station;

public class GeneratedListDTO {

    private static void detachedBogies(Station station, LinkedList<Bogie> bogies, List<Bogie> bogiesToRemoved){
        for (Bogie bogie : bogies) {
            if (bogie.getdestinationStation()!= null && bogie.getdestinationStation().equals(station)) {
                bogiesToRemoved.add(bogie);
            }
        }
    }
    public static List<Bogie> generateBogiesToRemoved(LinkedList<Station> stations, LinkedList<Bogie> bogies, String dest ){
        List<Bogie> bogiesToRemoved = new LinkedList<>();
        for (Station stn : stations) {
            if (stn.getStationCode().equals(dest)) {
                break;
            }
            detachedBogies(stn, bogies,bogiesToRemoved);
        }  
        return bogiesToRemoved;
    }  
}
