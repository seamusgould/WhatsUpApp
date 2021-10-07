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

    Event (String name, Date date, Time time, int recurrence, String description, User poster, String roughLocation)
    {
        this.eventName = name;
        this.eventDate = date;
        this.eventTime = time;
        this.eventRecurrence = recurrence;
        this.eventPoster = poster;
        this.eventRoughLocation = roughLocation;
    }

    public String toString()
    {
        String finalString = eventName + eventDate.toString();
        return finalString;
    }

}
