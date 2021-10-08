import java.sql.Time;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        EventCollection ll = new EventCollection();
        Date dummyDate = new Date(2020, 9, 15, 18, 0);
        Time dummyTime = new Time(18, 00, 00);
        User dummyUser = new User("USER3141");
        Event dummyEvent = new Event
                ("Chess tournament", dummyDate, dummyTime, 0,
                        "There will be coffee, tea, and biscuits",
                        dummyUser, "ths");
        /*System.out.println(dummyEvent);*/
        Date dummyDate1 = new Date(2020, 9, 16, 18, 0);
        Time dummyTime1 = new Time(17, 00, 00);
        User dummyUser1 = new User("USER3142");
        Event dummyEvent1 = new Event
                ("Pickup soccer game", dummyDate1, dummyTime1, 0,
                        "There will be apickup up soccer game.  Bring your own cleats and shinguards!",
                        dummyUser1, "library lawn");
        /*System.out.println(dummyEvent);*/

        /*
         * I will print out the Collection of Events for the viewer.
         */

        System.out.println("These are the events");
        ll.include(dummyEvent);
        ll.include(dummyEvent1);
        System.out.println(ll);
        System.out.println("This completes the test"); /* This will print out all events.*/
    }
}