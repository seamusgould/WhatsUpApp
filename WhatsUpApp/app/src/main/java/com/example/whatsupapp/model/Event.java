package com.example.whatsupapp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Event implements Serializable {
    //need getter for each object I want to display
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
    List<Calendar> allDatesAndTimes = new ArrayList<Calendar>();
    List<String> comments = new ArrayList<String>();

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

    public Event() {}

    public void addNewDateAndTime(Calendar c){
        allDatesAndTimes.add(c);
    }

    public List<Calendar> getAllDatesAndTimes(){
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

    public List<String> getComments() {
        return this.comments;
    }

    public User getUser(){
        return this.poster;
    }
}
