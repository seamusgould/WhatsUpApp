package com.example.whatsupapp.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.whatsupapp.R;
import com.example.whatsupapp.databinding.FragmentPostEventBinding;
import com.example.whatsupapp.model.EventCollection;

public class PostEventFragment extends Fragment implements IPostEventViewMvc{

    Listener listener;
    FragmentPostEventBinding binding;

    public PostEventFragment() {
    }

    public PostEventFragment(Listener listener){
        this.listener = listener;
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

                EventCollection events = listener.onAddedEvent(eventName, eventDate, eventTime, eventLoc, eventDescription);
                eventNameEditable.clear();
                eventDateEditable.clear();
                eventTimeEditable.clear();
                eventLocEditable.clear();
                eventDescriptionEditable.clear();
                this.listener.onAddedButton();
        });
    }

    @Override
    public View getRootView() {
        return null;
    }

    @Override
    public void updateDisplay(EventCollection eventCollection){
//        String s = eventCollection.toString();
//        this.binding.eventList.setText(s);
    }
}