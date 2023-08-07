package com.geektrust.example.geektrust.Exceptions;

import com.geektrust.example.geektrust.exceptions.JourneyEndedException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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
        JourneyEndedException exception = new JourneyEndedException(null);

        String actualMessage = exception.getMessage();

        assertNull(actualMessage);
    }
}
