package com.geektrust.example.geektrust.repositories;

import java.util.List;
import com.geektrust.example.geektrust.entities.Route;

public interface IRouteRepository {
    void saveRoute(Route route);

    Route findRouteByName(String routeName);

    List<Route> getAllRoutes();    
}
