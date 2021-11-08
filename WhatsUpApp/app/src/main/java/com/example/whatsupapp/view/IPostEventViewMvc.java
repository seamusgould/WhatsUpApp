package com.example.whatsupapp.view;

import android.view.View;

import com.example.whatsupapp.model.EventCollection;
import com.example.whatsupapp.model.Location;
import com.example.whatsupapp.model.User;

import java.util.ArrayList;
import java.util.Calendar;


public interface IPostEventViewMvc {

    public interface Listener{
        void onAddedEvent(String eventName, String eventDateAndTime, String time, String eventRoughLocation, String eventDescription);

        ArrayList<Location> getLocationList();
    }

    public View getRootView();

    public void updateDisplay(EventCollection eventCollection);
}
