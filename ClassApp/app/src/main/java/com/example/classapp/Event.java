package com.example.classapp;

import java.util.ArrayList;
import java.util.Calendar;

public class Event {
    int upvoteDownvote = 0;
    String eventName;
    Calendar eventDateAndTime;
    int eventRecurrence;
    String eventDescription;
    User eventPoster;
    Location eventLocation;
    String name;
    String finalString = "";
    ArrayList<String> comments = new ArrayList<String>();

    Event (String name, Calendar eDateAndTime, int recurrence, String description, User poster, Location eLocation){
        this.eventName = name;
        this.eventDateAndTime = eDateAndTime;
        this.eventRecurrence = recurrence;
        this.eventPoster = poster;
        this.eventLocation =  eLocation;
        this.eventDescription = description;
    }

    public String toString(){
        String score = Integer.toString(upvoteDownvote);
        //String finalString2 = String.format("\n%d%s %t at %t posted by %s \n")
        finalString = "\n";
        finalString += score + "|";
        finalString += eventName + " " + eventDateAndTime.getTime() + " at " + eventLocation;
        finalString += new String(new char[score.length()]).replace("\0", " ") + "|" + " posted by " +  eventPoster.username;
        finalString += "\n";
        finalString += new String(new char[score.length()]).replace("\0", " ") + "|";
        finalString += new String(new char[100 - score.length()]).replace("\0", "=");
        finalString += "\n";
        finalString += new String(new char[score.length()]).replace("\0", " ") + "|";
        finalString += eventDescription;
        finalString += "\n";
        finalString += new String(new char[score.length()]).replace("\0", " ") + "|";
        finalString += new String(new char[100 - score.length()]).replace("\0", "=");

        for (String s : comments) {
            finalString += new String(new char[100 - score.length()]).replace("\0", "-");
            finalString += "\n";
            finalString += new String(new char[score.length()]).replace("\0", " ") + "|";
            finalString += s + "posted by " + eventPoster.username;
            finalString += "\n";
            finalString += new String(new char[score.length()]).replace("\0", " ") + "|";
            finalString += new String(new char[100 - score.length()]).replace("\0", "-");
        }
        return finalString;
    }

    public void addComment(String s){
        comments.add(s);
    }
}
