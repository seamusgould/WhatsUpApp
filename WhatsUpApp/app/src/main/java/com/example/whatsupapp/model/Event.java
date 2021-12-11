package com.example.whatsupapp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Event implements Serializable {
    //need getter for each object I want to display
    int upvoteDownvote = 0;
    String eventName;
    //Calendar originalEventDateAndTime;
    String eventDateAndTime;
    int eventRecurrence;
    String eventDescription;
    String eventPoster;
    User poster;
    String eventLocation;
    String name;
    List<String> allDatesAndTimes = new ArrayList<String>();
    List<String> comments = new ArrayList<String>();
    String id;

    //constructor without recurrence
    Event (String name, String eventDateAndTime ,
           String description, String eventPoster, String eLocation){
        this.eventName = name;
        this.eventDateAndTime = eventDateAndTime;
        this.eventPoster = eventPoster;
        this.eventLocation =  eLocation;
        this.eventDescription = description;
        this.addNewDateAndTime(eventDateAndTime);
    }

    //Calendar constructor
    /*public Event(String name, Calendar eventDateAndTime,
                 String description, String poster, String eLocation){
        this.eventName = name;
        this.originalEventDateAndTime = eventDateAndTime;
        this.eventPoster = poster;
        this.eventLocation =  eLocation;
        this.eventDescription = description;
        addNewDateAndTime(eventDateAndTime);
    }*/

    public Event() {}

    public void addNewDateAndTime(String c){
        allDatesAndTimes.add(c);
    }

    public List<String> getAllDatesAndTimes(){
        return allDatesAndTimes;
    }

    @Override
    public String toString(){
        /*Calendar curDateAndTime = allDatesAndTimes.get(0);
        String dateString = curDateAndTime.get(Calendar.MONTH) + "/" + curDateAndTime.get(Calendar.DATE) + "/" + curDateAndTime.get(Calendar.YEAR);
        String timeString = curDateAndTime.get(Calendar.HOUR) + ":" + curDateAndTime.get(Calendar.MINUTE);*/
        String str = "";
        String score = Integer.toString(upvoteDownvote);
        str += eventPoster +" posted: \n";
        str += " On " + eventDateAndTime + " " + eventName + " at " + eventLocation;
        str += "\n " + eventDescription;
        return str;
        }

     public String toStringExtended(){
        String str = "";
        String score = Integer.toString(upvoteDownvote);
        str += eventPoster + " posted: \n";
        str += eventName + " at " + eventLocation + "\n";
        for (int i = 0; i < getAllDatesAndTimes().size(); i++){
            str += getAllDatesAndTimes().get(i) + " \n";
        }

        str += eventDescription;
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

    public String getEventDateAndTime() {
        return this.eventDateAndTime;
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
