package com.example.whatsupapp.persistence;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.whatsupapp.model.Username;
import com.google.firebase.firestore.FirebaseFirestore;

public class FirestoreFacade implements IPersistenceFacade{

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private static final String USERS = "users";

    @Override
    public void createUserIfNotExists(@NonNull Username user, @NonNull BinaryResultListener listener) {
        this.retrieveUser(user.getUsername(), new DataListener<Username>() {
                    @Override
                    public void onDataReceived(@NonNull Username user) { // there's data there, so no go
                        listener.onNoResult();
                    }

                    @Override
                    public void onNoDataFound() { // there's no data there, so we can add the user
                        FirestoreFacade.this.setUser(user, listener);
                    }
                }
        );
    }
    private void setUser(@NonNull Username user, @NonNull BinaryResultListener listener){
        this.db.collection(USERS)
                .document(user.getUsername())
                .set(user)
                .addOnSuccessListener( avoid -> listener.onYesResult())
                .addOnFailureListener(e ->
                        Log.w("NextGenPos", "Error retrieving ledger from database",e));
    }

    @Override
    public void retrieveUser(@NonNull String username, @NonNull DataListener<Username> listener) {
        this.db.collection(USERS).document(username).get()
                .addOnSuccessListener(dsnap -> {
                    if (dsnap.exists()) { // got some data back
                        Username user = dsnap.toObject(Username.class);
                        assert (user != null);
                        listener.onDataReceived(user);
                    } else listener.onNoDataFound();  // no username match
                })
                .addOnFailureListener(e ->
                        Log.w("NextGenPos", "Error retrieving user from database",e));
    }

}
