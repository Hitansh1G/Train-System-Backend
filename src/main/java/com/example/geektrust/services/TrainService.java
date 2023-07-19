package com.example.geektrust.services;

import com.example.geektrust.entities.Bogie;
import com.example.geektrust.entities.Train;
import com.example.geektrust.exceptions.JourneyEndedException;
import com.example.geektrust.repositories.IBogieRepository;
import com.example.geektrust.repositories.IRouteRepository;
import com.example.geektrust.repositories.IStationRepository;
import com.example.geektrust.repositories.ITrainRepository;

import java.util.LinkedList;
import java.util.List;

public class TrainService implements ITrainService{

    private final IBogieRepository iBogieRepository;
    private final IRouteRepository iRouteRepository;
    private final IStationRepository iStationRepository;
    private final ITrainRepository iTrainRepository;

    public TrainService(IBogieRepository iBogieRepository,
                        IRouteRepository iRouteRepository,
                        IStationRepository iStationRepository,
                        ITrainRepository iTrainRepository) {
        this.iBogieRepository = iBogieRepository;
        this.iRouteRepository = iRouteRepository;
        this.iStationRepository = iStationRepository;
        this.iTrainRepository = iTrainRepository;
    }

    @Override
    public Train mergeTrain(String trainA, String trainB) {
        Train train1 = iTrainRepository.findTrainByName(trainA);
        Train train2 = iTrainRepository.findTrainByName(trainB);
        LinkedList<Bogie> trainABogie = train1.getBogiesList();
        LinkedList<Bogie> trainBBogie = train2.getBogiesList();

        if(trainABogie.isEmpty()==true && trainBBogie.isEmpty()==true){
            throw new JourneyEndedException("JOURNEY_ENDED");
        }
        trainBBogie.addAll(trainABogie);
    }

    @Override
    public Train travel(String trainName, String routeName, String destinationStation) {
        return null;
    }

    @Override
    public Train createTrain(String trainName, List<String> bogies) {
        return null;
    }
}
