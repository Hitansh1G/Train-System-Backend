package com.geektrust.example.geektrust.entities;

import java.util.LinkedList;

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

    public void addBoggy(Bogie bogie) {
        bogies.add(bogie);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Train other = (Train) obj;
        if (bogies == null && other.bogies != null) {
            return false;
        }
        assert bogies != null;
        if (!bogies.equals(other.bogies))
            return false;
        
        if (trainName == null && other.trainName != null) {
            return false;
        }
        assert trainName != null;
        if(!trainName.equals(other.trainName))
            return false;
            
        return true;
    }    
}
