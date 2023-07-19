package com.geektrust.example.geektrust.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.LinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TrainTest {
    private Train train;
    
    @BeforeEach()
    public void setup(){
        LinkedList<Bogie> boggies = new LinkedList<Bogie>(){
            {
                add(new Bogie("1", new Station("1", "New Delhi", "NDL", 0)));
                add(new Bogie("2",new Station("2", "New Jalpaiguri", "NJP", 3000)));
            }
        };
        train = new Train("1", "abc", boggies);
    }

    @Test
    @DisplayName("#1 Add boggy test")
    public void add_boggy_in_train(){
        //Arrange
        Bogie bogie = new Bogie("3",new Station("2", "New Jalpaiguri", "NJP", 3000));
        //Act
        train.addBoggy(bogie);
        //Assert
        assertEquals(3, train.getBoggies().size());
    }

    @Test
    @DisplayName("#2 Delete boggy test")
    public void delete_boggy_in_train(){
        //Arrange
        Bogie bogie = new Bogie("1", new Station("1", "New Delhi", "NDL", 0));
        //Act
        train.deleteBoggy(bogie);
        //Assert
        assertEquals(1, train.getBoggies().size());

    }
}
