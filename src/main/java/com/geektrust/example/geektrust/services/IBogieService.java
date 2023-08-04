package com.geektrust.example.geektrust.services;

import com.geektrust.example.geektrust.entities.Bogie;
import com.geektrust.example.geektrust.entities.Train;

import java.util.LinkedList;

public interface IBogieService {
    LinkedList<Bogie> mergeBogies(Train trainA, Train trainB);
    void removeHyderabadBogies(LinkedList<Bogie> bogies);
}
