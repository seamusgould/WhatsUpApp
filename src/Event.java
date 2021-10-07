import java.sql.Time;
import java.util.Date;

public class Event
{
    int upvoteDownvote = 0;
    String eventName;
    Date eventDate;
    Time eventTime;
    int eventRecurrence;
    String eventDescription;
    User eventPoster = new User("The Big C");
    String eventRoughLocation;
    String name;
    String finalstring = "";
    EventCollection listo = new EventCollection();


    Event (String name, Date date, Time time, int recurrence, String description, User poster, String roughLocation){
        this.eventName = name;
        this.eventDate = date;
        this.eventTime = time;
        this.eventRecurrence = recurrence;
        this.eventPoster = poster;
        this.eventRoughLocation = roughLocation;
        this.eventDescription = description;
    }

    public String toString(){
        String score = Integer.toString(upvoteDownvote);
        finalstring = "\n";
        finalstring += score + "|";
        finalstring += eventName + " " + eventDate + " at " + eventTime + " posted by " +  eventPoster.username;
        finalstring += "\n";
        finalstring += new String(new char[score.length()]).replace("\0", " ") + "|";
        finalstring += new String(new char[100 - score.length()]).replace("\0", "=");
        finalstring += "\n";
        finalstring += new String(new char[score.length()]).replace("\0", " ") + "|";
        finalstring += eventDescription;
        finalstring += "\n";
        finalstring += new String(new char[score.length()]).replace("\0", " ") + "|";
        finalstring += new String(new char[100 - score.length()]).replace("\0", "=");
        return finalstring;
    }

    public void store(Event e){
        
    }
}
