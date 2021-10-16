import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {

    public static Calendar isValidDateAndTime(String eDateAndTime){
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyy HH:mm");
        format.setLenient(false);

        Calendar calendar1 = Calendar.getInstance();
        try {
            calendar1.setTime(format.parse(eDateAndTime));
            return calendar1;
        } catch (ParseException e)
        {
            System.out.println("Invalid Date and/or Time. Please type a valid date and 24-hour time in the form " + format.toPattern());
            return null;
        }

    }


    public static void main(String[] args) {
        Controller controller = new Controller();
        Scanner myObj = new Scanner(System.in);

        controller.addStandardLocations();

        //when we actually log in, we won't need this
        System.out.println("What is your name?");
        String posterUsername = myObj.nextLine();
        User poster = new User(posterUsername);

        //call toString, display event collection
        System.out.println(controller.getEventCollection());

        while (true) {
            System.out.println("If you would like to post, please enter 'post'");
            String response = myObj.nextLine();
            while (controller.isResponsePost(response))
                {
                    System.out.println("What is the name of your event?");
                    String eName = myObj.nextLine();


                    Calendar eDateAndTimes = null;
                    do{
                        System.out.println("What is the date and time of your event? Please enter it in 24-hour time in the format MM/dd/yyyy HH:mm a");
                        String eDateAndTime = myObj.nextLine();
                        eDateAndTimes = isValidDateAndTime(eDateAndTime);
                    } while (eDateAndTimes == null);

                    System.out.println("What is the description of your event?");
                    String eDescription = myObj.nextLine();
                    System.out.println("Where will the event take place? Please choose from the list below or enter your own.");

                    System.out.println(controller.getLocationList());
                    String eLocation = myObj.nextLine();

                    controller.makeEvent(eName, eDateAndTimes, 0,eDescription, poster, eLocation);
                    System.out.println(controller.getEventCollection());
                    System.out.println("If you would like to post, please enter 'post'");
                    response = myObj.nextLine();
                }
        }
    }
}