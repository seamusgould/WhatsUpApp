package com.example.whatsupapp.view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

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

        ListView lv = (ListView) binding.comments;

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                event.getComments());
        lv.setAdapter(arrayAdapter);
    return this.binding.getRoot();
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        this.binding.postComment.setOnClickListener((clickedView) -> {
            Editable nameEditable = binding.comment.getText();
            String user_comment = nameEditable.toString();
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Calendar cal = Calendar.getInstance();
            event.addComment(user_comment + " posted by " + event.getUser() + " " + dateFormat.format(cal.getTime()));
    });
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

    @Override
    public void onCommentAdded() {

    }
}