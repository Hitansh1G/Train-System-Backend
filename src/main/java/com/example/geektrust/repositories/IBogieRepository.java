package com.example.geektrust.repositories;

import com.example.geektrust.entities.Bogie;
import com.example.geektrust.entities.Station;
import com.example.geektrust.entities.Train;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public interface IBogieRepository extends CRUDRepository<Bogie,String> {
    Bogie saveBogie(Bogie bogie);
    HashMap<String , Bogie> BogieListing();
    List<Bogie> generateListOfBogiesToBeRemoved(LinkedList<Station> stations, LinkedList<Bogie> bogies, String dest);
    void detachedBogie(Station station, LinkedList<Bogie> bogies, List<Bogie> bogiesToBeRemoved);
    LinkedList<Bogie> createListOfBogies(IBogieRepository iBogieRepository, IStationRepository iStationRepository, List<String> bogies);
    Bogie createBogie(IBogieRepository iBogieRepository, IStationRepository iStationRepository, String bogieName);

}
