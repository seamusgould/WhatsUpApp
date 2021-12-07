package com.example.whatsupapp.view;

import android.view.View;

import androidx.fragment.app.Fragment;

import com.example.whatsupapp.databinding.FragmentAddTimeBinding;
import com.example.whatsupapp.model.EventCollection;

public class AddTimeFragment extends Fragment implements IPostEventViewMvc {

    IPostEventViewMvc.Listener listener;
    FragmentAddTimeBinding binding;

    public AddTimeFragment(IPostEventViewMvc.Listener listener){this.listener = listener;}

    @Override
    public View getRootView() {
        return null;
    }

    @Override
    public void updateDisplay(EventCollection eventCollection) {

    }
}
