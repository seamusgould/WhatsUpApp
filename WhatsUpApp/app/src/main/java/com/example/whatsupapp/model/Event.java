package com.example.whatsupapp.model;

import java.util.ArrayList;
import java.util.Calendar;

public class Event {
    int upvoteDownvote = 0;
    String eventName;
    Calendar originalEventDateAndTime;
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
