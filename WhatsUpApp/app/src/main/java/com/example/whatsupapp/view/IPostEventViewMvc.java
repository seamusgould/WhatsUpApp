package com.example.whatsupapp.view;

import android.view.View;

import com.example.whatsupapp.model.EventCollection;


public interface IPostEventViewMvc {
    public interface Listener{

    }

    public View getRootView();

    public void updateDisplay(EventCollection eventCollection);
}
