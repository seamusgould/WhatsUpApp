import java.sql.Time;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        System.out.println("Print Out the toString");
        Date dummyDate = new Date(2020, 9, 15, 18, 0);
        Time dummyTime = new Time(18, 00, 00);
        User dummyUser = new User("dummyPoster");
        Event dummyEvent = new Event
                ("EPIC 10000 PARTY", dummyDate, dummyTime, 0, "Family friendly fun.  Bring the entire squad.", dummyUser, "ths");
        System.out.println(dummyEvent);
    }
}
