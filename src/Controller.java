import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import java.io.*;

public class Controller {
    private EventCollection collection = new EventCollection();
    private ArrayList<Location>locationList = new ArrayList<Location>();

    Location mainBuilding = new Location("main");

    public Event makeEvent(String eventName, Calendar eventDateAndTime, int eventRecurrence, String eventDescription, User poster, String eventRoughLocation) {
        Location eLocation = new Location(eventRoughLocation);
        //will do this once we figure out how to not add duplicate elements
        //Location eLocation = newLocationFromString(eventRoughLocation);
        Event newEvent = collection.makeEvent(eventName, eventDateAndTime, eventRecurrence, eventDescription, poster, eLocation);
        return newEvent;
    }

    public EventCollection getEventCollection()
    {
        return collection;
    }

    public ArrayList getLocationList()
    {
        return locationList;
    }

    public void addNewLocation(Location l)
    {
        locationList.add(l);
    }

    public Location newLocationFromString(String s)
    {
        Location possibleNewLoc = new Location(s);
        if (!locationList.contains(possibleNewLoc)){
            locationList.add(possibleNewLoc);}
        return possibleNewLoc;
    }

    public boolean isResponsePost(String s)
    {
        return s.toLowerCase().equals("post");

    }

    public boolean isValidIntSelection(String i)
    {
        try {
            int j = Integer.parseInt(i);
        }
        catch(NumberFormatException  e) {
            System.out.println("Invalid response.  Make sure that the input is an integer.");
            return false;
        }

        try{
            collection.getEvent(Integer.parseInt(i));
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid response.  Choose a smaller number.");
            return false;
        }
        return true;
    }

    public boolean isValidResponse(String s)
    {
        s = s.toLowerCase();
        return (s.equals("select") || s.equals("post"));
    }

    public boolean isResponseSelect(String s)
    {
        return s.toLowerCase().equals("select");

    }

    public void makeVote(String s, int i) {
        Event eSelection = collection.getEvent(i);
        if (s.equals("upvote")){
            eSelection.upvoteDownvote += 1;
        }
        else eSelection.upvoteDownvote -= 1;
    }

    public void makeComment(String s, int i) {
        Event eSelection = collection.getEvent(i);
        eSelection.addComment(s);
    }

    //adds locations that are likely to host events on the Vassar campus

    public void addStandardLocations()
    {
        locationList.add(new Location("Main Building"));
        locationList.add(new Location("Strong House"));
        locationList.add(new Location("Raymond House"));
        locationList.add(new Location("Davison House"));
        locationList.add(new Location("Lathrop House"));
        locationList.add(new Location("Jewett House"));
        locationList.add(new Location("Josselyn House"));
        locationList.add(new Location("Cushing House"));
        locationList.add(new Location("Noyes House"));
        locationList.add(new Location("ALANA Intercultural Center"));
        locationList.add(new Location("Alumnae House"));
        locationList.add(new Location("Athletic and Fitness Center"));
        locationList.add(new Location("Blodgett Hall"));
        locationList.add(new Location("Bridge for Laboratory Sciences"));
        locationList.add(new Location("Vogelstein Center"));
        locationList.add(new Location("Chapel"));
        locationList.add(new Location("Class of 1951 Observatory"));
        locationList.add(new Location("College Center"));
        locationList.add(new Location("Ely Hall/Aula"));
        locationList.add(new Location("Ferry House"));
        locationList.add(new Location("Kenyon Hall"));
        locationList.add(new Location("Maria Mitchell Observatory"));
        locationList.add(new Location("New England"));
        locationList.add(new Location("Olmsted Hall"));
        locationList.add(new Location("President's House"));
        locationList.add(new Location("Rockefeller Hall"));
        locationList.add(new Location("Sanders Classroom"));
        locationList.add(new Location("Skinner Hall of Music"));
        locationList.add(new Location("Susan Stein Shiva Theater"));
        locationList.add(new Location("Swift Hall"));
        locationList.add(new Location("Terrace Apartments"));
        locationList.add(new Location("The Gordon Commons"));
        locationList.add(new Location("Main Library"));
        locationList.add(new Location ("Town Houses"));
        locationList.add(new Location("Walker Field House"));
        locationList.add(new Location("Weinberg Field Sports Pavilion"));
    }
}

