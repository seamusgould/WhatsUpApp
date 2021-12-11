package com.example.whatsupapp.model;

import static java.lang.Math.floor;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.util.*;

public class EventCollection implements Serializable {
   private ArrayList<Event> ll;

   public EventCollection() {
      ll = new ArrayList<Event>();
   }

   @Override
   public String toString() {
      String str = "";
      for (Event obj : ll) {
         str += obj + "\n";
      }
      return str;
   }

   public void addEvent(Event event) {
      this.ll.add(event);
   }

   public Event makeEvent(String eventName, String eventDateAndTime,
                          String eventDescription, String eventPoster, String eventRoughLocation) {
      Event event = new Event(eventName, eventDateAndTime, eventDescription,
              eventPoster, eventRoughLocation);
      ll.add(event);
      return event;
   }

   public ArrayList<Event> getEventCollection() {
      return ll;
   }

   public Event getEvent(int i) {
      return ll.get(i);
   }

   public ArrayList<Event> findUsersEvents(String username) {
      List<Event> filteredList = new ArrayList<Event>();
      for (int i = 0; i < ll.size(); i++) {
         if (username.equals(ll.get(i).getEventPoster())) {
            filteredList.add(ll.get(i));
         }
      }
      return (ArrayList<Event>) filteredList;
   }

   public void handleRecurrence(Event e, Calendar c, String howOften, int howManyTimes, int howManySkip) {
      Calendar originalCalendar = Calendar.getInstance();
      originalCalendar = assignYearMonthDay(originalCalendar, c.get(Calendar.YEAR),
              c.get(Calendar.MONTH), c.get(Calendar.DATE));

      if (howOften.equals("weekly")) {

         for (int i = 1; i < (1 + howManyTimes); i++) {
            Calendar newCalendar = Calendar.getInstance();
            newCalendar = assignYearMonthDay(newCalendar, originalCalendar.get(Calendar.YEAR), originalCalendar.get(Calendar.MONTH),
                    originalCalendar.get(Calendar.DATE));

            int newDay = newCalendar.get(Calendar.DATE) + (i * ((1 + howManySkip) * 7));
            newCalendar.set(Calendar.DATE, newDay);
            String s = convertCalendarToString(newCalendar);
            e.addNewDateAndTime(s);

         }
      }

      //assumes they want it on the same week of the month, i.e. if the original date is the second friday of the month, the next monthly occurrence will also be on the second friday
      if (howOften.equals("monthly")) {
         Calendar currentCalendar = Calendar.getInstance();
         currentCalendar = assignYearMonthDay(currentCalendar, originalCalendar.get(Calendar.YEAR), originalCalendar.get(Calendar.MONTH),
                 originalCalendar.get(Calendar.DATE));

         for (int i = 1; i < (1 + howManyTimes); i++) {
            Calendar possibleCalendar = Calendar.getInstance();
            int newMonth = currentCalendar.get(Calendar.MONTH) + 1 + howManySkip;
            possibleCalendar = assignYearMonthDay(possibleCalendar, currentCalendar.get(Calendar.YEAR), newMonth,
                    currentCalendar.get(Calendar.DATE));

            int dayOfWeekDifference = currentCalendar.get(Calendar.DAY_OF_WEEK) - possibleCalendar.get(Calendar.DAY_OF_WEEK);

            //adjusts the new date to be the right day of the week
            possibleCalendar.set(Calendar.DATE, possibleCalendar.get(Calendar.DATE) + dayOfWeekDifference);

            int weekInMonth = getWeekOfDateInMonth(currentCalendar);
            int possibleWeekInMonth = getWeekOfDateInMonth(possibleCalendar);

            if (possibleWeekInMonth == weekInMonth) {
               currentCalendar = assignYearMonthDay(currentCalendar, possibleCalendar.get(Calendar.YEAR),
                       possibleCalendar.get(Calendar.MONTH), possibleCalendar.get(Calendar.DATE));
               String s = convertCalendarToString(possibleCalendar);
               e.addNewDateAndTime(s);

            } else if (possibleWeekInMonth < weekInMonth) {
               possibleCalendar.set(Calendar.DATE, possibleCalendar.get(Calendar.DATE) + 7);
               currentCalendar = assignYearMonthDay(currentCalendar, possibleCalendar.get(Calendar.YEAR), possibleCalendar.get(Calendar.MONTH),
                       possibleCalendar.get(Calendar.DATE));
               String s = convertCalendarToString(possibleCalendar);
               e.addNewDateAndTime(s);

            } else {
               possibleCalendar.set(Calendar.DATE, possibleCalendar.get(Calendar.DATE) - 7);
               currentCalendar = assignYearMonthDay(currentCalendar, possibleCalendar.get(Calendar.YEAR), possibleCalendar.get(Calendar.MONTH),
                       possibleCalendar.get(Calendar.DATE));
               String s = convertCalendarToString(possibleCalendar);
               e.addNewDateAndTime(s);

            }
         }
      }
   }

   public Calendar assignYearMonthDay(Calendar c, int year, int month, int day) {
      c.set(Calendar.YEAR, year);
      c.set(Calendar.MONTH, month);
      c.set(Calendar.DATE, day);
      return c;
   }

   private int getWeekOfDateInMonth(Calendar c) {
      if (c.get(Calendar.DATE) % 7 == 0) {
         return (int) (1 + floor(c.get(Calendar.DATE) / 7)) - 1;
      }
      return (int) (1 + floor(c.get(Calendar.DATE) / 7));
   }

   public String convertCalendarToString(Calendar c) {
      String s = addZero(1 + c.get(Calendar.MONTH)) + "/" + addZero(c.get(Calendar.DATE)) + "/" + c.get(Calendar.YEAR);
      return s;
   }

   public String addZero(int x) {
      if (x < 10) {
         return "0" + x;
      } else {
         return Integer.toString(x);
      }

   }

   public ArrayList<Event> orderEvents() {
      Collections.sort(ll, new Comparator<Event>() {
         @Override
         public int compare(Event e1, Event e2) {
            try {
               return e1.getFirstDay().compareTo(e2.getFirstDay());
            } catch (ParseException e) {
               e.printStackTrace();
            }
            return 1;
         }
      });
      return ll;
   }
}

