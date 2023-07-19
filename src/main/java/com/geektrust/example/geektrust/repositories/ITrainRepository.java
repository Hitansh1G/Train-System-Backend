package com.geektrust.example.geektrust.repositories;

import java.util.HashMap;
import com.geektrust.example.geektrust.entities.Train;

public interface ITrainRepository extends CRUDRepository<Train,String>{
//    Train saveTrain(Train train);

    Train findTrainByName(String trainName);

    void deleteTrain(String trainName);   

    HashMap<String,Train> getTrainListing();
}
