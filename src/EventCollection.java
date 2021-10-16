import java.util.Date;
import java.util.*;

public class EventCollection {
   private ArrayList<Event> ll = new ArrayList<Event>();

   public EventCollection() {

   }

   public String toString() {
      String accstring = "";

      if (ll.size() == 0) {
         return "There are currently no events. Post something!";
      } else {
         for (Event obj : ll) {
            accstring += obj;
            accstring += "\n";
            accstring += "\n";
            accstring += "\n";
            accstring += "\n";
         }
         return accstring;
      }
   }


   public Event makeEvent(String eventName, Calendar eventDateAndTime, int eventRecurrence, String eventDescription, User poster, Location eventRoughLocation) {
      Event event =  new Event(eventName, eventDateAndTime, eventRecurrence, eventDescription, poster, eventRoughLocation);
      ll.add(event);
      return event;
   }
}