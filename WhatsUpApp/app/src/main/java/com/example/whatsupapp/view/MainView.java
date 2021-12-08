package com.example.whatsupapp.view;

import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.whatsupapp.Controller.ControllerActivity;
import com.example.whatsupapp.R;
import com.example.whatsupapp.databinding.MainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainView implements IMainView{
    private MainBinding binding;
    private ControllerActivity activity;
    //private BottomNavigationView.OnNavigationItemSelectedListener bottomNavMethod =


   //         };

    public MainView(ControllerActivity activity) {
        this.binding = MainBinding.inflate(activity.getLayoutInflater());
        this.activity = activity;

        this.binding.bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                Fragment fragment = null;
                switch (menuItem.getItemId()) {
                    case R.id.map:
                        MainView.this.activity.onMapSelected();
                        break;
                    case R.id.home:
                        MainView.this.activity.onHomeSelected();
                        break;
                    case R.id.profile:
                        MainView.this.activity.onProfileSelected();
                        break;
                    default:
                }
                return true;
            }});
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

    @Override
    public Fragment getCurrentFragment() {
        // note: getFragment() is only available if implementation('androidx.fragment:fragment:1.4.0')
        // is part of the build.gradle dependencies (module level)
        return this.binding.fragmentContainerView.getFragment();
    }


}
