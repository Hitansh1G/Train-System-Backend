package com.example.geektrust.repositories;

import com.example.geektrust.entities.Station;

import java.util.HashMap;

public interface IStationRepository extends CRUDRepository<Station,String> {
    Station saveStation(Station station);

    Station findStationByCode(String stationCode);

    HashMap<String, Station> getStationMap();
}
