package com.geektrust.example.geektrust.repositories;

import java.util.HashMap;
import com.geektrust.example.geektrust.entities.Station;

public interface IStationRepository extends CRUDRepository<Station,String>{

    Station findStationByCode(String stationCode); 
    
    HashMap<String, Station> getStationListing();
}
