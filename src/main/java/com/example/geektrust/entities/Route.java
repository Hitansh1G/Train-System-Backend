package com.example.geektrust.entities;

import java.util.LinkedList;

public class Route extends BaseEntity{
    private final Integer distanceTillHYD;
    private LinkedList<Station>stationsStops = new LinkedList<Station>();
    private final String route;


    public Route(String id, String route, LinkedList<Station> stationsStops, int distanceTillHYD) {
        this.id = id;
        this.route = route;
        this.stationsStops = stationsStops;
        this.distanceTillHYD = distanceTillHYD;
    }

    public Route(String routeName, LinkedList<Station> stationsStops, int distanceTillHYD) {
        this.route = routeName;
        this.stationsStops = stationsStops;
        this.distanceTillHYD = distanceTillHYD;
    }

    public String getRouteName() {
        return route;
    }

    public LinkedList<Station> getStationsStops() {
        return stationsStops;
    }

    public int getHyderabadDistance() {
        return distanceTillHYD;
    }

    public boolean isPresent(Station station){
        for(Station stn : stationsStops){
            if(stn.equals(station))return true;
        }
        return false;
    }
}
