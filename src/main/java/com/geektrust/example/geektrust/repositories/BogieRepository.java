package com.geektrust.example.geektrust.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import com.geektrust.example.geektrust.entities.Bogie;

public class BogieRepository implements IBogieRepository {
    private HashMap<String, Bogie> bogieListing;
    private Integer autoIncrement = 0;

    public BogieRepository() {
        this.bogieListing = new HashMap<String, Bogie>();
    }

    public BogieRepository(HashMap<String, Bogie> bogieListing){
        this.bogieListing = bogieListing;
    }


    @Override
    public Bogie save(Bogie bogie) {
        if(bogie.getId() == null){
            autoIncrement++;
            Bogie newBogie = new Bogie(Integer.toString(autoIncrement), bogie.getdestinationStation());
            bogieListing.put(newBogie.getId(), newBogie);
            return newBogie;
        }
        bogieListing.put(bogie.getId(), bogie);
        return bogie;
    }


    @Override
    public HashMap<String, Bogie> getBogieListing() {
        return bogieListing;
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
        return bogieListing.size();
    }
}
