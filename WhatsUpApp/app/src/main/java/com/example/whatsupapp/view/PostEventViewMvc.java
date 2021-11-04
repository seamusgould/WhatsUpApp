package com.example.whatsupapp.view;

import com.example.whatsupapp.databinding.ActivityMainBinding;
import com.example.whatsupapp.model.EventCollection;

import android.content.Context;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;

public class PostEventViewMvc implements IPostEventViewMvc{
    private ActivityMainBinding binding;
    private Listener listener;

    public PostEventViewMvc(Context context, Listener listener) {
        this.listener = listener;
        this.binding = ActivityMainBinding.inflate(LayoutInflater.from(context));

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

                // get the event description
                Editable eventDescriptionEditable = binding.editDescription.getText();
                String eventDescription = eventDescriptionEditable.toString();
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
