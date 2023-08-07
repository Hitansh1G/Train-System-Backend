package com.geektrust.example.geektrust.Repository;

import com.geektrust.example.geektrust.entities.Route;

import com.geektrust.example.geektrust.repositories.RouteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.*;

public class RouteRepositoryTest {

    private RouteRepository routeRepository;

    @BeforeEach
    public void setUp() {
        routeRepository = new RouteRepository();
    }

    @Test
    public void testFindByName() {
        Route route1 = new Route("1", "Route1", new LinkedList<>(), 100);
        Route route2 = new Route("2", "Route2", new LinkedList<>(), 200);
        Route route3 = new Route("3", "Route3", new LinkedList<>(), 300);

        routeRepository.save(route1);
        routeRepository.save(route2);
        routeRepository.save(route3);

        assertEquals(route1, routeRepository.findByName("Route1"));
        assertEquals(route2, routeRepository.findByName("Route2"));
        assertEquals(route3, routeRepository.findByName("Route3"));
        assertNull(routeRepository.findByName("Route4"));
    }

    @Test
    public void testSave() {
        Route route = new Route("Route1", new LinkedList<>(), 100);
        Route savedRoute = routeRepository.save(route);

        assertNotNull(savedRoute.getId());
        assertEquals("Route1", savedRoute.getRouteName());
        assertEquals(0, savedRoute.getStations().size());
        assertEquals(100, savedRoute.getHyderabadDistance());
        assertEquals(savedRoute, routeRepository.findByName("Route1"));

        // Updating the existing route
        savedRoute.setRouteName("NewRoute");
        routeRepository.save(savedRoute);

        assertEquals(savedRoute, routeRepository.findByName("NewRoute"));
    }
}

