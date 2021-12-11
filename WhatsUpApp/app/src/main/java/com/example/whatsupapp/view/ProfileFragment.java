package com.example.whatsupapp.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.whatsupapp.databinding.FragmentEventBinding;
import com.example.whatsupapp.databinding.FragmentProfileBinding;
import com.example.whatsupapp.R;
import com.example.whatsupapp.model.Event;
import com.example.whatsupapp.model.EventCollection;
import com.example.whatsupapp.model.Username;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    FragmentProfileBinding binding;
    String username;
    EventCollection ec;
    List<Event> filteredEvents = new ArrayList<Event>();

    public ProfileFragment(EventCollection eventCollection, String username){
        this.username = username;
        this.ec = eventCollection;
        filteredEvents = ec.findUsersEvents(username);
    }

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = FragmentProfileBinding.inflate(inflater);
        binding.usernameText.setText(username);

        ListView lv = (ListView) binding.userPosts;

        ArrayAdapter<Event> arrayAdapter = new ArrayAdapter<Event>(getActivity(),
                android.R.layout.simple_list_item_1,
                filteredEvents);

        lv.setAdapter(arrayAdapter);
        return this.binding.getRoot();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
    }
}