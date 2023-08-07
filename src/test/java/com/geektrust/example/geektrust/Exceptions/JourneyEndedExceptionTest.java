package com.geektrust.example.geektrust.Exceptions;

//package com.geektrust.example.geektrust.exceptions;

import com.geektrust.example.geektrust.exceptions.JourneyEndedException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JourneyEndedExceptionTest {

    @Test
    public void testJourneyEndedExceptionMessage() {
        String expectedMessage = "Journey has ended.";
        JourneyEndedException exception = new JourneyEndedException(expectedMessage);

        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testJourneyEndedExceptionWithNullMessage() {
        String expectedMessage = null;
        JourneyEndedException exception = new JourneyEndedException(expectedMessage);

        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }
}
