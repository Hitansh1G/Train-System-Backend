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
        try {
            Station station = bogieName.equals(ENGINE) ? null : stationRepository.findStationByCode(bogieName);
            Bogie bogie = new Bogie(station);
            bogie = bogieRepository.save(bogie);
            return bogie;
        } catch (Exception e) {
            // Handle the exception by logging an error message or taking appropriate actions
            System.err.println("Error creating Bogie for bogieName: " + bogieName);
            e.printStackTrace();
            // You can also throw a custom exception here if needed
            // throw new CustomException("Error creating Bogie for bogieName: " + bogieName, e);
            return null;
        }
    }

    public static LinkedList<Bogie> createListOfBogies(IBogieRepository bogieRepository, IStationRepository stationRepository, List<String> bogies) {
        LinkedList<Bogie> newBogies = new LinkedList<>();
        for (String bogieName : bogies) {
            Bogie bogie = createBogie(bogieRepository, stationRepository, bogieName);
            if (bogie != null) {
                newBogies.add(bogie);
            }
        }
        return newBogies;
    }
}
