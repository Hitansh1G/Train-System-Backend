package com.geektrust.example.geektrust.repositories;

import java.util.HashMap;
import com.geektrust.example.geektrust.entities.Bogie;

public interface IBogieRepository extends CRUDRepository<Bogie,String>{
//    Bogie saveBoggy(Bogie bogie);
    HashMap<String, Bogie> getBoggyMapping();
}
