package com.geektrust.example.geektrust.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import com.geektrust.example.geektrust.entities.Bogie;

public class BogieRepository implements IBogieRepository {
    private HashMap<String, Bogie> boggyMapping;
    private Integer autoIncrement = 0;

    public BogieRepository() {
        this.boggyMapping = new HashMap<String, Bogie>();
    }

    public BogieRepository(HashMap<String, Bogie> boggyMapping){
        this.boggyMapping = boggyMapping;
    }

//    @Override
//    public Bogie saveBoggy(Bogie bogie) {
//        if(bogie.getId() == null){
//            autoIncrement++;
//            Bogie newBogie = new Bogie(Integer.toString(autoIncrement), bogie.getdestinationStation());
//            boggyMapping.put(newBogie.getId(), newBogie);
//            return newBogie;
//        }
//        boggyMapping.put(bogie.getId(), bogie);
//        return bogie;
//    }

    @Override
    public HashMap<String, Bogie> getBoggyMapping() {
        return boggyMapping;
    }

    @Override
    public Bogie save(Bogie bogie) {
        if(bogie.getId() == null){
            autoIncrement++;
            Bogie newBogie = new Bogie(Integer.toString(autoIncrement), bogie.getdestinationStation());
            boggyMapping.put(newBogie.getId(), newBogie);
            return newBogie;
        }
        boggyMapping.put(bogie.getId(), bogie);
        return bogie;
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
}
