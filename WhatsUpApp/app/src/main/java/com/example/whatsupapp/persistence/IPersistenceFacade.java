package com.example.whatsupapp.persistence;
import androidx.annotation.NonNull;

import com.example.whatsupapp.model.Event;
import com.example.whatsupapp.model.EventCollection;
import com.example.whatsupapp.model.User;
import com.example.whatsupapp.model.Username;


public interface IPersistenceFacade {

    void saveComment(Event event);

    interface DataListener<T>{
        void onDataReceived(@NonNull T data);
        void onNoDataFound();
    }

    interface BinaryResultListener {
        void onYesResult();
        void onNoResult();
    }

    // ledger related
    void saveEvent(@NonNull Event event);
    void retrieveEventCollection(@NonNull DataListener<EventCollection> listener);

    // authentication related
    void createUserIfNotExists(@NonNull User user, @NonNull BinaryResultListener listener);
    void retrieveUser(@NonNull String username, @NonNull DataListener<User> listener);
}
