package com.example.whatsupapp.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.example.whatsupapp.Controller.ControllerActivity;
import com.example.whatsupapp.R;
import com.example.whatsupapp.databinding.FragmentPostEventBinding;
import com.example.whatsupapp.model.EventCollection;
import com.example.whatsupapp.model.Location;

import java.util.ArrayList;
import java.util.Calendar;

public class PostEventFragment extends Fragment implements IPostEventViewMvc{

    Listener listener;
    FragmentPostEventBinding binding;
    String eventPoster;
    String eventDateAndTime;

    EventCollection ev;
    Calendar currentCal = Calendar.getInstance();
    String howOften;
    int howMany;
    int howManySkipped;
    Boolean secondConstructorUsed = false;

    public PostEventFragment(Listener listener, String eventPoster, String eventDateAndTime){
        this.listener = listener;
        this.eventPoster = eventPoster;
        this.eventDateAndTime = eventDateAndTime;

    }

    public PostEventFragment(Listener listener, String eventPoster, EventCollection eventCollection, Calendar eventDate, String howOften, int howMany, int howManySkipped) {
        this.listener = listener;
        this.eventPoster = eventPoster;
        this.ev = eventCollection;
        this.howOften = howOften;
        this.howMany = howMany;
        this.howManySkipped = howManySkipped;

        currentCal.set(Calendar.MONTH, eventDate.get(Calendar.MONTH));
        currentCal.set(Calendar.DATE, eventDate.get(Calendar.DATE));
        currentCal.set(Calendar.YEAR, eventDate.get(Calendar.YEAR));
        currentCal.set(Calendar.HOUR, eventDate.get(Calendar.HOUR));
        currentCal.set(Calendar.MINUTE, eventDate.get(Calendar.MINUTE));

        int currentMonth = currentCal.get(Calendar.MONTH);
        int currentDay = currentCal.get(Calendar.DATE);

        eventDateAndTime = addZero(currentMonth + 1) + "/" + addZero(currentDay) + "/" + currentCal.get(Calendar.YEAR) + " " + addZero(currentCal.get(Calendar.HOUR))
                + ":" + addZero(currentCal.get(Calendar.MINUTE));

        secondConstructorUsed = true;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.binding = FragmentPostEventBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        //change arraylist to array
        ArrayList<Location> locationArrayList = listener.getLocationList();
        String[] stringArray = new String[locationArrayList.size()];
        int i = 0;
        for(Location loc: locationArrayList) {
            stringArray[i] = loc.toString();
            i++;
        }

        AutoCompleteTextView editLocation = this.binding.editLoc;
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(editLocation.getContext(),
                android.R.layout.simple_list_item_1, stringArray );
        editLocation.setAdapter(adapter);

        this.binding.addEventButton.setOnClickListener((clickedView) -> {

                // get the event name
                Editable eventNameEditable = binding.editName.getText();
                String eventName = eventNameEditable.toString();

                // get the event location
                Editable eventLocEditable = binding.editLoc.getText();
                String eventLoc = eventLocEditable.toString();

                // get the event description
                Editable eventDescriptionEditable = binding.editDescription.getText();
                String eventDescription = eventDescriptionEditable.toString();

                if (secondConstructorUsed){
                    EventCollection events = listener.onAddedRecurrence(eventName, eventDateAndTime, eventLoc, eventPoster, eventDescription,
                            currentCal, howOften, howMany, howManySkipped);
                } else {
                    EventCollection events = listener.onAddedEvent(eventName, eventDateAndTime,
                            eventDescription, eventPoster, eventLoc);
                }

                //TODO: figure out a way to call handleRecurrence on the newly created event
                this.listener.onAddedButton();
                eventNameEditable.clear();
                eventLocEditable.clear();
                eventDescriptionEditable.clear();

        });
    }

    public String addZero(int x){
        if (x < 10){
            return "0" + x;
        } else
        {
            return Integer.toString(x);
        }

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
    }

    @Override
    public View getRootView() {
        return null;
    }

    @Override
    public void updateDisplay(EventCollection eventCollection){
    }
}