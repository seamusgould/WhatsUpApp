package com.example.whatsupapp.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.Calendar;

class EventCollectionTest {
    EventCollection collection = new EventCollection();
    User practicePoster = new User("Island_Boy");

    @Test
    void testToString() {
        Event practiceEvent = collection.makeEvent("Hood Classic", "01/01/2021 07:00",
                "great party", "bob", "Main Building");
        Event practiceEvent2 = collection.makeEvent("Hood Classic 2", "02/01/2021 07:00",
                "great party 2", "charlie","Main Building");
        Event practiceEvent3 = collection.makeEvent("Hood Classic 3", "02/01/2021 07:00",
                "great party 2", "mary","Main Building");

        String str = practiceEvent.toString() + "\n";
        str = str + practiceEvent2.toString() + "\n";
        str = str + practiceEvent3.toString() + "\n";

        assertEquals(str, collection.toString());

    }

    @Test
    void testMakeEvent() {
        Event practiceEvent = collection.makeEvent("Hood Classic", "01/01/2021 07:00",
                "great party","bob", "Main Building");

        Event practiceEvent2 = collection.makeEvent("Hood Classic 2", "02/01/2021 07:00",
                "great party 2", "mary","Main Building");

        assertEquals(practiceEvent, collection.getEventCollection().get(0));
        assertEquals(practiceEvent2, collection.getEventCollection().get(1));

        Event practiceEvent3 = new Event ("Hood Classic", "01/01/2021 07:00",
                "great party", "yas", "Main Building");


        assertEquals(practiceEvent.name, practiceEvent3.name);
        assertEquals(practiceEvent.eventDateAndTime, practiceEvent3.eventDateAndTime);
        assertEquals(practiceEvent.eventDescription, practiceEvent3.eventDescription);
        assertEquals(practiceEvent.eventPoster, practiceEvent3.eventPoster);
        assertEquals(practiceEvent.eventLocation, practiceEvent3.eventLocation);

    }


    @Test
    void handleRecurrence() {
        EventCollection collection = new EventCollection();
        Calendar practiceDateAndTime = Calendar.getInstance();
        practiceDateAndTime.set(Calendar.YEAR, 2000);
        practiceDateAndTime.set(Calendar.MONTH, Calendar.SEPTEMBER);
        practiceDateAndTime.set(Calendar.DATE, 12);
        User practicePoster = new User("Island_Boy");
        Event practiceEvent = new Event("Hood Classic 2000", collection.convertCalendarToString(practiceDateAndTime), "THE BEST PARTY IN SOUTH CACKALACKY", practicePoster.getUsername(), "Main Building");
        assertEquals(practiceDateAndTime, practiceEvent.getAllDatesAndTimes().get(0), "original date is not in the right place");


        collection.handleRecurrence(practiceEvent, practiceDateAndTime, "weekly", 3, 0);

        //since Calendar contains far more data than just day, month, and year, it's not practical to check for identical Calendar objects.
        assertEquals("9/19/2000", practiceEvent.getAllDatesAndTimes().get(1).substring(0, 8), "weekly recurrence not working");
        assertEquals("9/26/2000", practiceEvent.getAllDatesAndTimes().get(2).substring(0, 8), "weekly recurrence not working");
        assertEquals("10/03/2000", practiceEvent.getAllDatesAndTimes().get(3).substring(0,8), "weekly recurrence not working");

        Calendar practiceDateAndTime2 = Calendar.getInstance();
        practiceDateAndTime2 = collection.assignYearMonthDay(practiceDateAndTime2, 2021, Calendar.SEPTEMBER, 3);
        Event practiceEvent2 = new Event("Garage Sale", collection.convertCalendarToString(practiceDateAndTime), "cheap stuff", practicePoster.getUsername(), "Arlington United Methodist Church");

        collection.handleRecurrence(practiceEvent2, practiceDateAndTime2,"monthly", 3, 1);

        assertEquals("11/05/2021", practiceEvent2.getAllDatesAndTimes().get(1).substring(0, 8), "monthly recurrence not working");
        assertEquals("01/07/2021", practiceEvent2.getAllDatesAndTimes().get(2).substring(0, 8), "monthly recurrence not working");
        assertEquals("03/04/2021", practiceEvent2.getAllDatesAndTimes().get(3).substring(0, 8), "monthly recurrence not working");


    }
}
