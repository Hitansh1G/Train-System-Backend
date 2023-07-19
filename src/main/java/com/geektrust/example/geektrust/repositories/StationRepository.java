package com.geektrust.example.geektrust.repositories;

import java.util.HashMap;
import java.util.Map;
import com.geektrust.example.geektrust.entities.Station;

public class StationRepository implements IStationRepository {
    private HashMap<String, Station> stationListing;
    private Integer Increment = 0;

    public StationRepository() {
        this.stationListing = new HashMap<String, Station>();
    }

    public StationRepository(HashMap<String,Station> stationListing){
        this.stationListing = stationListing;
    }

    @Override
    public Station saveStation(Station station) {
        if(station.getId() == null){
            Increment++;
            Station newStation = new Station(Integer.toString(Increment), station.getStationName(),
                    station.getStationCode(), station.getDistance());
            stationListing.put(newStation.getId(), newStation);
            return newStation;
        }
        stationListing.put(station.getId(), station);
        return station;        
    }

    @Override
    public Station findStationByCode(String stationCode) {
        Station station = stationListing.entrySet().stream().filter(e -> e.getValue().getStationCode().equals(stationCode))
                .map(Map.Entry::getValue).findFirst().get();
        return station;
    }

    @Override
    public HashMap<String, Station> getStationListing() {
        return stationListing;
    }
    
}
