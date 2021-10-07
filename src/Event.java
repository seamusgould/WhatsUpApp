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
    public String finalstring = "";

    Event (String name, Date date, Time time, int recurrence, String description, User poster, String roughLocation)
    {
        this.eventName = name;
        this.eventDate = date;
        this.eventTime = time;
        this.eventRecurrence = recurrence;
        this.eventPoster = poster;
        this.eventRoughLocation = roughLocation;
        this.eventDescription = description;
    }

    public String toString()
    {
        finalstring += new String(new char[20]).replace("\0", "-");
        finalstring += "\n";
        finalstring += "" + name;
        finalstring += new String(new char[20]).replace("\0", "-");
        return finalstring;
    }

}
