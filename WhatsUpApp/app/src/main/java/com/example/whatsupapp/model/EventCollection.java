package com.example.whatsupapp.model;

import java.util.*;

public class EventCollection {
   private ArrayList<Event> ll = new ArrayList<Event>();

   public EventCollection() {
   }

   @Override
   public String toString() {
      String str = "";
         for (Event obj : ll) {
            str += obj + "\n";
         }
         return str;
      }

   public Event makeEvent(String eventName, String eventDate, String eventTime,
                          String eventDescription, String eventRoughLocation) {
      Event event =  new Event(eventName, eventDate, eventTime, eventDescription,
              "yas", eventRoughLocation);
      ll.add(event);
      return event;
   }

   public Event getEvent(int i) {
      return ll.get(i);
   }
}