package com.geektrust.example.geektrust.entity;

import com.geektrust.example.geektrust.entities.Bogie;
import com.geektrust.example.geektrust.entities.Station;
import com.geektrust.example.geektrust.entities.Train;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static junit.framework.Assert.assertEquals;

public class TrainEntityTest {
    private Train train;

    @BeforeEach()
    public void setup(){
        LinkedList<Bogie> bogies = new LinkedList<Bogie>(){
            {
                add(new Bogie("1", new Station("1", "New Delhi", "NDL", 0)));
                add(new Bogie("2",new Station("2", "New Jalpaiguri", "NJP", 3000)));
            }
        };
        train = new Train("1", "abc", bogies);
    }

    @Test
    @DisplayName("1 Add bogie test")
    public void add_bogie_in_train(){
        //Arrange
        Bogie bogie = new Bogie("3",new Station("2", "New Jalpaiguri", "NJP", 3000));
        Bogie bogie1 = new Bogie("4",new Station("3", "KURNOOL", "KRN", 900));
        //Act
        train.addBogie(bogie);
        train.addBogie(bogie1);
        //Assert
        assertEquals(4, train.getBogies().size());
    }

    @Test
    @DisplayName("2 Delete bogie test")
    public void delete_bogie_in_train(){
        //Arrange
        Bogie bogie = new Bogie("9", new Station("3", "Hydrabad", "HYD", 0));
        Bogie bogie1 = new Bogie("10", new Station("2", "New Jalpaiguri", "NJP", 1000));

        //Act
        train.addBogie(bogie);
        train.addBogie(bogie1);

        train.deleteBogie(bogie);
        train.deleteBogie(bogie1);
        //Assert
        assertEquals(2, train.getBogies().size());

    }
}
