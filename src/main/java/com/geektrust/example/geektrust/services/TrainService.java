package com.geektrust.example.geektrust.services;

import java.util.LinkedList;
import java.util.List;

import com.geektrust.example.geektrust.dtos.BogiesDTO;
import com.geektrust.example.geektrust.dtos.ComparatorDTO;
import com.geektrust.example.geektrust.dtos.GeneratedListDTO;
import com.geektrust.example.geektrust.entities.Bogie;
import com.geektrust.example.geektrust.entities.Route;
import com.geektrust.example.geektrust.entities.Train;
import com.geektrust.example.geektrust.exceptions.JourneyEndedException;
import com.geektrust.example.geektrust.repositories.IBogieRepository;
import com.geektrust.example.geektrust.repositories.IRouteRepository;
import com.geektrust.example.geektrust.repositories.IStationRepository;
import com.geektrust.example.geektrust.repositories.ITrainRepository;

import static com.geektrust.example.geektrust.Constants.Constants.MERGED_TRAIN;
import static com.geektrust.example.geektrust.Constants.Constants.JOURNEY_ENDED;

public class TrainService implements ITrainService {
    private final IRouteRepository iRouteRepository;
    private final ITrainRepository iTrainRepository;
    private final IBogieRepository iBogieRepository;
    private final IStationRepository iStationRepository;
    private IBogieService iBogieService ;

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

        if (trainA.getBogies().isEmpty() && trainB.getBogies().isEmpty()) {
            throw new JourneyEndedException(JOURNEY_ENDED);
        }

        LinkedList<Bogie> mergedBogies = iBogieService.mergeBogies(trainA, trainB);

        // Sort the bogies based on route information
        mergedBogies.sort(new ComparatorDTO(iRouteRepository));

        // Remove Hyderabad from the list of bogies in the merged train
        iBogieService.removeHyderabadBogies(mergedBogies);

        // Create a new Train object with merged bogies
        Train mergedTrain = new Train(MERGED_TRAIN, mergedBogies);

        // Delete the original trainA and trainB from the repository
        deleteTrain(trainAName);
        deleteTrain(trainBName);

        // Save the mergedTrain to the repository
        iTrainRepository.save(mergedTrain);

        return mergedTrain;
    }

    private void deleteTrain(String trainName) {
        iTrainRepository.deleteTrain(trainName);
    }

    @Override
    public Train travel(String trainName, String routeName, String destination) {
        Train trainEntity = iTrainRepository.findTrainByName(trainName);
        Route routeEntity = iRouteRepository.findByName(routeName);
        List<Bogie> bogsToRemove = GeneratedListDTO.generateBogiesToRemoved(routeEntity.getStations(), trainEntity.getBogies(), destination);
        for (Bogie bogie : bogsToRemove) {
            trainEntity.deleteBogie(bogie);
        }
        iTrainRepository.save(trainEntity);
        return trainEntity;
    }

    @Override
    public void createTrain(String trainName, List<String> bogies) {
        LinkedList<Bogie> newBogies = BogiesDTO.createListOfBogies(iBogieRepository, iStationRepository, bogies);
        Train newTrain = new Train(trainName, newBogies);
        iTrainRepository.save(newTrain);
    }
}
