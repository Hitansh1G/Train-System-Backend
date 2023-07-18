package com.example.geektrust.repositories;

import com.example.geektrust.entities.Route;

import java.util.*;
import java.util.stream.Collectors;

public class RouteRepository implements IRouteRepository {

    private HashMap<String, Route> routeListing;

    public RouteRepository() {
        this.routeListing = new HashMap<String, Route>();
    }

    public RouteRepository(HashMap<String, Route> routeListing){
        this.routeListing = routeListing;
    }

    @Override
    public Route save(Route entity) {
        return null;
    }

    @Override
    public List<Route> findAll() {
        return null;
    }

    @Override
    public Optional<Route> findById(String s) {
        return Optional.empty();
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

    private Integer identification=0;
    @Override
    public Route saveRoute(Route route) {
//        return null;
        if(route.getId() == null){
            identification++;
            Route tempRoute = new Route(Integer.toString(identification) ,
                    route.getRouteName(),
                    route.getStationsStops(),
                    route.getHyderabadDistance());
            routeListing.put(tempRoute.getId(), tempRoute);
        }

        routeListing.put(route.getId(), route);
        return route;
    }


    @Override
    public Route findRouteByName(String routeName) {
//        return null;
        return routeListing.values().stream().filter(route -> route.getRouteName().equals(routeName)).findFirst().get();
    }

    @Override
    public List<Route> getAllRoutes() {
//        return null;
        return new ArrayList<>(routeListing.values());
    }
}
