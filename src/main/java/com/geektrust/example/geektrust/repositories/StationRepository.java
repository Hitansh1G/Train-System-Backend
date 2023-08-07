package com.geektrust.example.geektrust.repositories;

import java.util.HashMap;
import java.util.List;

import com.geektrust.example.geektrust.entities.Station;

import static com.geektrust.example.geektrust.Constants.Constants.*;

public class StationRepository implements IStationRepository {
    private final HashMap<String, Station> stationListing;
    private int increment = ZERO;

    public StationRepository() {
        this.stationListing = new HashMap<>();
    }

    @Override
    public Station findStationByCode(String stationCode) {
        return stationListing.values().stream()
                .filter(station -> station.getStationCode().equals(stationCode))
                .findFirst()
                .orElse(null);
    }

    @Override
    public HashMap<String, Station> getStationListing() {
        return stationListing;
    }

    @Override
    public Station save(Station station) {
        if (station.getId() == null) {
            increment++;
            Station newStation = new Station(RANDOM + increment, station.getStationName(), station.getStationCode(), station.getDistance());
            stationListing.put(newStation.getId(), newStation);
            return newStation;
        }
        stationListing.put(station.getId(), station);
        return station;
    }

    @Override
    public List<Station> findAll() {
        return null; // TODO: Implement this method if needed
    }
}
