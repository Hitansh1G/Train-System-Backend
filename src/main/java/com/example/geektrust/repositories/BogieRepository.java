package com.example.geektrust.repositories;

import com.example.geektrust.entities.Bogie;

import java.util.HashMap;
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
}
