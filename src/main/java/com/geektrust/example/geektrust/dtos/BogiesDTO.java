package com.geektrust.example.geektrust.dtos;

import java.util.LinkedList;
import java.util.List;
import com.geektrust.example.geektrust.entities.Bogie;
import com.geektrust.example.geektrust.entities.Station;
import com.geektrust.example.geektrust.repositories.IBogieRepository;
import com.geektrust.example.geektrust.repositories.IStationRepository;

import static com.geektrust.example.geektrust.Util.Constants.ENGINE;

public class BogiesDTO {
    private static Bogie createBogie(IBogieRepository bogieRepository, IStationRepository stationRepository, String bogieName) {
        Bogie bogie;
        if (bogieName.equals(ENGINE)) {
            //if the name is equal to "ENGINE
            bogie = new Bogie(null);
        } else {
            // Find the station
            Station station = stationRepository.findStationByCode(bogieName);
            bogie = new Bogie(station);
        }
        bogie = bogieRepository.save(bogie);
        return bogie;
    }

    public static LinkedList<Bogie> createListOfBogies(IBogieRepository iBogieRepository, IStationRepository iStationRepository, List<String> boggies){
        LinkedList<Bogie> newBogies = new LinkedList<>();
        for (String str : boggies) {
            newBogies.add(createBogie(iBogieRepository,iStationRepository,str));
        }
        return newBogies;
    }    
}
