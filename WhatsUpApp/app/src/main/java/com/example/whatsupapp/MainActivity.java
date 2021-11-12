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
import com.example.whatsupapp.view.IPostEventViewMvc;
import com.example.whatsupapp.view.MainView;
import com.example.whatsupapp.view.MapFragment;
import com.example.whatsupapp.view.PostEventViewMvc;
import com.example.whatsupapp.model.Event;

import com.example.whatsupapp.*;
import com.example.whatsupapp.view.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements IPostEventViewMvc.Listener{

    private IPostEventViewMvc addedEvent;
    private EventCollection eventCollection;
    private ArrayList<Location>locationList = Location.getLocationList();
    private BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.eventCollection = new EventCollection();
        //this.addedEvent = new PostEventViewMvc(getApplicationContext(), this);

        MainView mainView = new MainView(this);
        setContentView(mainView.getRootView());

/*        bottomNavigationView = findViewById(R.id.bottomNav);

        bottomNavigationView.setOnNavigationItemSelectedListener(bottomNavMethod);
        */
        //getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment())
          //      .commit();

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

    private BottomNavigationView.OnNavigationItemSelectedListener bottomNavMethod =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                    Fragment fragment = null;
                    switch (menuItem.getItemId()) {
                        case R.id.map:
                            fragment = new MapFragment();
                            break;
                        case R.id.home:
                            fragment = new HomeFragment();
                            break;
                        case R.id.profile:
                            fragment = new ProfileFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment)
                            .commit();
                    return true;
                }

            };
}