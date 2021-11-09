package com.example.whatsupapp.model;

import java.util.ArrayList;

public class Event {
    int upvoteDownvote = 0;
    String eventName;
    String eventDateAndTime;
    int eventRecurrence;
    String eventDescription;
    String eventPoster;
    String eventLocation;
    String name;
    String s = "";
    ArrayList<String> comments = new ArrayList<String>();

    Event (String name, String eDateAndTime, int recurrence, String description, String poster, String eLocation){
        this.eventName = name;
        //separate date and time 
        this.eventDateAndTime = eDateAndTime;
        this.eventRecurrence = recurrence;
        this.eventPoster = poster;
        this.eventLocation =  eLocation;
        this.eventDescription = description;
    }

    public String toString(){
        String score = Integer.toString(upvoteDownvote);
        s += eventPoster +" posted: \n";
        s += " On " + eventDateAndTime + " " + eventName + " at " + eventLocation;
        s += "\n " + eventDescription;
        return s;
        //String finalString2 = String.format("\n%d%s %t at %t posted by %s \n")
//        s = "\n";
//        s += score + "|";
//        s += eventName + " " + eventDateAndTime + " at " + eventLocation;
//        //finalString += eventName + " " + eventDateAndTime.getTime() + " at " + eventLocation;
//        s += new String(new char[score.length()]).replace("\0", " ") + "|" + " posted by " +  eventPoster; //.username;
//        s += "\n";
//        s += new String(new char[score.length()]).replace("\0", " ") + "|";
//        s += new String(new char[40 - score.length()]).replace("\0", "=");
//        s += "\n";
//        s += new String(new char[score.length()]).replace("\0", " ") + "|";
//        s += eventDescription;
//        s += "\n";
//        s += new String(new char[score.length()]).replace("\0", " ") + "|";
//        s += new String(new char[40 - score.length()]).replace("\0", "=");
//
//        for (String s : comments) {
//            this.s += new String(new char[40 - score.length()]).replace("\0", "-");
//            this.s += "\n";
//            this.s += new String(new char[score.length()]).replace("\0", " ") + "|";
//            this.s += s + "posted by " + eventPoster;//.username;
//            this.s += "\n";
//            this.s += new String(new char[score.length()]).replace("\0", " ") + "|";
//            this.s += new String(new char[40 - score.length()]).replace("\0", "-");
        }



    public void addComment(String s){
        comments.add(s);
    }
}
