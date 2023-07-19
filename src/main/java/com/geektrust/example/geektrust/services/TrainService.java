package com.geektrust.example.geektrust.services;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import com.geektrust.example.geektrust.entities.Bogie;
import com.geektrust.example.geektrust.entities.Route;
import com.geektrust.example.geektrust.entities.Train;
import com.geektrust.example.geektrust.exceptions.JourneyEndedException;
import com.geektrust.example.geektrust.dto.BoggiesDTO;
import com.geektrust.example.geektrust.dto.GeneratedListDTO;
import com.geektrust.example.geektrust.dto.ComparatorDTO;
import com.geektrust.example.geektrust.repositories.IBogieRepository;
import com.geektrust.example.geektrust.repositories.IRouteRepository;
import com.geektrust.example.geektrust.repositories.IStationRepository;
import com.geektrust.example.geektrust.repositories.ITrainRepository;

public class TrainService implements ITrainService {
    private final IRouteRepository iRouteRepository;
    private final ITrainRepository iTrainRepository;
    private final IBogieRepository iBogieRepository;
    private final IStationRepository iStationRepository;

    public TrainService(IRouteRepository iRouteRepository, ITrainRepository iTrainRepository,
                        IBogieRepository iBogieRepository, IStationRepository iStationRepository) {
        this.iRouteRepository = iRouteRepository;
        this.iTrainRepository = iTrainRepository;
        this.iBogieRepository = iBogieRepository;
        this.iStationRepository = iStationRepository;
    }

    @Override
    public Train mergeTrain(String trainAName, String trainBName) {
        Train trainA = iTrainRepository.findTrainByName(trainAName);
        Train trainB = iTrainRepository.findTrainByName(trainBName);

        //Find the list of boggies
        LinkedList<Bogie> trainA_Bogies = trainA.getBogies();
        LinkedList<Bogie> trainB_Bogies = trainB.getBogies();
        if (trainA_Bogies.isEmpty() && trainB_Bogies.isEmpty()) {
            throw new JourneyEndedException("JOURNEY_ENDED");
        }
        trainA_Bogies.addAll(trainB_Bogies);


        trainA_Bogies.sort(new ComparatorDTO(iRouteRepository));

        //Remove Hyderabad from the list of boggies in merged train
        while(trainA_Bogies.getLast().getdestinationStation()!=null && trainA_Bogies.getLast().getdestinationStation().getStationCode().equals("HYB")){
            trainA_Bogies.removeLast();
        }
        Train AB = new Train("TRAIN_AB", trainA_Bogies);
        iTrainRepository.deleteTrain(trainAName);
        iTrainRepository.deleteTrain(trainBName);
        iTrainRepository.save(AB);
        return AB;
    }

    @Override
    public Train travel(String trainName, String routeName, String dest) {
        // Find the train
        Train train = iTrainRepository.findTrainByName(trainName);
        // Find the route
        Route route = iRouteRepository.findByName(routeName);

        // travel upto dest
        List<Bogie> boggiesToBeRemoved = GeneratedListDTO.generateListOfBoggiesToBeRemoved(route.getStations(), train.getBogies(), dest);


        for(Bogie bogie :  boggiesToBeRemoved){
            train.deleteBoggy(bogie);
        }
        iTrainRepository.save(train);
        return train;
    }

    @Override
    public Train createTrain(String trainName, List<String> boggies) {
        LinkedList<Bogie> newBoggies = BoggiesDTO.createListOfBoggies(iBogieRepository, iStationRepository, boggies);
        Train newTrain = new Train(trainName, newBoggies);
        Train savedTrain = iTrainRepository.save(newTrain);
        return savedTrain;
    }
    
}
