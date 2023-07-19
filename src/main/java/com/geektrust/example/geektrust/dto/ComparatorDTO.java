package com.geektrust.example.geektrust.dto;

import java.util.Comparator;
import java.util.List;
import com.geektrust.example.geektrust.entities.Bogie;
import com.geektrust.example.geektrust.entities.Route;
import com.geektrust.example.geektrust.entities.Station;
import com.geektrust.example.geektrust.repositories.IRouteRepository;

public class ComparatorDTO implements Comparator<Bogie>{
    IRouteRepository iRouteRepository;
    public ComparatorDTO(IRouteRepository iRouteRepository){
        this.iRouteRepository = iRouteRepository;
    }

    @Override
    public int compare(Bogie o1, Bogie o2) {
        if(o1.getdestinationStation() == null){
            return -1;
        }
        if(o2.getdestinationStation() == null){
            return 1;
        }
        List<Route> routes = iRouteRepository.getAllRoutes();
        // Find the dest station
        Station o1Station = o1.getdestinationStation();
        // Find in which route it belongs and get the distance of hyderabad in that
        // route
        int hyderabadDistanceOfo1 = 0;
        for (Route route : routes) {
            if (route.getStations().contains(o1Station)) {
                hyderabadDistanceOfo1 = route.getHyderabadDistance();
            }
        }

        // similarly calculate hyderabad distance of o2
        Station o2Station = o2.getdestinationStation();
        int hyderabadDistanceOfo2 = 0;
        for (Route route : routes) {
            if (route.getStations().contains(o2Station)) {
                hyderabadDistanceOfo2 = route.getHyderabadDistance();
            }
        }

        int o1DistanceToTravel = o1Station.getDistance() - hyderabadDistanceOfo1;
        int o2DistanceToTravel = o2Station.getDistance() - hyderabadDistanceOfo2;

        return o2DistanceToTravel - o1DistanceToTravel;
    }

}