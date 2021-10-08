import java.sql.Time;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Date dummyDate = new Date(2020, 9, 15, 18, 0);
        Time dummyTime = new Time(18, 00, 00);
        User dummyUser = new User("USER3141");
        Event dummyEvent = new Event
                ("Chess tournament", dummyDate, dummyTime, 0,
                        "There will be coffee, tea, and biscuits",
                        dummyUser, "ths");
        EventCollection ll = new EventCollection();
        /*System.out.println(dummyEvent);

        /*if view events
        I will print out the Collection of Events
         */

        System.out.println("These are the events");
        ll.include(dummyEvent);
        System.out.println(ll);
        System.out.println("This completes the test"); /* This will print out all events.*/
    }
}