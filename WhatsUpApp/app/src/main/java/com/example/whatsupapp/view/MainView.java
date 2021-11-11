package com.example.whatsupapp.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.example.whatsupapp.MainActivity;
import com.example.whatsupapp.databinding.ActivityMainBinding;
import com.example.whatsupapp.databinding.MainBinding;

public class MainView implements IMainView{
    private MainBinding binding;

    public MainView(Context context) {
        this.binding = MainBinding.inflate(LayoutInflater.from(context));
    }

    @Override
    public View getRootView() {
        return this.binding.getRoot();
    }

}
