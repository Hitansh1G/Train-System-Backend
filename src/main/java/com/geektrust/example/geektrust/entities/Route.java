package com.geektrust.example.geektrust.entities;

import java.util.LinkedList;

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

    public boolean isStationPresent(Station stn) {
        for(Station station:stations){
            if(station.equals(stn)){
                return true;
            }
        }
        return false;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
}
