package com.geektrust.example.geektrust.dtos;

import com.geektrust.example.geektrust.entities.Bogie;
import com.geektrust.example.geektrust.entities.Route;
import com.geektrust.example.geektrust.entities.Station;
import com.geektrust.example.geektrust.repositories.IRouteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ComparatorDTOTest {

    private IRouteRepository routeRepository;
    private ComparatorDTO comparator;

    @BeforeEach
    public void setUp() {
        routeRepository = mock(IRouteRepository.class);
        comparator = new ComparatorDTO(routeRepository);
    }

    @Test
    public void testCompareWithBothBogiesNullStation() {
        Bogie bogie1 = new Bogie(null);
        Bogie bogie2 = new Bogie(null);

        int result = comparator.compare(bogie1, bogie2);

        assertEquals(0, result);
    }

    @Test
    public void testCompareWithBogie1NullStation() {
        Bogie bogie1 = new Bogie(null);
        Bogie bogie2 = new Bogie(new Station("STN1", "Station1", "STN1", 100));

        int result = comparator.compare(bogie1, bogie2);

        assertEquals(-1, result);
    }

    @Test
    public void testCompareWithBogie2NullStation() {
        Bogie bogie1 = new Bogie(new Station("STN1", "Station1", "STN1", 100));
        Bogie bogie2 = new Bogie(null);

        int result = comparator.compare(bogie1, bogie2);

        assertEquals(1, result);
    }

    @Test
    public void testCompareWithStations() {
        List<Route> routes = Arrays.asList(
                new Route("R1", "Route1", new LinkedList<>(Collections.singletonList(new Station("STN1", "Station1", "STN1", 100))), 200),
                new Route("R2", "Route2", new LinkedList<>(Collections.singletonList(new Station("STN2", "Station2", "STN2", 200))), 300)
        );

        when(routeRepository.findAll()).thenReturn(routes);

        Bogie bogie1 = new Bogie(new Station("STN1", "Station1", "STN1", 100));
        Bogie bogie2 = new Bogie(new Station("STN2", "Station2", "STN2", 200));

        int result = comparator.compare(bogie1, bogie2);

        assertEquals(-100, result);
    }
}
