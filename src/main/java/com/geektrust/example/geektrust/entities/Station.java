package com.geektrust.example.geektrust.entities;

public class Station extends BaseEntitiy {
    private String stationName;
    private String stationCode;
    private int distance;

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
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
}
