package com.example.geektrust.services;

import com.example.geektrust.entities.Bogie;
import com.example.geektrust.entities.Route;
import com.example.geektrust.entities.Station;
import com.example.geektrust.repositories.IBogieRepository;
import com.example.geektrust.repositories.IRouteRepository;
import com.example.geektrust.repositories.IStationRepository;

import java.util.LinkedList;
import java.util.List;

public class BogieService implements IBogieService{

    IRouteRepository iRouteRepository;
    public BogieService(IRouteRepository iRouteRepository){
        this.iRouteRepository = iRouteRepository;
    }
    @Override
    public Bogie createBogie(IBogieRepository iBogieRepository, IStationRepository iStationRepository, String bogieName) {
        Bogie bogie;
        if(bogieName.equals("ENGINE")){
            bogie = new Bogie(null);
            bogie = iBogieRepository.saveBogie(bogie);
        }
        else{
            Station station = iStationRepository.findStationByCode(bogieName);
            bogie = new Bogie(station);
            bogie = iBogieRepository.saveBogie(bogie);
        }
        return bogie;
    }

    @Override
    public LinkedList<Bogie> createListOfBogies(IBogieRepository iBogieRepository, IStationRepository iStationRepository, List<String> bogies) {
        LinkedList<Bogie> bogiesList = new LinkedList<Bogie>();
        for(String indivisualBogie : bogies){
            Bogie temp = createBogie(iBogieRepository,iStationRepository,indivisualBogie);
            bogiesList.add(temp);
        }
        return bogiesList;
    }

    @Override
    public void detachedBogie(Station station, LinkedList<Bogie> bogies, List<Bogie> bogiesToBeRemoved) {
        for(Bogie bogie: bogies){
            if(bogie.getDestinationStation()!=null && bogie.getDestinationStation().equals(station)){
                bogiesToBeRemoved.add(bogie);
            }
        }
    }

    @Override
    public List<Bogie> generateListOfBogiesToBeRemoved(LinkedList<Station> stations, LinkedList<Bogie> bogies, String dest) {
        List<Bogie>listOfBogiesTobeRemoved = new LinkedList<Bogie>();
        for(Station station : stations){
            if(station.getStationCode().equals(dest)){
                break;
            }
            detachedBogie(station,bogies, listOfBogiesTobeRemoved);
        }
        return listOfBogiesTobeRemoved;
    }

    @Override
    public int compareBogie(Bogie bogie1, Bogie bogie2) {
        if(bogie1.getDestinationStation()==null){
            return -1;
        }
        if(bogie1.getDestinationStation()==null){
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
//
//    @Override
//    public List<Bogie> generateListOfBogiesToBeRemoved(LinkedList<Station> stations, LinkedList<Bogie> bogies, String dest) {
//        return null;
//    }

}
