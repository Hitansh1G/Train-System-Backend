package com.geektrust.example.geektrust.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.geektrust.example.geektrust.entities.Train;

public class TrainRepository implements ITrainRepository {
    private final HashMap<String, Train> trainListing;
    private Integer Increment = 0;

    public TrainRepository() {
        this.trainListing = new HashMap<String, Train>();
    }

    public TrainRepository(HashMap<String,Train> trainListing){
        this.trainListing = trainListing;
    }

    @Override
    public HashMap<String, Train> getTrainListing() {
        return trainListing;
    }

//    @Override
//    public Train saveTrain(Train train) {
//        if(train.getId() == null){
//            Increment++;
//        Train newTrain = new Train(Integer.toString(Increment), train.getTrainName(), train.getBogies());
//        trainListing.put(newTrain.getId(), newTrain);
//        return newTrain;
//        }
//        trainListing.put(train.getId(), train);
//        return train;
//    }

    @Override
    public Train findTrainByName(String trainName) {
        return trainListing.values().stream().filter(train -> train.getTrainName().equals(trainName)).findFirst().get();
    }




    @Override
    public Train save(Train train) {
        if(train.getId() == null){
            Increment++;
            Train newTrain = new Train(Integer.toString(Increment), train.getTrainName(), train.getBogies());
            trainListing.put(newTrain.getId(), newTrain);
            return newTrain;
        }
        trainListing.put(train.getId(), train);
        return train;
    }

    @Override
    public List<Train> findAll() {
        return null;
    }

    @Override
    public Optional<Train> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }


    @Override
    public void deleteTrain(String trainName) {
        // Find the train
        Train train = trainListing.values().stream().filter(v -> v.getTrainName().equals(trainName)).findFirst().get();
        trainListing.remove(train.getId());

    }

    @Override
    public void delete(Train trainName) {
        Train train = trainListing.values().stream().filter(v -> v.getTrainName().equals(trainName)).findFirst().get();
        trainListing.remove(train.getId());
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public long count() {
        return 0;
    }
}
