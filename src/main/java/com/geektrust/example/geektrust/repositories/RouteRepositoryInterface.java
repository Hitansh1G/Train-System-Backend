package com.geektrust.example.geektrust.repositories;

import com.geektrust.example.geektrust.entities.Route;

public interface RouteRepositoryInterface extends CRUDRepository<Route,String>{
    Route findByName(String routeName);

}
