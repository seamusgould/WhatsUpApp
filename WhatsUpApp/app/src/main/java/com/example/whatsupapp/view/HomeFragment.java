package com.example.whatsupapp.view;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.whatsupapp.Controller.ControllerActivity;
import com.example.whatsupapp.R;
import com.example.whatsupapp.databinding.FragmentHomeBinding;
import com.example.whatsupapp.databinding.MainBinding;
import com.example.whatsupapp.model.Event;
import com.example.whatsupapp.model.EventCollection;
import com.example.whatsupapp.model.Location;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */

public class HomeFragment extends Fragment implements IPostEventViewMvc.Listener,
        IHomeFragmentView, EventAdapter.ItemClickListener {

    EventAdapter adapter;
    FragmentHomeBinding binding;
    IPostEventViewMvc.Listener listener;
    LayoutInflater inflater;
    EventFragment eFragment;
    MainBinding mainBinding;
    ControllerActivity activity;

    public HomeFragment(IPostEventViewMvc.Listener listener) {
        this.listener = listener;
    }


//    public HomeFragment(Listener listener) {
//        this.listener = listener;
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.binding = FragmentHomeBinding.inflate(inflater);
        RecyclerView recyclerView = binding.recView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        adapter = new EventAdapter(this.getContext(), listener.getEvents());
        recyclerView.setAdapter(adapter);
        adapter.setClickListener(this::onItemClick);
        return this.binding.getRoot();
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        this.binding.PostButton.setOnClickListener((clickedView) -> {
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
    public void onPostButton() {

    }

    @Override
    public ArrayList<Event> getEvents() {
        return null;
    }

    @Override
    public void onAddedButton() {

    }

    @Override
    public void onCommentAdded() {

    }

    @SuppressLint("ResourceType")
    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this.getContext(), "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
        Fragment fragment = new EventFragment(this.listener, position);
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}