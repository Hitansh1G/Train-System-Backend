package com.geektrust.example.geektrust.repositories;

import java.util.HashMap;
import com.geektrust.example.geektrust.entities.Bogie;

public interface IBoggyRepository {
    Bogie saveBoggy(Bogie bogie);
    HashMap<String, Bogie> getBoggyMapping();
}
