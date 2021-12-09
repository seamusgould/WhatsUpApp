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

import com.example.whatsupapp.R;
import com.example.whatsupapp.databinding.FragmentPostEventBinding;
import com.example.whatsupapp.model.EventCollection;
import com.example.whatsupapp.model.Location;

import java.util.ArrayList;

public class PostEventFragment extends Fragment implements IPostEventViewMvc{

    Listener listener;
    FragmentPostEventBinding binding;
    String eventPoster;

    public PostEventFragment() {
    }

    public PostEventFragment(Listener listener, String eventPoster){
        this.listener = listener;
        this.eventPoster = eventPoster;

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

                EventCollection events = listener.onAddedEvent(eventName, eventDate, eventTime,
                        eventDescription, eventPoster, eventLoc);
                this.listener.onAddedButton();
                eventNameEditable.clear();
                eventDateEditable.clear();
                eventTimeEditable.clear();
                eventLocEditable.clear();
                eventDescriptionEditable.clear();

        });
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