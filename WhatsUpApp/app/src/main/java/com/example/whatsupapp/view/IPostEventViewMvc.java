package com.example.whatsupapp.view;

import android.view.View;

import com.example.whatsupapp.model.Event;
import com.example.whatsupapp.model.EventCollection;
import com.example.whatsupapp.model.Location;

import java.util.ArrayList;


public interface IPostEventViewMvc {

    public interface Listener{
        EventCollection onAddedEvent(String eventName, String eventDateAndTime, String time,
                                     String eventRoughLocation, String eventPoster, String eventDescription);

        ArrayList<Location> getLocationList();
        ArrayList<Event> getEvents();
        void onItemClick(View view, int position);
        void onPostButton();
        void onDateButton();
        void onAddedButton();
        void onCommentAdded();

    }

    public View getRootView();

    public void updateDisplay(EventCollection eventCollection);
}
