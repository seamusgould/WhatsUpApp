package com.example.whatsupapp.model;

public class User {
    String username;

    public User(String name){
        this.username = name;
    }

    //public void upvote(Event e){
      //  int x = 0;
    //}

    public void upvote(Event e)
    {
        e.upvoteDownvote = e.upvoteDownvote++;
    }

    public void downvote(Event e) {e.upvoteDownvote = e.upvoteDownvote--;}

    public String toiString(){
        return username;
    }
}
