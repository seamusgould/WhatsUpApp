package com.example.whatsupapp.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.Test;

import java.util.Calendar;

class EventTest {
    Calendar newCalendar = Calendar.getInstance();
    Event e = new Event("Hood Classic", "04/13/2002", "07:00", "All welcome", "Island_Boy",
            "Main Building");
    @Test
    void addNewDateAndTime() {
        newCalendar.set(Calendar.YEAR, 2002);
        newCalendar.set(Calendar.MONTH, Calendar.MAY);
        newCalendar.set(Calendar.DATE, 13);
        e.addNewDateAndTime(newCalendar);

        assertEquals(newCalendar.get(Calendar.YEAR), e.getAllDatesAndTimes().get(0).get(Calendar.YEAR));
        assertEquals(newCalendar.get(Calendar.MONTH), e.getAllDatesAndTimes().get(0).get(Calendar.MONTH));
        assertEquals(newCalendar.get(Calendar.DATE), e.getAllDatesAndTimes().get(0).get(Calendar.DATE));
    }

    @Test
    void testToString() {
        String str = "Island_Boy posted: \n";
        str += " On 04/13/2002 07:00 Hood Classic at Main Building";
        str += "\n All welcome";
        assertEquals(str, e.toString());
    }
}