package com.example.geektrust.services;

import com.example.geektrust.dto.BogieDTO;
import com.example.geektrust.entities.Bogie;
import com.example.geektrust.entities.Route;
import com.example.geektrust.entities.Train;
import com.example.geektrust.exceptions.JourneyEndedException;
import com.example.geektrust.repositories.*;

import com.example.geektrust.dto.BogieDTO;
import com.example.geektrust.services.BogieService;

import java.util.*;

import static java.util.Collection.*;

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

        trainBBogie.sort(new BogieDTO(iRouteRepository));

        //delete HYD from the list
        trainBBogie.removeIf(bogie -> bogie.getDestinationStation() != null && "HYB".equals(bogie.getDestinationStation().getStationCode()));

        Train AB = new Train("Train_AB", trainBBogie);

        iTrainRepository.deleteTrain((trainA));
        iTrainRepository.deleteTrain((trainB));

        iTrainRepository.saveTrain(AB);

        return AB;
    }

    @Override
    public Train travel(String trainName, String routeName, String destinationStation) {
        Train train = iTrainRepository.findTrainByName(trainName);
        Route route = iRouteRepository.findRouteByName(routeName);

        List<Bogie>bogiesToRemove = iBogieRepository.generateListOfBogiesToBeRemoved(route.getStationsStops(),
                                                                                    train.getBogiesList(),
                                                                                    destinationStation);
        for(Bogie bogie : bogiesToRemove){
            train.removeBogie(bogie);
        }

        iTrainRepository.saveTrain(train);

        return train;
    }






    @Override
    public Train createTrain(String trainName, List<String> bogies) {
        LinkedList<Bogie> bogies1 = iBogieRepository.BogieListing(iBogieRepository, iStationRepository, bogies);
    }
}
