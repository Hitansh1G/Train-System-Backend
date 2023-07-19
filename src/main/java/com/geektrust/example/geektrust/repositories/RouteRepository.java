package com.geektrust.example.geektrust.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.geektrust.example.geektrust.entities.Route;

public class RouteRepository implements IRouteRepository {
    private HashMap<String, Route> routeMapping;
    private Integer autoIncrement = 0;

    public RouteRepository() {
        this.routeMapping = new HashMap<String, Route>();
    }

    public RouteRepository(HashMap<String, Route> routeMapping){
        this.routeMapping = routeMapping;
    }

    @Override
    public void saveRoute(Route route) {
        if(route.getId() == null){
            autoIncrement++;
            Route newRoute = new Route(Integer.toString(autoIncrement), route.getRouteName(), route.getStations(), route.getHyderabadDistance());
            routeMapping.put(newRoute.getId(), newRoute);
            return;
        }
        routeMapping.put(route.getId(), route);
    }

    @Override
    public Route findRouteByName(String routeName) {
        Route route = routeMapping.entrySet().stream().filter(e -> e.getValue().getRouteName().equals(routeName))
                .map(Map.Entry::getValue).findFirst().get();
        return route;
    }

    @Override
    public List<Route> getAllRoutes() {
        return routeMapping.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
    }
    
}
