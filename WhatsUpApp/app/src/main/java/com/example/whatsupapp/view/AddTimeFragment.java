package com.example.whatsupapp.view;

import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.Fragment;

import com.example.whatsupapp.databinding.FragmentAddTimeBinding;
import com.example.whatsupapp.model.EventCollection;

public class AddTimeFragment extends Fragment implements IPostEventViewMvc {

    IPostEventViewMvc.Listener listener;
    FragmentAddTimeBinding binding;

    public AddTimeFragment(IPostEventViewMvc.Listener listener){this.listener = listener;}

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        this.binding.TimeButton.setOnClickListener((clickedView) -> {
                    this.listener.onDateButton();
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
