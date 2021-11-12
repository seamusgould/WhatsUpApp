package com.example.whatsupapp.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import androidx.fragment.app.FragmentActivity;

import com.example.whatsupapp.MainActivity;
import com.example.whatsupapp.databinding.ActivityMainBinding;
import com.example.whatsupapp.databinding.MainBinding;

public class MainView implements IMainView{
    private MainBinding binding;

    public MainView(FragmentActivity activity) {
        this.binding = MainBinding.inflate(activity.getLayoutInflater());
    }

    @Override
    public View getRootView() {
        return this.binding.getRoot();
    }

}
