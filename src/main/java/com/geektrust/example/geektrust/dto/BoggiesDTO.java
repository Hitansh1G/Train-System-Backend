package com.geektrust.example.geektrust.dto;

import java.util.LinkedList;
import java.util.List;
import com.geektrust.example.geektrust.entities.Bogie;
import com.geektrust.example.geektrust.entities.Station;
import com.geektrust.example.geektrust.repositories.IBogieRepository;
import com.geektrust.example.geektrust.repositories.IStationRepository;

public class BoggiesDTO {
    private static Bogie createBoggy(IBogieRepository iBogieRepository, IStationRepository iStationRepository, String boggyName){
        Bogie bogie;
        if (boggyName.equals("ENGINE")) {
            bogie = new Bogie(null);
            bogie = iBogieRepository.save(bogie);
        } else {
            // Find the station
            Station stn = iStationRepository.findStationByCode(boggyName);
            bogie = new Bogie(stn);
            bogie = iBogieRepository.save(bogie);
        }
        return bogie;
    }
    public static LinkedList<Bogie> createListOfBoggies(IBogieRepository iBogieRepository, IStationRepository iStationRepository, List<String> boggies){
        LinkedList<Bogie> newBoggies = new LinkedList<Bogie>();
        for (String str : boggies) {
            newBoggies.add(createBoggy(iBogieRepository,iStationRepository,str));
        }
        return newBoggies;
    }    
}
