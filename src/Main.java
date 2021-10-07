import java.sql.Time;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Date dummyDate = new Date(2020, 9, 15, 18, 0);
        Time dummyTime = new Time(18, 00, 00);
        User dummyUser = new User("dummyPoster");
        Event dummyEvent = new Event
                ("EPIC 100 PARTY", dummyDate, dummyTime, 0, "Amazing party with like fifteen pounds of crack i need to smoke immediately", dummyUser, "town houses");
        System.out.println(dummyEvent);
    }

}
