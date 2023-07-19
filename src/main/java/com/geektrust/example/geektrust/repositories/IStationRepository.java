package com.geektrust.example.geektrust.repositories;

import java.util.HashMap;
import com.geektrust.example.geektrust.entities.Station;

public interface IStationRepository {
    Station saveStation(Station station);

    Station findStationByCode(String stationCode); 
    
    HashMap<String, Station> getStationListing();
}
