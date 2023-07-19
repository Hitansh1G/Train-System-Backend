package com.example.geektrust.repositories;

import com.example.geektrust.entities.Bogie;
import com.example.geektrust.entities.Station;
import com.example.geektrust.entities.Train;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class BogieRepository implements IBogieRepository {

    public HashMap<String, Bogie> bogieListing;

    public BogieRepository(HashMap<String,Bogie>bogieListing){
        this.bogieListing=bogieListing;
    }

    public BogieRepository(){
        this.bogieListing = new HashMap<String, Bogie>();
    }


    @Override
    public Bogie save(Bogie entity) {
        return null;
    }

    @Override
    public List<Bogie> findAll() {
        return null;
    }

    @Override
    public Optional<Bogie> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public void delete(Bogie entity) {

    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public long count() {
        return 0;
    }

    private Integer identification=0;
    @Override
    public Bogie saveBogie(Bogie bogie) {
//        return null;
        if(bogie.getId()==null){
            identification++;
            Bogie tempBogie = new Bogie(Integer.toString(identification), bogie.getDestinationStation());
            bogieListing.put(bogie.getId(),tempBogie);
            return tempBogie;
        }
        bogieListing.put(bogie.getId(), bogie);
        return bogie;
    }

    @Override
    public HashMap<String, Bogie> BogieListing() {
        return bogieListing;
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
    public void detachedBogie(Station station, LinkedList<Bogie> bogies, List<Bogie> bogiesToBeRemoved) {
        for(Bogie bogie: bogies){
            if(bogie.getDestinationStation()!=null && bogie.getDestinationStation().equals(station)){
                bogiesToBeRemoved.add(bogie);
            }
        }
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

}
