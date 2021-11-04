package com.example.whatsupapp.model;

public class Location {
    private String roughLocation;

    Location (String roughLocation){
        this.roughLocation = roughLocation;
        }

    public String toString() {
        return roughLocation + "\n";
    }
}


