package com.example.whatsupapp.model;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class User implements Serializable {
    String username;

    public User(String username) {
        this.username = username;
    }



    public User() {}


    public void upvote(Event e)
    {
        e.upvoteDownvote = e.upvoteDownvote++;
    }

    public void downvote(Event e) {e.upvoteDownvote = e.upvoteDownvote--;}

    @Override
    @NonNull
    public String toString(){
        return String.format(this.username);
    }
}
