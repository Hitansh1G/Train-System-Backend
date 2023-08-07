package com.geektrust.example.geektrust.entity;
//package com.geektrust.example.geektrust.entities;

import com.geektrust.example.geektrust.entities.Route;
import com.geektrust.example.geektrust.entities.Station;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class RouteEntityTest {

    private Route route;

    @BeforeEach
    public void setUp() {
        // You can create a mock list of stations and set the hyderabadDistance for testing purposes
        LinkedList<Station> stations = new LinkedList<>();
        stations.add(new Station("STN1", "Station1", "STN", 100));
        stations.add(new Station("STN2", "Station2", "STN", 200));
        int hyderabadDistance = 300;

        route = new Route("1", "RouteName", stations, hyderabadDistance);
    }

    @Test
    public void testGetRouteName() {
        String routeName = route.getRouteName();
        assertEquals("RouteName", routeName);
    }

    @Test
    public void testGetStations() {
        LinkedList<Station> stations = route.getStations();
        assertNotNull(stations);
        assertEquals(2, stations.size());
        assertEquals("STN1", stations.get(0).getId());
        assertEquals("Station1", stations.get(0).getStationName());
        assertEquals("STN", stations.get(0).getStationCode());
        assertEquals(100, stations.get(0).getDistance());
        assertEquals("STN2", stations.get(1).getId());
        assertEquals("Station2", stations.get(1).getStationName());
        assertEquals("STN", stations.get(1).getStationCode());
        assertEquals(200, stations.get(1).getDistance());
    }

    @Test
    public void testGetHyderabadDistance() {
        int hyderabadDistance = route.getHyderabadDistance();
        assertEquals(300, hyderabadDistance);
    }

    @Test
    public void testSetRouteName() {
        route.setRouteName("NewRouteName");
        assertEquals("NewRouteName", route.getRouteName());
    }

    @Test
    public void testSetStations() {
        LinkedList<Station> newStations = new LinkedList<>();
        newStations.add(new Station("STN3", "Station3", "STN", 300));
        newStations.add(new Station("STN4", "Station4", "STN", 400));

        route.setStations(newStations);

        LinkedList<Station> stations = route.getStations();
        assertNotNull(stations);
        assertEquals(2, stations.size());
        assertEquals("STN3", stations.get(0).getId());
        assertEquals("Station3", stations.get(0).getStationName());
        assertEquals("STN", stations.get(0).getStationCode());
        assertEquals(300, stations.get(0).getDistance());
        assertEquals("STN4", stations.get(1).getId());
        assertEquals("Station4", stations.get(1).getStationName());
        assertEquals("STN", stations.get(1).getStationCode());
        assertEquals(400, stations.get(1).getDistance());
    }

    @Test
    public void testIsStationPresent() {
        Station station1 = new Station("STN1", "Station1", "STN", 100);
        Station station2 = new Station("STN3", "Station3", "STN", 300);

        assertFalse(route.isStationPresent(station1));
        assertFalse(route.isStationPresent(station2));
    }

    @Test
    public void testHashCode() {
        // You can modify this test based on your requirements
        Route route1 = new Route("1", "RouteName", new LinkedList<>(), 100);
        Route route2 = new Route("2", "RouteName", new LinkedList<>(), 100);

        assertNotEquals(route1.hashCode(), route2.hashCode());

        route1 = new Route("1", "RouteName", new LinkedList<>(), 100);
        route2 = new Route("1", "RouteName", new LinkedList<>(), 200);

        assertEquals(route1.hashCode(), route2.hashCode());
    }
}
