package com.geektrust.example.geektrust.dtos;

import com.geektrust.example.geektrust.entities.Bogie;
import com.geektrust.example.geektrust.entities.Route;
import com.geektrust.example.geektrust.entities.Station;
import com.geektrust.example.geektrust.repositories.IRouteRepository;

import java.util.Comparator;
import java.util.List;

import static com.geektrust.example.geektrust.Constants.Constants.HyderabadDistance;

public class ComparatorDTO implements Comparator<Bogie> {
    private final IRouteRepository iRouteRepository;

    public ComparatorDTO(IRouteRepository iRouteRepository) {
        this.iRouteRepository = iRouteRepository;
    }

    @Override
    public int compare(Bogie bogie1, Bogie bogie2) {
        Station bogie1Station = bogie1.getdestinationStation();
        Station bogie2Station = bogie2.getdestinationStation();

        if (bogie1Station == null && bogie2Station == null) {
            return 0;
        } else if (bogie1Station == null) {
            return -1;
        } else if (bogie2Station == null) {
            return 1;
        }

        List<Route> routes = iRouteRepository.findAll();
        int hyderabadDistanceOfBogie1 = getHyderabadDistance(routes, bogie1Station);
        int hyderabadDistanceOfBogie2 = getHyderabadDistance(routes, bogie2Station);

        return (bogie1Station.getDistance() - hyderabadDistanceOfBogie1) - (bogie2Station.getDistance() - hyderabadDistanceOfBogie2);
//        return 0;
    }
    private int getHyderabadDistance(List<Route> routes, Station station) {
        int hyderabadDistance = HyderabadDistance;
        for (Route route : routes) {
            if (route.getStations().contains(station)) {
                hyderabadDistance = route.getHyderabadDistance();
                break;
            }
        }
        return hyderabadDistance;
    }
}
