package com.geektrust.example.geektrust.repositories;

import java.util.HashMap;
import com.geektrust.example.geektrust.entities.Bogie;

public interface IBogieRepository {
    Bogie saveBoggy(Bogie bogie);
    HashMap<String, Bogie> getBoggyMapping();
}
