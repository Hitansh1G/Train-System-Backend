package com.geektrust.example.geektrust.dto;

import java.util.LinkedList;
import java.util.List;
import com.geektrust.example.geektrust.entities.Bogie;
import com.geektrust.example.geektrust.entities.Station;
import com.geektrust.example.geektrust.repositories.IBoggyRepository;
import com.geektrust.example.geektrust.repositories.IStationRepository;

public class CreateListOfBoggies {
    private static Bogie createBoggy(IBoggyRepository iBoggyRepository, IStationRepository iStationRepository, String boggyName){
        Bogie bogie;
        if (boggyName.equals("ENGINE")) {
            bogie = new Bogie(null);
            bogie = iBoggyRepository.saveBoggy(bogie);
        } else {
            // Find the station
            Station stn = iStationRepository.findStationByCode(boggyName);
            bogie = new Bogie(stn);
            bogie = iBoggyRepository.saveBoggy(bogie);
        }
        return bogie;
    }
    public static LinkedList<Bogie> createListOfBoggies(IBoggyRepository iBoggyRepository, IStationRepository iStationRepository, List<String> boggies){
        LinkedList<Bogie> newBoggies = new LinkedList<Bogie>();
        for (String str : boggies) {
            newBoggies.add(createBoggy(iBoggyRepository,iStationRepository,str));
        }
        return newBoggies;
    }    
}
