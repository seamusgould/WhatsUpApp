package com.example.whatsupapp.view;

import com.example.whatsupapp.R;
import com.example.whatsupapp.databinding.ActivityMainBinding;
import com.example.whatsupapp.model.EventCollection;
import com.example.whatsupapp.model.Controller;
import com.example.whatsupapp.model.Location;

import android.content.Context;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import java.util.ArrayList;

public class PostEventViewMvc implements IPostEventViewMvc{
    private ActivityMainBinding binding;
    private Listener listener;

    public PostEventViewMvc(Context context, Listener listener) {
        this.listener = listener;
        this.binding = ActivityMainBinding.inflate(LayoutInflater.from(context));

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

        this.binding.addEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // get the event name
                Editable eventNameEditable = binding.editName.getText();
                String eventName = eventNameEditable.toString();

                // get the event date
                Editable eventDateEditable = binding.editDate.getText();
                String eventDate = eventDateEditable.toString();

                // get the event time
                Editable eventTimeEditable = binding.editTime.getText();
                String eventTime = eventTimeEditable.toString();

                // get the event location
                Editable eventLocEditable = binding.editLoc.getText();
                String eventLoc = eventLocEditable.toString();


                // get the event description
                Editable eventDescriptionEditable = binding.editDescription.getText();
                String eventDescription = eventDescriptionEditable.toString();

                listener.onAddedEvent(eventName, eventDate, eventTime, eventLoc, eventDescription);
                eventNameEditable.clear();
                eventDateEditable.clear();
                eventTimeEditable.clear();
                eventLocEditable.clear();
                eventDescriptionEditable.clear();

            }
        });

    }
    @Override
    public View getRootView() {
        return binding.getRoot();
    }

    @Override
    public void updateDisplay(EventCollection eventCollection){
        String s = eventCollection.toString();
        this.binding.eventList.setText(s);
    }
}
