package com.geektrust.example.geektrust.entity;
//package com.geektrust.example.geektrust.entities;

import com.geektrust.example.geektrust.entities.Bogie;
import com.geektrust.example.geektrust.entities.Station;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BogieEntityTest {

    private Bogie bogie;

    @BeforeEach
    public void setUp() {
        // You can create a mock Station object using Mockito if needed for testing
        Station destinationStation = new Station("STN1", "Station1", "STN", 100);
        bogie = new Bogie("1", destinationStation);
    }

    @Test
    public void testGetDestinationStation() {
        Station destinationStation = bogie.getdestinationStation();
        assertNotNull(destinationStation);
        assertEquals("STN1", destinationStation.getId());
        assertEquals("Station1", destinationStation.getStationName());
        assertEquals("STN", destinationStation.getStationCode());
        assertEquals(100, destinationStation.getDistance());
    }

    @Test
    public void testGetDestinationStationCode() {
        String stationCode = bogie.getdestinationStationCode();
        assertEquals("STN", stationCode);
    }

    @Test
    public void testIfDestinationNull() {
        Station destinationStation1 = new Station("STN1", "Station1", "STN", 100);
        Station destinationStation2 = new Station("STN2", "Station2", "STN", 200);
        Bogie bogie1 = new Bogie("1", destinationStation1);
        Bogie bogie2 = new Bogie("2", destinationStation2);

        assertFalse(bogie.ifDestinationNull(bogie1, bogie2));

        bogie1 = new Bogie("1", null);
        bogie2 = new Bogie("2", destinationStation2);

        assertTrue(bogie.ifDestinationNull(bogie1, bogie2));

        bogie1 = new Bogie("1", destinationStation1);
        bogie2 = new Bogie("2", null);

        assertTrue(bogie.ifDestinationNull(bogie1, bogie2));
    }

    @Test
    public void testHashCode() {
        // You can modify this test based on your requirements
        Bogie bogie1 = new Bogie("1", null);
        Bogie bogie2 = new Bogie("2", null);

        assertNotEquals(bogie1.hashCode(), bogie2.hashCode());

        bogie1 = new Bogie("1", new Station("STN1", "Station1", "STN", 100));
        bogie2 = new Bogie("1", new Station("STN2", "Station2", "STN", 200));

        assertEquals(bogie1.hashCode(), bogie2.hashCode());
    }
}
