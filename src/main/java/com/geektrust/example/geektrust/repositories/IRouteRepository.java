package com.geektrust.example.geektrust.repositories;

import java.util.List;
import com.geektrust.example.geektrust.entities.Route;

public interface IRouteRepository extends CRUDRepository<Route,String>{
    Route findByName(String routeName);

}
