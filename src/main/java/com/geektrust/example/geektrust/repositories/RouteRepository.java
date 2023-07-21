package com.geektrust.example.geektrust.repositories;

import java.util.*;
import com.geektrust.example.geektrust.entities.Route;

public class RouteRepository implements IRouteRepository {
    private final HashMap<String, Route> routeListing;
    private Integer autoIncrement = 0;

    public RouteRepository() {
        this.routeListing = new HashMap<>();
    }

//    public RouteRepository(HashMap<String, Route> routeListing){
//        this.routeListing = routeListing;
//    }
    

    @Override
    public Route findByName(String routeName) {
        return routeListing.values().stream().filter(route -> route.getRouteName().equals(routeName)).findFirst().get();
    }


    @Override
    public Route save(Route route) {
        if (route.getId() == null) {
            autoIncrement++;
            Route newRoute = new Route("R" + autoIncrement, route.getRouteName(), route.getStations(), route.getHyderabadDistance());
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

    @Override
    public Optional<Route> findById(String routeName) {
        return Optional.of(routeListing.values().stream().filter(route -> route.getRouteName().equals(routeName)).findFirst().get());

    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public void delete(Route entity) {

    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public long count() {
        return 0;
    }
}
