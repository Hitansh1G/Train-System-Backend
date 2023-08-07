package com.geektrust.example.geektrust.entities;

import static com.geektrust.example.geektrust.Constants.Constants.PRIME;
import static com.geektrust.example.geektrust.Constants.Constants.TEMP;

public class Station extends BaseEntitiy {
    private String stationName;
    private String stationCode;
    private final int distance;

    public Station(String id, String stationName, String stationCode, int distance) {
        this.id = id;
        this.stationName = stationName;
        this.stationCode = stationCode;
        this.distance = distance;
    }

    public Station(String stationName, String stationCode, int distance) {
        this.stationName = stationName;
        this.stationCode = stationCode;
        this.distance = distance;
    }

    public String getStationName() {
        return stationName;
    }

    public String getStationCode() {
        return stationCode;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }

    public int getDistance() {
        return distance;
    }

//    public void addStation(Station station) {
//        station.add(station);
//    }

    @Override
    public int hashCode() {
        int result = TEMP;
        result = PRIME * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
}
