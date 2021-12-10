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

    public AddTimeFragment(IPostEventViewMvc.Listener listener, String eventDateString) {
        this.listener = listener;
        this.eventDateString = eventDateString;
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

            eventDateString += eventHour + ":" + eventMinutes;

            this.listener.onTimeButton(eventDateString);

            //TODO: update onTimeButton() to reflect passing in the calculator to PostFragment
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
