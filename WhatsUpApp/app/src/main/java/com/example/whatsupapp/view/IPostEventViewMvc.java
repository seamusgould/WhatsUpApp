package com.example.whatsupapp.view;

import android.view.View;

import com.example.whatsupapp.model.Event;
import com.example.whatsupapp.model.EventCollection;
import com.example.whatsupapp.model.Location;

import java.util.ArrayList;
import java.util.Calendar;


public interface IPostEventViewMvc {

    public interface Listener{
        EventCollection onAddedEvent(String eventName, String eventDateAndTime,
                                     String eventRoughLocation, String eventPoster, String eventDescription);

        ArrayList<Location> getLocationList();
        ArrayList<Event> getEvents();
        void onItemClick(View view, int position);
        void onPostButton();
        void onDateButton(String eventDate);
        void onAddedButton();
        void onCommentAdded();

        void onTimeButton(String eventDateAndTime);

        void onRecurrenceButton(Calendar eventDate);

        void onTimeButtonRecurrence(Calendar eventDate, String howOften, String howMany, String howManySkipped);
    }

    public View getRootView();

    public void updateDisplay(EventCollection eventCollection);
}
