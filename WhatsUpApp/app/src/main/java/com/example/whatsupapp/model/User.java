package com.example.whatsupapp.model;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class User implements Serializable {
    String username;
    private AuthKey authKey;

    public User(String username) {
        this.username = username;
    }

    public User(String username, String password){
        this.username = username;
        this.authKey = new AuthKey(password);
    }

    public User() {}

    public String getUsername(){ return this.username; }
    public AuthKey getAuthKey(){ return this.authKey; }

    public boolean validatePassword(String password){
        return this.authKey.validatePassword(password);
    }

    public void upvote(Event e)
    {
        e.upvoteDownvote = e.upvoteDownvote++;
    }

    public void downvote(Event e) {e.upvoteDownvote = e.upvoteDownvote--;}

    @Override
    @NonNull
    public String toString(){
        return String.format("User %s, authKey: %s", this.username, this.authKey.toString());
    }
}
