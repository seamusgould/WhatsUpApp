package com.example.whatsupapp.view;

import android.view.View;

import com.example.whatsupapp.model.Event;
import com.example.whatsupapp.model.EventCollection;
import com.example.whatsupapp.model.Location;

import java.util.ArrayList;
import java.util.Calendar;


public interface IPostEventViewMvc {

    public interface Listener{
        EventCollection onAddedEvent(String eventName, String eventDateAndTime, String time,
                                     String eventRoughLocation, String eventPoster, String eventDescription);

        ArrayList<Location> getLocationList();
        ArrayList<Event> getEvents();
        void onItemClick(View view, int position);
        void onPostButton();
        void onDateButton(Calendar eventDate);
        void onAddedButton();
        void onCommentAdded();

        void onTimeButton();
    }

    public View getRootView();

    public void updateDisplay(EventCollection eventCollection);
}
