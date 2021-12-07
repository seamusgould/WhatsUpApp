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
