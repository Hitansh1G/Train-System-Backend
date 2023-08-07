package com.geektrust.example.geektrust.dtos;

import com.geektrust.example.geektrust.entities.Bogie;
import com.geektrust.example.geektrust.entities.Station;
import com.geektrust.example.geektrust.entities.Train;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class PrintTrainDTOTest {

    @Test
    public void testPrintTrainWithNullDestinationStation() {
        Train train = createTrainWithBogies(new Bogie(null));
        String arrivalOrDeparture = "Arrival";

        String expectedOutput = arrivalOrDeparture + " TRAIN_NAME " + "ENGINE";
        String actualOutput = getPrintedOutput(train, arrivalOrDeparture);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testPrintTrainWithDestinationStation() {
        Station station = new Station("STN1", "Station1", "STN1", 100);
        Train train = createTrainWithBogies(new Bogie(station));
        String arrivalOrDeparture = "Departure";

        String expectedOutput = arrivalOrDeparture + " TRAIN_NAME " + "STN1";
        String actualOutput = getPrintedOutput(train, arrivalOrDeparture);

        assertEquals(expectedOutput, actualOutput);
    }

    private Train createTrainWithBogies(Bogie... bogies) {
        LinkedList<Bogie> bogieList = new LinkedList<>(Arrays.asList(bogies));
        return new Train("TRAIN_NAME", bogieList);
    }

    private String getPrintedOutput(Train train, String arrivalOrDeparture) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        PrintTrainDTO.printTrain(train, arrivalOrDeparture);
        return outputStream.toString().trim();
    }
}
