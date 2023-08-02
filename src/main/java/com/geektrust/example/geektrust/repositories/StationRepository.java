package com.geektrust.example.geektrust.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import com.geektrust.example.geektrust.entities.Station;

import static com.geektrust.example.geektrust.Constants.Constants.RANDOM;
import static com.geektrust.example.geektrust.Constants.Constants.ZERO;

public class StationRepository implements IStationRepository {
    private final HashMap<String, Station> stationListing;
    private Integer Increment = ZERO;

    public StationRepository() {
        this.stationListing = new HashMap<>();
    }

    @Override
    public Station findStationByCode(String stationCode) {
        return stationListing.values().stream().filter(station -> station.getStationCode().equals(stationCode)).findFirst(). orElse(null);
    }

    @Override
    public HashMap<String, Station> getStationListing() {
        return stationListing;
    }

    @Override
    public Station save(Station station) {
        if (station.getId() == null) {
            Increment++;
            Station newStation = new Station(RANDOM + Increment, station.getStationName(), station.getStationCode(), station.getDistance());
            stationListing.put(newStation.getId(), newStation);
            return newStation;
        }
        stationListing.put(station.getId(), station);
        return station;
    }


    @Override
    public List<Station> findAll() {
        return null;
    }

    @Override
    public Optional<Station> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public void delete(Station entity) {

    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public long count() {
        return 0;
    }
}
