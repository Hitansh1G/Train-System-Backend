package com.geektrust.example.geektrust.entities;

import java.util.LinkedList;

import static com.geektrust.example.geektrust.Constants.Constants.PRIME;
import static com.geektrust.example.geektrust.Constants.Constants.TEMP;

public class Train extends BaseEntitiy {
    private final LinkedList<Bogie> bogies;
    private final String trainName;

    public Train(String id, String trainName, LinkedList<Bogie> bogies) {
        this(trainName, bogies);
        this.id = id;
    }

    public Train(String trainName, LinkedList<Bogie> bogies) {
        this.trainName = trainName;
        this.bogies = bogies;
    }

    public LinkedList<Bogie> getBogies() {
        return bogies;
    }

    public String getTrainName() {
        return trainName;
    }

    public void deleteBogie(Bogie bogie) {
        bogies.remove(bogie);
    }

    public void addBogie(Bogie bogie) {
        bogies.add(bogie);
    }

    @Override
    public int hashCode() {
        int result = TEMP;
        result = PRIME * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

}
