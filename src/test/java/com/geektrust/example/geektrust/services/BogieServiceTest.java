package com.geektrust.example.geektrust.services;

//package com.geektrust.example.geektrust.services;

import com.geektrust.example.geektrust.entities.Bogie;
import com.geektrust.example.geektrust.entities.Train;
import com.geektrust.example.geektrust.entities.Station;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BogieServiceTest {

    @Test
    public void testMergeBogies() {
        Station stationA1 = new Station("A1", "A1", 100);
        Station stationA2 = new Station("A2", "A2", 200);
        Station stationB1 = new Station("B1", "B1", 150);
        Station stationB2 = new Station("B2", "B2", 250);

        Train trainA = new Train("TrainA", new LinkedList<>(Arrays.asList(new Bogie("A1", stationA1), new Bogie("A2", stationA2))));
        Train trainB = new Train("TrainB", new LinkedList<>(Arrays.asList(new Bogie("B1", stationB1), new Bogie("B2", stationB2))));
        BogieService bogieService = new BogieService();

        LinkedList<Bogie> mergedBogies = bogieService.mergeBogies(trainA, trainB);

        assertEquals(4, mergedBogies.size());
    }

    @Test
    public void testRemoveHyderabadBogies() {
        Station stationA = new Station("A", "A", 100);
        Station stationB = new Station("B", "B", 200);
        Station stationC = new Station("C", "C", 300);
        Station stationHYB = new Station("HYB", "HYB", 0);

        LinkedList<Bogie> bogies = new LinkedList<>(
                Arrays.asList(new Bogie("A", stationA), new Bogie("B", stationB), new Bogie("C", stationC), new Bogie("HYB", stationHYB)));

        BogieService bogieService = new BogieService();
        bogieService.removeHyderabadBogies(bogies);

        assertEquals(3, bogies.size());
        assertEquals("C", bogies.getLast().getdestinationStationCode());
    }
}
