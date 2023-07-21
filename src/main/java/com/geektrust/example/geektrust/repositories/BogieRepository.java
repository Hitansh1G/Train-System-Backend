package com.geektrust.example.geektrust.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import com.geektrust.example.geektrust.entities.Bogie;

public class BogieRepository implements IBogieRepository {
    private final HashMap<String, Bogie> bogieListing;

    public BogieRepository() {
        this.bogieListing = new HashMap<>();
    }

//    public BogieRepository(HashMap<String, Bogie> bogieListing){
//        this.bogieListing = bogieListing;
//    }

    private Integer identification = 0;
    @Override
    public Bogie save(Bogie bogie) {
        if(bogie.getId() == null){
            identification++;
            Bogie newBogie = new Bogie(Integer.toString(identification), bogie.getdestinationStation());
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
    public long count() {
        return bogieListing.size();
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


}
