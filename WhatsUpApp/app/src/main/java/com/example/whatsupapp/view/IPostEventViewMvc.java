package com.example.whatsupapp.view;

import android.view.View;

import com.example.whatsupapp.model.EventCollection;
import com.example.whatsupapp.model.Location;

import java.util.ArrayList;


public interface IPostEventViewMvc {

    public interface Listener{
        void onAddedEvent(String name, int qty);
    }

    public View getRootView();

    public void updateDisplay(EventCollection eventCollection);
}
