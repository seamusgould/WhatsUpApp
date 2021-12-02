package com.example.whatsupapp.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.whatsupapp.R;
import com.example.whatsupapp.databinding.FragmentEventBinding;
import com.example.whatsupapp.databinding.FragmentHomeBinding;
import com.example.whatsupapp.databinding.MainBinding;
import com.example.whatsupapp.model.Event;
import com.example.whatsupapp.model.EventCollection;
import com.example.whatsupapp.model.Location;

import java.util.ArrayList;

public class EventFragment extends Fragment implements IPostEventViewMvc.Listener, IHomeFragmentView, EventAdapter.ItemClickListener {

    Event event;
    FragmentEventBinding binding;
    IPostEventViewMvc.Listener listener;
    LayoutInflater inflater;

    public EventFragment(IPostEventViewMvc.Listener listener, int i){
        this.listener = listener;
        ArrayList<Event> events = listener.getEvents();
        this.event = events.get(i);
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.binding = FragmentEventBinding.inflate(inflater);
        binding.eventname.setText(event.toString());




        return this.binding.getRoot();
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        this.binding.postComment.setOnClickListener((clickedView) -> {
                    this.listener.onPostButton();
                }
        );
    }

    @Override
    public EventCollection onAddedEvent(String eventName, String eventDateAndTime, String time, String eventRoughLocation, String eventDescription) {
        return null;
    }

    @Override
    public ArrayList<Location> getLocationList() {
        return null;
    }

    @Override
    public ArrayList<Event> getEvents() {
        return null;
    }

    @Override
    public void onPostButton() {

    }

    @Override
    public void onItemClick(View view, int position) {

    }

    @Override
    public void onAddedButton() {

    }
}
