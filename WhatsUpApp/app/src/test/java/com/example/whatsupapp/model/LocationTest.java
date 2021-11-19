package com.example.whatsupapp.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class LocationTest {

    @Test
    public void testGetLocationList()
    {
        assertEquals("Class of 1951 Observatory", Location.getLocationList().get(16).toString());
        assertEquals("Skinner Hall of Music", Location.getLocationList().get(27).toString());
    }
}