package com.example.whatsupapp.model;

import java.util.ArrayList;

public class Location {
    private String roughLocation;

    Location(String roughLocation){
        this.roughLocation = roughLocation;
        }

    public String toString() {
        return roughLocation;
    }


//static method to populate the location

    public static ArrayList<Location> getLocationList() {
        ArrayList<Location> locationList = new ArrayList<>();
        locationList.add(new Location("Main Building"));
        locationList.add(new Location("Strong House"));
        locationList.add(new Location("Raymond House"));
        locationList.add(new Location("Davison House"));
        locationList.add(new Location("Lathrop House"));
        locationList.add(new Location("Jewett House"));
        locationList.add(new Location("Josselyn House"));
        locationList.add(new Location("Cushing House"));
        locationList.add(new Location("Noyes House"));
        locationList.add(new Location("ALANA Intercultural Center"));
        locationList.add(new Location("Alumnae House"));
        locationList.add(new Location("Athletic and Fitness Center"));
        locationList.add(new Location("Blodgett Hall"));
        locationList.add(new Location("Bridge for Laboratory Sciences"));
        locationList.add(new Location("Vogelstein Center"));
        locationList.add(new Location("Chapel"));
        locationList.add(new Location("Class of 1951 Observatory"));
        locationList.add(new Location("College Center"));
        locationList.add(new Location("Ely Hall/Aula"));
        locationList.add(new Location("Ferry House"));
        locationList.add(new Location("Kenyon Hall"));
        locationList.add(new Location("Maria Mitchell Observatory"));
        locationList.add(new Location("New England"));
        locationList.add(new Location("Olmsted Hall"));
        locationList.add(new Location("President's House"));
        locationList.add(new Location("Rockefeller Hall"));
        locationList.add(new Location("Sanders Classroom"));
        locationList.add(new Location("Skinner Hall of Music"));
        locationList.add(new Location("Susan Stein Shiva Theater"));
        locationList.add(new Location("Swift Hall"));
        locationList.add(new Location("Terrace Apartments"));
        locationList.add(new Location("The Gordon Commons"));
        locationList.add(new Location("Main Library"));
        locationList.add(new Location("Town Houses"));
        locationList.add(new Location("Walker Field House"));
        locationList.add(new Location("Weinberg Field Sports Pavilion"));
        return locationList;
    }
}
