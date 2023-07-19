package com.example.geektrust.dto;

import com.example.geektrust.entities.Bogie;
import com.example.geektrust.entities.Route;
import com.example.geektrust.entities.Station;
import com.example.geektrust.repositories.IRouteRepository;

import java.util.Comparator;
import java.util.List;

public class BogieDTO implements Comparator<Bogie> {
    IRouteRepository iRouteRepository;
    public BogieDTO(IRouteRepository iRouteRepository){
        this.iRouteRepository = iRouteRepository;
    }

    @Override
    public int compare(Bogie bogie1, Bogie bogie2) {
        if(bogie1.getDestinationStation()==null || bogie2.getDestinationStation()==null){
            return -1;
        }
        List<Route> routeList = IRouteRepository.getAllRoutes();

        Station bogie1Station = bogie1.getDestinationStation();
        int HYDdistanceFrom1 =0 ;
        for (Route route : routeList) {
            if (route.getStationsStops().contains(bogie1Station)) {
                HYDdistanceFrom1 = route.getHyderabadDistance();
            }
        }

        Station bogie2Station = bogie2.getDestinationStation();
        int HYDdistanceFrom2 =0 ;
        for (Route route : routeList) {
            if (route.getStationsStops().contains(bogie2Station)) {
                HYDdistanceFrom2 = route.getHyderabadDistance();
            }
        }

        return (bogie1Station.getDistanceFromSource() - HYDdistanceFrom1) -
                (bogie2Station.getDistanceFromSource() - HYDdistanceFrom2);
    }
}
