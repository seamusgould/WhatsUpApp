package com.example.whatsupapp.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.Test;

import java.util.Calendar;

class EventTest {
    Event e = new Event("Hood Classic", "04/13/2002 07:00", "All welcome", "Island_Boy",
            "Main Building");
    //@Test
    /*void addNewDateAndTime() {

        String newDateAndTime = "05/13/2002 07:00";
        e.addNewDateAndTime(newDateAndTime);

        assertEquals("04/13/2002 07:00", e.getAllDatesAndTimes().get(0));
        assertEquals(newDateAndTime, e.getAllDatesAndTimes().get(1));
    }*/

    @Test
    void testToString() {
        String str = "Island_Boy posted: \n";
        str += " On 04/13/2002 07:00 Hood Classic at Main Building";
        str += "\n All welcome";
        assertEquals(str, e.toString());
    }
}