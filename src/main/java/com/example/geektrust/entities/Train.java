package com.example.geektrust.entities;

import java.util.LinkedList;

public class Train extends BaseEntity{
    private String trainName;
    private LinkedList<Bogie> bogiesList = new LinkedList<Bogie>();

    public Train(String id, String trainName, LinkedList<Bogie> bogiesList) {
//        this(trainName, boggies);
        this.id = id;
        this.trainName = trainName;
        this.bogiesList = bogiesList;
    }

    public Train(String trainName, LinkedList<Bogie> bogiesList) {
        this.trainName = trainName;
        this.bogiesList = bogiesList;
    }

    public LinkedList<Bogie> getBogiesList() {
        return bogiesList;
    }

    public String getTrainName() {
        return trainName;
    }

    public void addBogie(Bogie bogie){
        bogiesList.add(bogie);
    }

    public void removeBogie(Bogie bogie){
        bogiesList.remove(bogie);
    }

    @Override
    public String getId() {
        return super.getId();
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

}
