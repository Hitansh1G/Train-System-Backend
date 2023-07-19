package com.example.geektrust.repositories;

import com.example.geektrust.entities.Bogie;
import com.example.geektrust.entities.Route;

import java.util.List;

public interface IRouteRepository extends CRUDRepository<Route,String> {

    Route saveRoute(Route route);

    Route findRouteByName(String routeName);

    static List<Route> getAllRoutes() {
        return null;
    }


    void preDefinedRoute();


}
