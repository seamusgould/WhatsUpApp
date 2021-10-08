import java.util.*;

public class EventCollection {
   ArrayList<Event> ll = new ArrayList<Event>();

   EventCollection(){
      ArrayList<Event> ll = new ArrayList<Event>();
   }

   public void include(Event e){
      ll.add(e);
   }

   public String toString(){
      String accstring = "";
      for(Event obj : ll) {
         accstring += obj;
         accstring += "\n";
      }
      return accstring;
   }
}
