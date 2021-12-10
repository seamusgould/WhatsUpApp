package com.example.whatsupapp.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.whatsupapp.databinding.FragmentAddDateBinding;
import com.example.whatsupapp.databinding.FragmentAddTimeBinding;
import com.example.whatsupapp.model.EventCollection;

import java.util.Calendar;

public class AddTimeFragment extends Fragment implements IPostEventViewMvc {

    IPostEventViewMvc.Listener listener;
    FragmentAddTimeBinding binding;
    String eventDateString;
    String howOften;
    String howMany;
    String howManySkipped;
    boolean secondConstructorUsed = false;
    Calendar eventDate = Calendar.getInstance();

    public AddTimeFragment(IPostEventViewMvc.Listener listener, String eventDateString) {
        this.listener = listener;
        this.eventDateString = eventDateString;
        }

    public AddTimeFragment(IPostEventViewMvc.Listener listener, Calendar eventDate, String howOften, String howMany, String howManySkipped) {
        this.listener = listener;
        this.eventDateString = eventDate.get(Calendar.MONTH) + "/" + eventDate.get(Calendar.DATE) + "/" + eventDate.get(Calendar.YEAR);
        this.howOften = howOften;
        this.howMany = howMany;
        this.howManySkipped = howManySkipped;
        this.eventDate.set(Calendar.MONTH, eventDate.get(Calendar.MONTH));
        this.eventDate.set(Calendar.DATE, eventDate.get(Calendar.DATE));
        this.eventDate.set(Calendar.YEAR, eventDate.get(Calendar.YEAR));
        secondConstructorUsed = true;
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.binding = FragmentAddTimeBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        this.binding.TimeButton.setOnClickListener((clickedView) -> {
            int eventHour = this.binding.timePicker1.getHour();
            int eventMinutes = this.binding.timePicker1.getMinute();

            eventDateString += " " + eventHour + ":" + eventMinutes;

            if (secondConstructorUsed){

                this.eventDate.set(Calendar.HOUR, eventHour);
                this.eventDate.set(Calendar.MINUTE, eventMinutes);
                this.listener.onTimeButtonRecurrence(eventDate, howOften, howMany, howManySkipped);
            } else{
                this.listener.onTimeButton(eventDateString);
            }



                }
        );
    }

    @Override
    public View getRootView() {
        return null;
    }

    @Override
    public void updateDisplay(EventCollection eventCollection) {

    }
}
