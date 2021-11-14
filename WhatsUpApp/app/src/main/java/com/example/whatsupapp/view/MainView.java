package com.example.whatsupapp.view;

import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.whatsupapp.R;
import com.example.whatsupapp.databinding.MainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainView implements IMainView{
    private MainBinding binding;
    private FragmentActivity activity;
    private BottomNavigationView.OnNavigationItemSelectedListener bottomNavMethod =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                    Fragment fragment = null;
                    switch (menuItem.getItemId()) {
                        case R.id.map:
                            fragment = new MapFragment();
                            break;
                        case R.id.home:
                            fragment = new HomeFragment();
                            break;
                        case R.id.profile:
                            fragment = new ProfileFragment();
                            break;
                    }
                    return true;
                }

            };

    public MainView(FragmentActivity activity) {
        this.binding = MainBinding.inflate(activity.getLayoutInflater());
        this.activity = activity;
    }

    @Override
    public View getRootView() {
        return this.binding.getRoot();
    }

    @Override
    public void displayFragment(Fragment fragment) {
        this.activity.getSupportFragmentManager()
                .beginTransaction()
                .replace(this.binding.fragmentContainerView.getId(), fragment)
                .commitNow();
    }




}
