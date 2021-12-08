package com.example.whatsupapp.Controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;

import com.example.whatsupapp.model.Event;
import com.example.whatsupapp.model.EventCollection;
import com.example.whatsupapp.model.User;
import com.example.whatsupapp.view.EventFragment;
import com.example.whatsupapp.view.IAuthView;
import com.example.whatsupapp.model.Location;
import com.example.whatsupapp.model.Username;
import com.example.whatsupapp.persistence.FirestoreFacade;
import com.example.whatsupapp.persistence.IPersistenceFacade;
import com.example.whatsupapp.view.AuthFragment;
import com.example.whatsupapp.view.HomeFragment;
import com.example.whatsupapp.view.IEventCollectionView;
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
        IHomeFragmentView.Listener, IAuthView.Listener, IEventCollectionView.Listener{

    private EventCollection eventCollection;
    private ArrayList<Location> locationList = Location.getLocationList();
    private BottomNavigationView bottomNavigationView;
    private IMainView mainView;
    private static final String CUR_EVENT = "curEvent";
    private static final String CUR_USER = "curUser";
    private final IPersistenceFacade persistenceFacade = new FirestoreFacade();
    private User curUser;
    private Event curEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.mainView = new MainView(this);
        setContentView(mainView.getRootView());

        this.eventCollection = new EventCollection();

        this.persistenceFacade.retrieveEventCollection(new IPersistenceFacade.DataListener<EventCollection>() {
            @Override
            public void onDataReceived(@NonNull EventCollection eventCollection) {
                ControllerActivity.this.eventCollection = eventCollection; // set the activity's eventcollect to the one retrieved from the database

                Fragment curFrag = ControllerActivity.this.mainView.getCurrentFragment();
                if (curFrag instanceof IEventCollectionView)
                    ((IEventCollectionView) curFrag).onEventCollectionUpdated(eventCollection);
            }

            @Override
            public void onNoDataFound() { } // if no ledger found, do nothing - just start from
        });

        if (savedInstanceState != null) {
            this.curUser = (User) savedInstanceState.getSerializable(CUR_USER);
            this.curEvent = (Event) savedInstanceState.getSerializable(CUR_EVENT);
        }
        else {
            this.curEvent = new Event();
            this.mainView.displayFragment(new AuthFragment(this));
        }

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putSerializable(CUR_EVENT, this.curEvent);
        outState.putSerializable(CUR_USER, this.curUser);
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
        this.mainView.displayFragment(new HomeFragment(this));
    }

    @Override
    public EventCollection onAddedEvent(String eventName, String eventDate, String eventTime,
                                        String eventRoughLocation, String eventDescription) {
        Event newEvent = eventCollection.makeEvent(eventName, eventDate, eventTime, eventRoughLocation,
                eventDescription);
        curEvent = newEvent;
        this.persistenceFacade.saveEvent(this.curEvent); // save event to database

        return eventCollection;
    }

    @Override
    public ArrayList<Location> getLocationList() {
        return locationList;
    }

    public void onMapSelected() {
        this.mainView.displayFragment(new MapsFragment());
    }

    public void onHomeSelected() {
        this.mainView.displayFragment(new HomeFragment(this));
    }

    public void onProfileSelected() {
        this.mainView.displayFragment(new ProfileFragment());
    }

    /* IAuthView.Listener realization start */
    @Override
    public void onRegister(String username, String password, IAuthView authView) {
        User user = new User(username, password); // our tentative user
        this.persistenceFacade.createUserIfNotExists(user, new IPersistenceFacade.BinaryResultListener() {
            @Override
            public void onYesResult() {
                authView.onRegisterSuccess();
            }

            @Override
            public void onNoResult() {
                authView.onUserAlreadyExists();
            }
        });
    }

    @Override
    public void onSigninAttempt(String username, String password, IAuthView authView) {
        this.persistenceFacade.retrieveUser(username, new IPersistenceFacade.DataListener<User>() {
        @Override
        public void onDataReceived(@NonNull User user) {
            if (user.validatePassword(password)){ // password matches
                ControllerActivity.this.curUser = user; // we have a new user
                // navigate to ledger screen
                ControllerActivity.this.mainView.displayFragment(new HomeFragment(ControllerActivity.this));

            } else authView.onInvalidCredentials(); // let the view know things didn't work out
        }

        @Override
        public void onNoDataFound() { // means username does not exist
            authView.onInvalidCredentials(); // let the view know things didn't work out
        }
    });
    }

    @Override
    public void onNewEvent() {
        this.eventCollection = new EventCollection();
        this.mainView.displayFragment(new HomeFragment(this));
    }

    @Override
    public EventCollection getEventCollection() {
        return this.eventCollection;
    }
}
