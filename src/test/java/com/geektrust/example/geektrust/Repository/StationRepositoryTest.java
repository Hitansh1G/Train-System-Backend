package com.geektrust.example.geektrust.Repository;


import com.geektrust.example.geektrust.entities.Station;
import com.geektrust.example.geektrust.repositories.StationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class StationRepositoryTest {

    private StationRepository stationRepository;

    public StationRepositoryTest() {
    }

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        stationRepository = new StationRepository();
    }

    @Test
    public void testFindStationByCode() {
        String stationCode = "STN1";
        Station station = new Station("1", "Station1", stationCode, 100);

        stationRepository.save(station);

        Station foundStation = stationRepository.findStationByCode(stationCode);
        assertNotNull(foundStation);
        assertEquals(stationCode, foundStation.getStationCode());
    }

    @Test
    public void testGetStationListing() {
        HashMap<String, Station> stationListing = stationRepository.getStationListing();
        assertNotNull(stationListing);
        assertTrue(stationListing.isEmpty());
    }

    @Test
    public void testSave() {
        String stationCode = "STN1";
        Station station = new Station("Station1", stationCode, 100);

        Station savedStation = stationRepository.save(station);

        assertNotNull(savedStation);
        assertNotNull(savedStation.getId());
        assertEquals(stationCode, savedStation.getStationCode());
        assertEquals(station.getStationName(), savedStation.getStationName());
        assertEquals(station.getDistance(), savedStation.getDistance());
    }

    @Test
    public void testUpdate() {
        String stationCode = "STN1";
        Station station = new Station("Station1", stationCode, 100);

        Station savedStation = stationRepository.save(station);

        String newStationName = "Station1Updated";
        savedStation.setStationName(newStationName);
        stationRepository.save(savedStation);

        Station updatedStation = stationRepository.findStationByCode(stationCode);
        assertNotNull(updatedStation);
        assertEquals(newStationName, updatedStation.getStationName());
    }


}
