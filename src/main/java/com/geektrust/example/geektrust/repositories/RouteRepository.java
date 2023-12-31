package com.geektrust.example.geektrust.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.geektrust.example.geektrust.entities.Route;

import static com.geektrust.example.geektrust.Constants.Constants.*;

public class RouteRepository implements IRouteRepository {
    private final HashMap<String, Route> routeListing;
    private int autoIncrement = ZERO;

    public RouteRepository() {
        this.routeListing = new HashMap<>();
    }

    @Override
    public Route findByName(String routeName) {
        return routeListing.values().stream()
                .filter(route -> route.getRouteName().equals(routeName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Route save(Route route) {
        if (route.getId() == null) {
            autoIncrement++;
            Route newRoute = new Route(RANDOM + autoIncrement, route.getRouteName(), route.getStations(), route.getHyderabadDistance());
            routeListing.put(newRoute.getId(), newRoute);
            return newRoute;
        }
        routeListing.put(route.getId(), route);
        return route;
    }

    @Override
    public List<Route> findAll() {
        return new ArrayList<>(routeListing.values());
    }

}
