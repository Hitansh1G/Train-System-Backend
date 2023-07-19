package com.geektrust.example.geektrust.repositories;

import java.util.HashMap;
import com.geektrust.example.geektrust.entities.Bogie;

public class BoggyRepository implements IBoggyRepository {
    private HashMap<String, Bogie> boggyMapping;
    private Integer autoIncrement = 0;

    public BoggyRepository() {
        this.boggyMapping = new HashMap<String, Bogie>();
    }

    public BoggyRepository(HashMap<String, Bogie> boggyMapping){
        this.boggyMapping = boggyMapping;
    }

    @Override
    public Bogie saveBoggy(Bogie bogie) {
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
    public HashMap<String, Bogie> getBoggyMapping() {
        return boggyMapping;
    }
    
}
