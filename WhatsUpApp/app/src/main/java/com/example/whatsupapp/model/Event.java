package com.example.whatsupapp.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Event {
    int upvoteDownvote = 0;
    String eventName;
    Calendar originalEventDateAndTime = Calendar.getInstance();
    String eventDate;
    String eventTime;
    int eventRecurrence;
    String eventDescription;
    String eventPoster;
    User poster;
    String eventLocation;
    String name;
    ArrayList<Calendar> allDatesAndTimes = new ArrayList<Calendar>();
    ArrayList<String> comments = new ArrayList<String>();

    //constructor without recurrence, all strings
    Event (String name, String date, String time ,
           String description, String poster, String eLocation) {

        String combinedDateAndTimeString = (date + " " + time);

        SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy HH:mm");

        try {
            Date parsedDate = sdf1.parse(combinedDateAndTimeString);
            this.originalEventDateAndTime.setTime(parsedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        this.originalEventDateAndTime.get(Calendar.DATE);
        System.out.println(this.originalEventDateAndTime);

        this.eventName = name;
        this.eventTime = time;
        this.eventDate = date;
        this.eventPoster = poster;
        this.eventLocation =  eLocation;
        this.eventDescription = description;
    }

    public Event(String name, Calendar eventDateAndTime,
                 String description, User poster, String eLocation){
        this.eventName = name;
        this.originalEventDateAndTime = eventDateAndTime;
        this.poster = poster;
        this.eventLocation =  eLocation;
        this.eventDescription = description;
        addNewDateAndTime(eventDateAndTime);
    }

    public void addNewDateAndTime(Calendar c){
        allDatesAndTimes.add(c);
    }

    public ArrayList<Calendar> getAllDatesAndTimes(){
        return allDatesAndTimes;
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

    public ArrayList<String> getComments() {
        return this.comments;
    }

    public User getUser(){
        return this.poster;
    }
}
