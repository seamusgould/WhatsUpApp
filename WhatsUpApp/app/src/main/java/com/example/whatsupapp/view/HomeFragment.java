package com.example.whatsupapp.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.whatsupapp.R;
import com.example.whatsupapp.databinding.FragmentHomeBinding;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */

public class HomeFragment extends Fragment implements IHomeFragmentView {

    FragmentHomeBinding binding;
    Listener listener;

    public HomeFragment(Listener listener) {
        this.listener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.binding = FragmentHomeBinding.inflate(inflater);
        return this.binding.getRoot();
//        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        this.binding.PostButton.setOnClickListener((clickedView) -> {
                    this.listener.onPostButton();
                }
        );
    }
}