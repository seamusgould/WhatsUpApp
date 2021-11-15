package com.example.whatsupapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.example.whatsupapp.databinding.ActivityMainBinding;
import com.example.whatsupapp.model.EventCollection;
import com.example.whatsupapp.model.Location;
import com.example.whatsupapp.model.User;
import com.example.whatsupapp.view.HomeFragment;
import com.example.whatsupapp.view.IHomeFragmentView;
import com.example.whatsupapp.view.IMainView;
import com.example.whatsupapp.view.IPostEventViewMvc;
import com.example.whatsupapp.view.MainView;
import com.example.whatsupapp.view.MapFragment;
import com.example.whatsupapp.view.PostEventFragment;
import com.example.whatsupapp.view.PostEventViewMvc;
import com.example.whatsupapp.model.Event;

import com.example.whatsupapp.*;
import com.example.whatsupapp.view.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Calendar;

public class ControllerActivity extends AppCompatActivity implements IPostEventViewMvc.Listener, IHomeFragmentView.Listener {

    private EventCollection eventCollection;
    private ArrayList<Location>locationList = Location.getLocationList();
    private BottomNavigationView bottomNavigationView;
    private IMainView mainView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.eventCollection = new EventCollection();
        this.mainView = new MainView(this);
        setContentView(mainView.getRootView());
        onHomeSelected();
    }

    @Override
    public void onPostButton() {
        this.mainView.displayFragment(new PostEventFragment(this));
    }

    @Override
    public void onAddedEvent(String eventName, String eventDate, String eventTime,
                             String eventRoughLocation, String eventDescription) {
        Log.d("NextGenPos", "controller is handling line item addition");
        this.eventCollection.makeEvent(eventName, eventDate, eventTime, eventRoughLocation, eventDescription);
      //  this.addedEvent.updateDisplay(this.eventCollection);
    }

    @Override
    public ArrayList<Location> getLocationList() {
        return locationList;
    }

    public void onMapSelected(){
        this.mainView.displayFragment(new MapFragment());
    }
    public void onHomeSelected(){
        this.mainView.displayFragment(new HomeFragment(this));
    }
    public void onProfileSelected(){
        this.mainView.displayFragment(new ProfileFragment());
    }

}