package com.geektrust.example.geektrust.repositories;

import java.util.Map;

import com.geektrust.example.geektrust.entities.Bogie;

public interface IBogieRepository extends CRUDRepository<Bogie,String>{
    Map<String, Bogie> getBogieListing();
}
