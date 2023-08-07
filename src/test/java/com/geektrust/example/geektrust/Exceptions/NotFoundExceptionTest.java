package com.geektrust.example.geektrust.Exceptions;

import com.geektrust.example.geektrust.exceptions.NotFoundException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NotFoundExceptionTest {

    @Test
    public void testNotFoundException() {
        NotFoundException exception = assertThrows(NotFoundException.class, () -> {
            throw new NotFoundException();
        });

        assertNotNull(exception);
    }
}
