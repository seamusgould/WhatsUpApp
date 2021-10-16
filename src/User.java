import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.time.LocalTime;
import java.text.SimpleDateFormat;

public class User {
    String username;

    User (String name){
        this.username = name;
    }

<<<<<<< HEAD
    public void upvote(Event e){
        int x = 0;
    }
=======
    public void upvote(Event e)
    {
        e.upvoteDownvote = e.upvoteDownvote++;
    }

    public void downvote(Event e) {e.upvoteDownvote = e.upvoteDownvote--;}


>>>>>>> Create_Controller
}
