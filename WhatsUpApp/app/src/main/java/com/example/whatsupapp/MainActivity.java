package com.example.whatsupapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.whatsupapp.databinding.ActivityMainBinding;
import com.example.whatsupapp.model.EventCollection;
import com.example.whatsupapp.view.IPostEventViewMvc;
import com.example.whatsupapp.view.PostEventViewMvc;
import com.example.whatsupapp.model.Event;

import com.example.whatsupapp.*;



public class MainActivity extends AppCompatActivity implements IPostEventViewMvc.Listener{

    private IPostEventViewMvc addedEvent;
    private EventCollection eventCollection;

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.eventCollection = new EventCollection();
        this.addedEvent = new PostEventViewMvc(getApplicationContext(), this);
        setContentView(this.addedEvent.getRootView());
    }

    @Override
    public void onAddedEvent(String name, int qty) {

    }
}