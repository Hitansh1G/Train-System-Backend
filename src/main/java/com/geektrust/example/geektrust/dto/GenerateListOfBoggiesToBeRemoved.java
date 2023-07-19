package com.geektrust.example.geektrust.dto;

import java.util.LinkedList;
import java.util.List;
import com.geektrust.example.geektrust.entities.Bogie;
import com.geektrust.example.geektrust.entities.Station;

public class GenerateListOfBoggiesToBeRemoved {
    private static void detachedBoggies(Station station, LinkedList<Bogie> boggies, List<Bogie> boggiesToBeRemoved){
        for (Bogie bogie : boggies) {
            if (bogie.getdestinationStation()!= null && bogie.getdestinationStation().equals(station)) {
                boggiesToBeRemoved.add(bogie);
            }
        }
    }
    public static List<Bogie> generateListOfBoggiesToBeRemoved(LinkedList<Station> stations, LinkedList<Bogie> boggies, String dest ){
        List<Bogie> boggiesToBeRemoved = new LinkedList<Bogie>();
        for (Station stn : stations) {
            if (stn.getStationCode().equals(dest)) {
                break;
            }
            detachedBoggies(stn, boggies,boggiesToBeRemoved);       
        }  
        return boggiesToBeRemoved;      
    }  
}
