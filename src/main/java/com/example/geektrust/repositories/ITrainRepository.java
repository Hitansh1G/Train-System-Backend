package com.example.geektrust.repositories;

import com.example.geektrust.entities.Train;

import java.util.HashMap;

public interface ITrainRepository extends  CRUDRepository<Train, String >{
    Train saveTrain(Train train);

    Train findTrainByName(String trainName);

    void deleteTrain(String trainName);

    HashMap<String,Train> getTrainMapping();
}
