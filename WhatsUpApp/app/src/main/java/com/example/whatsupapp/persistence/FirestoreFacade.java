package com.example.whatsupapp.persistence;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.whatsupapp.model.Event;
import com.example.whatsupapp.model.EventCollection;
import com.example.whatsupapp.model.User;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class FirestoreFacade implements IPersistenceFacade{

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    private static final String USERS = "users";
    private static final String EVENT_COLLECTION = "event collection";

    @Override
    public void saveEventCollection(@NonNull Event event) {
        db.collection(EVENT_COLLECTION).add(event);
    }

    @Override
    public void retrieveEventCollection(@NonNull DataListener<EventCollection> listener) {
        this.db.collection(EVENT_COLLECTION).get()
                .addOnSuccessListener(qsnap -> {
                    EventCollection ec = new EventCollection();
                    for (DocumentSnapshot dsnap : qsnap){
                        Event event = dsnap.toObject(Event.class);
                        ec.addEvent(event);
                    }
                    listener.onDataReceived(ec);
                })
                .addOnFailureListener(e ->
                        Log.w("NextGenPos", "Error retrieving ledger from database",e));
    }


    @Override
    public void createUserIfNotExists(@NonNull User user, @NonNull BinaryResultListener listener) {
        this.retrieveUser(user.getUsername(), new DataListener<User>() {
                    @Override
                    public void onDataReceived(@NonNull User user) { // there's data there, so no go
                        listener.onNoResult();
                    }

                    @Override
                    public void onNoDataFound() { // there's no data there, so we can add the user
                        FirestoreFacade.this.setUser(user, listener);
                    }
                }
        );
    }
    private void setUser(@NonNull User user, @NonNull BinaryResultListener listener){
        this.db.collection(USERS)
                .document(user.getUsername())
                .set(user)
                .addOnSuccessListener( avoid -> listener.onYesResult())
                .addOnFailureListener(e ->
                        Log.w("NextGenPos", "Error retrieving ledger from database",e));
    }

    @Override
    public void retrieveUser(@NonNull String username, @NonNull DataListener<User> listener) {
        this.db.collection(USERS).document(username).get()
                .addOnSuccessListener(dsnap -> {
                    if (dsnap.exists()) { // got some data back
                        User user = dsnap.toObject(User.class);
                        assert (user != null);
                        listener.onDataReceived(user);
                    } else listener.onNoDataFound();  // no username match
                })
                .addOnFailureListener(e ->
                        Log.w("NextGenPos", "Error retrieving user from database",e));
    }

}
