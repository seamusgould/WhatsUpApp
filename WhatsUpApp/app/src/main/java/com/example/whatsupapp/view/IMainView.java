package com.example.whatsupapp.view;

import android.view.View;

import androidx.fragment.app.Fragment;

import com.example.whatsupapp.model.EventCollection;
import com.example.whatsupapp.model.Location;

import java.util.ArrayList;


public interface IMainView {
    public View getRootView();
    public void displayFragment(Fragment fragment);

    public void displayNavigation(Fragment fragment);
}
