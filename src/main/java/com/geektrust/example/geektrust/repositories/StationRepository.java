package com.geektrust.example.geektrust.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    @Override
    public Station save(Station entity) {
        return null;
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
