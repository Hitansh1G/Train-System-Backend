package com.example.geektrust.repositories;

import com.example.geektrust.entities.Route;
import com.example.geektrust.entities.Station;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class StationRepository implements IStationRepository{

    private HashMap<String, Station> stationListing;

    public StationRepository(){
        this.stationListing = new HashMap<String, Station>();
    }

    public StationRepository(HashMap<String,Station>stationListing){
        this.stationListing = stationListing;
    }

    private Integer identification=0;
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

    @Override
    public Station saveStation(Station station) {
//        return null;
        if(station.getId()==null){
            identification++;
            Station newStation = new Station(Integer.toString(identification), station.getStationName(),
                    station.getStationCode(), station.getDistance());
            stationListing.put(newStation.getId(), newStation);
            return newStation;
        }

        stationListing.put(station.getId() , station);
        return station;
    }

    @Override
    public Station findStationByCode(String stationCode) {
//        return null;
        return stationListing.values().stream().filter(station -> station.getStationCode().equals(stationCode)).findFirst().get();
    }

    @Override
    public HashMap<String, Station> getStationMap() {
//        return null;
        return stationListing;
    }
}
