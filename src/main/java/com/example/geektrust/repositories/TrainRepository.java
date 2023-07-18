package com.example.geektrust.repositories;

import com.example.geektrust.entities.Train;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class TrainRepository implements ITrainRepository{

    private HashMap<String, Train> trainListing;
    private Integer identification=0;

    public TrainRepository(){
        this.trainListing = new HashMap<String, Train>();
    }
    public TrainRepository(HashMap<String, Train>trainListing){
        this.trainListing = trainListing;
    }
    @Override
    public Train save(Train entity) {
        return null;
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
    public void delete(Train entity) {

    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public Train saveTrain(Train train) {
//        return null;
        if(train.getId() == null){
            identification++;
            Train newTrain = new Train(Integer.toString(identification), train.getTrainName(), train.getBogiesList());
            trainListing.put(newTrain.getId(), newTrain);
            return newTrain;
        }

        trainListing.put(train.getId() , train);
        return train;
    }

    @Override
    public Train findTrainByName(String trainName) {
//        return null;
        return trainListing.values().stream().filter(train -> train.getTrainName().equals(trainName)).findFirst().get();
    }

    @Override
    public void deleteTrain(String trainName) {
        Train train = trainListing.values().stream().filter(v -> v.getTrainName().equals(trainName)).findFirst().get();
        trainListing.remove(train.getId());
    }

    @Override
    public HashMap<String, Train> getTrainMapping() {
        return trainListing;
    }
}
