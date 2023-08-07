package com.geektrust.example.geektrust.Repository;

//package com.geektrust.example.geektrust.repositories;

import com.geektrust.example.geektrust.entities.Bogie;
import com.geektrust.example.geektrust.entities.Train;
import com.geektrust.example.geektrust.repositories.TrainRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TrainRepositoryTest {

    private TrainRepository trainRepository;

    @Mock
    private Train trainMock;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        trainRepository = new TrainRepository();
    }

    @Test
    public void testGetTrainListing() {
        HashMap<String, Train> trainListing = trainRepository.getTrainListing();
        assertNotNull(trainListing);
        assertTrue(trainListing.isEmpty());
    }

    @Test
    public void testFindTrainByName() {
        String trainName = "Train1";
        LinkedList<Bogie> bogies = new LinkedList<>();
        bogies.add(new Bogie("Bogie1", null));
        Train train = new Train("1", trainName, bogies);

        trainRepository.save(train);

        Train foundTrain = trainRepository.findTrainByName(trainName);
        assertNotNull(foundTrain);
        assertEquals(trainName, foundTrain.getTrainName());
    }

    @Test
    public void testSave() {
        String trainName = "Train1";
        LinkedList<Bogie> bogies = new LinkedList<>();
        bogies.add(new Bogie("Bogie1", null));
        Train train = new Train(trainName, bogies);

        Train savedTrain = trainRepository.save(train);

        assertNotNull(savedTrain);
        assertNotNull(savedTrain.getId());
        assertEquals(trainName, savedTrain.getTrainName());
        assertEquals(bogies, savedTrain.getBogies());
    }

//    @Test
//    public void testUpdate() {
//        String trainName = "Train1";
//        LinkedList<Bogie> bogies = new LinkedList<>();
//        bogies.add(new Bogie("Bogie1", null));
//        Train train = new Train(trainName, bogies);
//
//        Train savedTrain = trainRepository.save(train);
//
//        String newTrainName = "Train1Updated";
//        savedTrain.setTrainName(newTrainName);
//        trainRepository.save(savedTrain);
//
//        Train updatedTrain = trainRepository.findTrainByName(newTrainName);
//        assertNotNull(updatedTrain);
//        assertEquals(newTrainName, updatedTrain.getTrainName());
//    }

    @Test
    public void testDeleteTrain() {
        String trainName = "Train1";
        LinkedList<Bogie> bogies = new LinkedList<>();
        bogies.add(new Bogie("Bogie1", null));
        Train train = new Train(trainName, bogies);

        trainRepository.save(train);

        trainRepository.deleteTrain(trainName);

        Train deletedTrain = trainRepository.findTrainByName(trainName);
        assertNull(deletedTrain);
    }


}
