package com.example.whatsupapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.example.whatsupapp.databinding.ActivityMainBinding;
import com.example.whatsupapp.model.EventCollection;
import com.example.whatsupapp.model.Location;
import com.example.whatsupapp.model.User;
import com.example.whatsupapp.view.IPostEventViewMvc;
import com.example.whatsupapp.view.PostEventViewMvc;
import com.example.whatsupapp.model.Event;

import com.example.whatsupapp.*;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements IPostEventViewMvc.Listener{

    private IPostEventViewMvc addedEvent;
    private EventCollection eventCollection;
    private ArrayList<Location>locationList = Location.getLocationList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.eventCollection = new EventCollection();
        this.addedEvent = new PostEventViewMvc(getApplicationContext(), this);
        setContentView(this.addedEvent.getRootView());

    }

    @Override
    public void onAddedEvent(String eventName, String eventDate, String eventTime,
                             String eventRoughLocation, String eventDescription) {
        Log.d("NextGenPos", "controller is handling line item addition");
        this.eventCollection.makeEvent(eventName, eventDate, eventTime, eventRoughLocation, eventDescription);
        this.addedEvent.updateDisplay(this.eventCollection);
    }

    @Override
    public ArrayList<Location> getLocationList() {
        return locationList;
    }
}