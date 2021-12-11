package com.example.whatsupapp.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.whatsupapp.databinding.FragmentAddDateBinding;
import com.example.whatsupapp.model.EventCollection;

import java.util.Calendar;

public class AddDateFragment extends Fragment implements IPostEventViewMvc {

    IPostEventViewMvc.Listener listener;
    FragmentAddDateBinding binding;

    public AddDateFragment(IPostEventViewMvc.Listener listener){
        this.listener = listener;
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.binding = FragmentAddDateBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        this.binding.DateButton.setOnClickListener((clickedView) -> {

            int eventMonth = (1 + this.binding.datePicker1.getMonth());
            int eventDay = this.binding.datePicker1.getDayOfMonth();
            int eventYear = this.binding.datePicker1.getYear();

            String eventDateString = addZero(eventMonth) + "/" + addZero(eventDay) + "/" + eventYear;

            this.listener.onDateButton(eventDateString);
                }
        );

        this.binding.recurrenceButton.setOnClickListener((clickedView) -> {
                    Calendar eventDate = Calendar.getInstance();
                    int eventMonth = this.binding.datePicker1.getMonth();
                    int eventDay = this.binding.datePicker1.getDayOfMonth();
                    int eventYear = this.binding.datePicker1.getYear();

                    eventDate.set(Calendar.MONTH, eventMonth);
                    eventDate.set(Calendar.DATE, eventDay);
                    eventDate.set(Calendar.YEAR, eventYear);

                    this.listener.onRecurrenceButton(eventDate);
                }
        );
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
    public View getRootView() {
        return null;
    }

    @Override
    public void updateDisplay(EventCollection eventCollection) {

    }
}
