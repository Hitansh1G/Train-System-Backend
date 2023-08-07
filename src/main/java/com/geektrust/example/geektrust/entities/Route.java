package com.geektrust.example.geektrust.entities;

import java.util.LinkedList;

import static com.geektrust.example.geektrust.Constants.Constants.PRIME;
import static com.geektrust.example.geektrust.Constants.Constants.TEMP;

public class Route extends BaseEntitiy {
    private String routeName;
    private LinkedList<Station> stations = new LinkedList<Station>();
    private final int hyderabadDistance;

    public Route(String id, String routeName, LinkedList<Station> stations, int hyderabadDistance) {
        this.id = id;
        this.routeName = routeName;
        this.stations = stations;
        this.hyderabadDistance = hyderabadDistance;
    }

    public Route(String routeName, LinkedList<Station> stations, int hyderabadDistance) {
        this.routeName = routeName;
        this.stations = stations;
        this.hyderabadDistance = hyderabadDistance;
    }

    public String getRouteName() {
        return routeName;
    }

    public LinkedList<Station> getStations() {
        return stations;
    }

    public int getHyderabadDistance() {
        return hyderabadDistance;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public void setStations(LinkedList<Station> stations) {
        this.stations = stations;
    }

    public boolean isStationPresent(Station stn) {
        for(Station station:stations){
            if(station.equals(stn)) return true;
        }
        return false;
    }
    @Override
    public int hashCode() {
        int result = TEMP;
        result = PRIME * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
}
