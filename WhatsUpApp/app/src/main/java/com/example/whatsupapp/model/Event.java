package com.example.whatsupapp.model;

import java.util.ArrayList;

public class Event {
    int upvoteDownvote = 0;
    String eventName;
    String eventDate;
    String eventTime;
    int eventRecurrence;
    String eventDescription;
    String eventPoster;
    String eventLocation;
    String name;
    ArrayList<String> comments = new ArrayList<String>();

    Event (String name, String date, String time , int recurrence,
           String description, String poster, String eLocation){
        this.eventName = name;
        this.eventTime = time;
        this.eventDate = date;
        this.eventRecurrence = recurrence;
        this.eventPoster = poster;
        this.eventLocation =  eLocation;
        this.eventDescription = description;
    }

    //constructor without recurrence
    Event (String name, String date, String time ,
           String description, String poster, String eLocation){
        this.eventName = name;
        this.eventTime = time;
        this.eventDate = date;
        this.eventPoster = poster;
        this.eventLocation =  eLocation;
        this.eventDescription = description;
    }

    @Override
    public String toString(){
        String str = "";
        String score = Integer.toString(upvoteDownvote);
        str += eventPoster +" posted: \n";
        str += " On " + eventDate + " " + eventTime + " " + eventName + " at " + eventLocation;
        str += "\n " + eventDescription;
        return str;
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
