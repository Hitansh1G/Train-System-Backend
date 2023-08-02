package com.geektrust.example.geektrust.repositories;

import com.geektrust.example.geektrust.entities.Bogie;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.geektrust.example.geektrust.Constants.Constants.ZERO;

public class BogieRepository implements IBogieRepository {
    private final Map<String, Bogie> bogieListing;
    private Integer identification = ZERO;

    public BogieRepository() {
        this.bogieListing = new HashMap<>();
    }

    @Override
    public Bogie save(Bogie bogie) {
        if (bogie.getId() == null) {
            identification++;
            Bogie newBogie = new Bogie(Integer.toString(identification), bogie.getdestinationStation());
            bogieListing.put(newBogie.getId(), newBogie);
            return newBogie;
        }
        bogieListing.put(bogie.getId(), bogie);
        return bogie;
    }

    @Override
    public Map<String, Bogie> getBogieListing() {
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
