package com.geektrust.example.geektrust.services;

import com.geektrust.example.geektrust.entities.Bogie;
import com.geektrust.example.geektrust.entities.Train;

import java.util.LinkedList;

import static com.geektrust.example.geektrust.Constants.Constants.HYB;

public class BogieService implements IBogieService{
    @Override
    public LinkedList<Bogie> mergeBogies(Train trainA, Train trainB) {
        LinkedList<Bogie> mergedBogies = new LinkedList<>(trainA.getBogies());
        mergedBogies.addAll(trainB.getBogies());
        return mergedBogies;
    }

    @Override
    public void removeHyderabadBogies(LinkedList<Bogie> bogies) {
        while (!bogies.isEmpty() && HYB.equals(bogies.getLast().getdestinationStation().getStationCode())) {
            bogies.removeLast();
        }
    }

}
