package com.example.classapp;

import com.example.classapp.Event;

public class User {
    String username;

    User (String name){
        this.username = name;
    }

    public void upvote(Event e)
    {
        e.upvoteDownvote = e.upvoteDownvote++;
    }

    public void downvote(Event e) {e.upvoteDownvote = e.upvoteDownvote--;}

}
