package com.geektrust.example.geektrust.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.HashMap;
import com.geektrust.example.geektrust.entities.Bogie;
import com.geektrust.example.geektrust.entities.Station;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BogieRepositoryTest {
    private BoggyRepository boggyRepository;

    @BeforeEach
    public void setup(){
        HashMap<String, Bogie> boggyMapping = new HashMap<String, Bogie>();
        boggyMapping.put("1", new Bogie("1",  new Station("1", "New Delhi", "NDL", 0)));
        boggyRepository = new BoggyRepository(boggyMapping);
    }

    @Test
    @DisplayName("#1 Save method should save a new boggy")
    public void save_boggy_test(){
        //Arrange
        Bogie bogie = new Bogie("2",new Station("2", "New Jalpaiguri", "NJP", 3000));
        //Act
        boggyRepository.saveBoggy(bogie);
        //Assert
        assertEquals(2, boggyRepository.getBoggyMapping().size());
    }
    
}
