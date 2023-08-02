package com.geektrust.example.geektrust.entities;

import static com.geektrust.example.geektrust.Constants.Constants.PRIME;
import static com.geektrust.example.geektrust.Constants.Constants.TEMP;

public class Station extends BaseEntitiy {
    private final String stationName;
    private final String stationCode;
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

    public int getDistance() {
        return distance;
    }

    @Override
    public int hashCode() {
        int result = TEMP;
        result = PRIME * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
}
