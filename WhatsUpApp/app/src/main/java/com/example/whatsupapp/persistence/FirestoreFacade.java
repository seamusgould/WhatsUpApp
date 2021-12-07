package com.example.whatsupapp.persistence;

import androidx.annotation.NonNull;

import com.example.whatsupapp.model.Username;

public class FirestoreFacade implements IPersistenceFacade{

    @Override
    public void createUserIfNotExists(@NonNull Username user, @NonNull BinaryResultListener listener) {

    }

    @Override
    public void retrieveUser(@NonNull String username, @NonNull DataListener<Username> listener) {

    }
}
