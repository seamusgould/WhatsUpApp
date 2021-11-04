package com.example.whatsupapp.model;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.whatsupapp.R;
import com.example.whatsupapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}