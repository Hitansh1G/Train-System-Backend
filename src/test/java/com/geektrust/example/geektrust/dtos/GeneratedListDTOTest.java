//package com.geektrust.example.geektrust.dtos;
//
//import com.geektrust.example.geektrust.entities.Bogie;
//import com.geektrust.example.geektrust.entities.Station;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.util.LinkedList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.*;
//
//public class GeneratedListDTOTest {
//
//    private LinkedList<Station> stations;
//    private LinkedList<Bogie> bogies;
//
//    @BeforeEach
//    public void setUp() {
//        stations = new LinkedList<>();
//        stations.add(new Station("STN1", "Station1", "STN1", 100));
//        stations.add(new Station("STN2", "Station2", "STN2", 200));
//        stations.add(new Station("STN3", "Station3", "STN3", 300));
//
//        bogies = new LinkedList<>();
//        bogies.add(new Bogie("B1", new Station("STN1", "Station1", "STN1", 100)));
//        bogies.add(new Bogie("B2", new Station("STN2", "Station2", "STN2", 200)));
//        bogies.add(new Bogie("B3", new Station("STN3", "Station3", "STN3", 300)));
//    }
//
//    @Test
//    public void testGenerateBogiesToRemoved() {
//        String destinationStationCode = "STN2";
//        List<Bogie> expectedBogiesToRemoved = new LinkedList<>();
//        expectedBogiesToRemoved.add(new Bogie("B2", new Station("STN2", "Station2", "STN2", 200)));
//
//        List<Bogie> actualBogiesToRemoved = GeneratedListDTO.generateBogiesToRemoved(stations, bogies, destinationStationCode);
//
//        assertEquals(expectedBogiesToRemoved, actualBogiesToRemoved);
//    }
//
//    @Test
//    public void testGenerateBogiesToRemovedWithMock() {
//        String destinationStationCode = "STN2";
//        List<Bogie> expectedBogiesToRemoved = new LinkedList<>();
//        expectedBogiesToRemoved.add(new Bogie("B2", new Station("STN2", "Station2", "STN2", 200)));
//
//        Station mockedStation = mock(Station.class);
//        when(mockedStation.getStationCode()).thenReturn("STN2");
//
//        LinkedList<Bogie> mockedBogies = new LinkedList<>();
//        mockedBogies.add(new Bogie("B1", new Station("STN1", "Station1", "STN1", 100)));
//        mockedBogies.add(new Bogie("B2", mockedStation));
//        mockedBogies.add(new Bogie("B3", new Station("STN3", "Station3", "STN3", 300)));
//
//        List<Bogie> actualBogiesToRemoved = GeneratedListDTO.generateBogiesToRemoved(stations, mockedBogies, destinationStationCode);
//
//        assertEquals(expectedBogiesToRemoved, actualBogiesToRemoved);
//    }
//}
