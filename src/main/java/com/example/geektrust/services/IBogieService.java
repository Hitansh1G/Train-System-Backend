package com.example.geektrust.services;

import com.example.geektrust.entities.Bogie;
import com.example.geektrust.entities.Station;
import com.example.geektrust.repositories.BogieRepository;
import com.example.geektrust.repositories.IBogieRepository;
import com.example.geektrust.repositories.IStationRepository;

import java.util.LinkedList;
import java.util.List;

public interface IBogieService {
    Bogie createBogie(IBogieRepository iBogieRepository, IStationRepository iStationRepository, String bogieName);
    LinkedList<Bogie>createListOfBogies(IBogieRepository iBogieRepository, IStationRepository iStationRepository, List<String> bogies );

    void detachedBogie(Station station, LinkedList<Bogie> bogies,List<Bogie> bogiesToBeRemoved);
    List<Bogie> generateListOfBogiesToBeRemoved(LinkedList<Station> stations,LinkedList<Bogie> bogies,String dest );
    int compareBogie(Bogie bogie1 , Bogie bogie2);
}
