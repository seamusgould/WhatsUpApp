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
    String id;

    //constructor without recurrence
    /*Event (String name, String date, String time ,
           String description, String eventPoster, String eLocation){
        this.eventName = name;
        this.eventTime = time;
        this.eventDate = date;
        this.eventPoster = eventPoster;
        this.eventLocation =  eLocation;
        this.eventDescription = description;
    }*/

    //Calendar constructor
    public Event(String name, Calendar eventDateAndTime,
                 String description, String poster, String eLocation){
        this.eventName = name;
        this.originalEventDateAndTime = eventDateAndTime;
        this.eventPoster = poster;
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

//    public User getUser(){
//        return this.poster;
//    }
    public String getEventPoster() {
        return this.eventPoster;
    }

    public String getEventName() {
        return this.eventName;
    }

    public String getEventTime() {
        return this.eventTime;
    }

    public String getEventDate() {
        return this.eventDate;
    }

    public String getEventLocation() {
        return this.eventLocation;
    }

    public String getEventDescription(){
        return this.eventDescription;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
