package com.example.geektrust.repositories;

import com.example.geektrust.entities.Bogie;

import java.util.HashMap;

public interface IBogieRepository extends CRUDRepository<Bogie,String> {
    Bogie saveBogie(Bogie bogie);
    HashMap<String , Bogie> BogieListing();
}
