package com.example.whatsupapp.model;

import java.util.*;

public class EventCollection {
   private ArrayList<Event> ll = new ArrayList<Event>();

   public EventCollection() {
   }

   public String toString() {
      String accstring = "";

      if (ll.size() == 0) {
         return "There are currently no events. Post something!";
      }
      else {
         for (Event obj : ll) {
            accstring += obj + "\n";
         }
         return accstring;
      }
   }

   public Event makeEvent(String eventName, String eventDateAndTime, String time,
                          String eventRoughLocation, String eventDescription) {
      Event event =  new Event(eventName, eventDateAndTime, 2, eventDescription,
              "yas", eventRoughLocation);
      ll.add(event);
      return event;
   }

   public Event getEvent(int i) {
      return ll.get(i);
   }
}