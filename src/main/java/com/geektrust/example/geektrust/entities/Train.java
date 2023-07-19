package com.geektrust.example.geektrust.entities;

import java.util.LinkedList;

public class Train extends BaseEntitiy {
    private LinkedList<Bogie> boggies;
    private String trainName;

    public Train(String id, String trainName, LinkedList<Bogie> boggies) {
        this(trainName, boggies);
        this.id = id;
    }

    public Train(String trainName, LinkedList<Bogie> boggies) {
        this.trainName = trainName;
        this.boggies = boggies;
    }

    public LinkedList<Bogie> getBoggies() {
        return boggies;
    }

    public String getTrainName() {
        return trainName;
    }

    public void deleteBoggy(Bogie bogie) {
        boggies.remove(bogie);
    }

    public void addBoggy(Bogie bogie) {
        boggies.add(bogie);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((boggies == null) ? 0 : boggies.hashCode());
        result = prime * result + ((trainName == null) ? 0 : trainName.hashCode());
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
        if (boggies == null && other.boggies != null) {
            return false;
        } 
        if (!boggies.equals(other.boggies))
            return false;
        
        if (trainName == null && other.trainName != null) {
            return false;
        } 
        if(!trainName.equals(other.trainName))
            return false;
            
        return true;
    }    
}
