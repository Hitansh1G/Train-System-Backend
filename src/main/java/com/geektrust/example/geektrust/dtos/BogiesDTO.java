package com.geektrust.example.geektrust.dtos;

import com.geektrust.example.geektrust.entities.Bogie;
import com.geektrust.example.geektrust.entities.Station;
import com.geektrust.example.geektrust.repositories.IBogieRepository;
import com.geektrust.example.geektrust.repositories.IStationRepository;

import java.util.LinkedList;
import java.util.List;

import static com.geektrust.example.geektrust.Constants.Constants.ENGINE;

public class BogiesDTO {
    private static Bogie createBogie(IBogieRepository bogieRepository, IStationRepository stationRepository, String bogieName) {
        Bogie bogie;
        if (bogieName.equals(ENGINE)) {
            // If the name is equal to "ENGINE"
            bogie = new Bogie(null);
        } else {
            // Find the station
            Station station = stationRepository.findStationByCode(bogieName);
            bogie = new Bogie(station);
        }
        bogie = bogieRepository.save(bogie);
        return bogie;
    }

    public static LinkedList<Bogie> createListOfBogies(IBogieRepository bogieRepository, IStationRepository stationRepository, List<String> bogies) {
        LinkedList<Bogie> newBogies = new LinkedList<>();
        for (String bogieName : bogies) {
            newBogies.add(createBogie(bogieRepository, stationRepository, bogieName));
        }
        return newBogies;
    }
}
