package com.example.whatsupapp.view;

import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.whatsupapp.databinding.FragmentAddDateBinding;
import com.example.whatsupapp.databinding.FragmentRecurrenceBinding;
import com.example.whatsupapp.model.EventCollection;

import java.util.Calendar;

public class RecurrenceFragment extends Fragment implements IPostEventViewMvc{

    IPostEventViewMvc.Listener listener;
    FragmentRecurrenceBinding binding;
    Calendar curEventDate = Calendar.getInstance();

    public RecurrenceFragment(Listener listener, Calendar eventDate){
        this.listener = listener;
        curEventDate.set(Calendar.MONTH, eventDate.get(Calendar.MONTH));
        curEventDate.set(Calendar.DATE, eventDate.get(Calendar.DATE));
        curEventDate.set(Calendar.YEAR, eventDate.get(Calendar.YEAR));
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.binding = FragmentRecurrenceBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        this.binding.confirmRecurrenceButton.setOnClickListener((clickedView) -> {
            int selectedID = this.binding.weeklyOrMonthlyGroup.getCheckedRadioButtonId();
            String weeklyOrMonthlyString;
            if (selectedID == this.binding.weeklyButton2.getId())
            {
                weeklyOrMonthlyString = "weekly";
            } else
            {
                weeklyOrMonthlyString = "monthly";
            }

                    Editable weeksSkippedEditable = binding.numberOfWeeksSkipped.getText();
                    Editable totalWeeksEditable = binding.numberOfTotalEvents.getText();

                    String weeksSkipped = weeksSkippedEditable.toString();
                    String totalWeeks = totalWeeksEditable.toString();


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
