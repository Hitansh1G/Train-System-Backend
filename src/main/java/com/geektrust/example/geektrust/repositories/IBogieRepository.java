package com.geektrust.example.geektrust.repositories;

import java.util.HashMap;
import com.geektrust.example.geektrust.entities.Bogie;

public interface IBogieRepository extends CRUDRepository<Bogie,String>{
    HashMap<String, Bogie> getBogieListing();
}
