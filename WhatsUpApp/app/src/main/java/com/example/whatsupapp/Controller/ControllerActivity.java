package com.example.whatsupapp.Controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.whatsupapp.model.Event;
import com.example.whatsupapp.model.EventCollection;
import com.example.whatsupapp.model.Location;
import com.example.whatsupapp.view.HomeFragment;
import com.example.whatsupapp.view.IHomeFragmentView;
import com.example.whatsupapp.view.IMainView;
import com.example.whatsupapp.view.IPostEventViewMvc;
import com.example.whatsupapp.view.MainView;
import com.example.whatsupapp.view.MapsFragment;
import com.example.whatsupapp.view.PostEventFragment;

import com.example.whatsupapp.view.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class ControllerActivity extends AppCompatActivity implements IPostEventViewMvc.Listener,
        IHomeFragmentView.Listener {

    private EventCollection eventCollection;
    private ArrayList<Location>locationList = Location.getLocationList();
    private BottomNavigationView bottomNavigationView;
    private IMainView mainView;
    private static final String EVENT_COL = "eventCol";

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putSerializable(EVENT_COL, this.eventCollection);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null)
            this.eventCollection = new EventCollection();
        else {
            this.eventCollection = (EventCollection) savedInstanceState.getSerializable(EVENT_COL);
            assert this.eventCollection != null;
        }
        this.mainView = new MainView(this);
        setContentView(mainView.getRootView());
        onHomeSelected();
    }

    @Override
    public ArrayList<Event> getEvents() {
        return eventCollection.getEventCollection();
    }

    @Override
    public void onItemClick(View view, int position) {

    }


    @Override
    public void onPostButton() {
        this.mainView.displayFragment(new PostEventFragment(this));
    }

    @Override
    public void onAddedButton() {
        this.mainView.displayFragment(new HomeFragment(this));
    }

    @Override
    public void onCommentAdded() {

    }

    @Override
    public EventCollection onAddedEvent(String eventName, String eventDate, String eventTime,
                                        String eventRoughLocation, String eventDescription) {
        Log.d("NextGenPos", "controller is handling line item addition");
        eventCollection.makeEvent(eventName, eventDate, eventTime, eventRoughLocation,
                eventDescription);
        return eventCollection;
    }

    @Override
    public ArrayList<Location> getLocationList() {
        return locationList;
    }

    public void onMapSelected(){
        this.mainView.displayFragment(new MapsFragment());
    }
    public void onHomeSelected(){
        this.mainView.displayFragment(new HomeFragment(this));
    }
    public void onProfileSelected(){
        this.mainView.displayFragment(new ProfileFragment());}
}