package com.example.whatsupapp.persistence;
import androidx.annotation.NonNull;

import com.example.whatsupapp.model.User;
import com.example.whatsupapp.model.Username;


public interface IPersistenceFacade {

    interface DataListener<T>{
        void onDataReceived(@NonNull T data);
        void onNoDataFound();
    }

    interface BinaryResultListener {
        void onYesResult();
        void onNoResult();
    }

    // ledger related
    //void saveSale(@NonNull Sale sale);
    //void retrieveLedger(@NonNull DataListener<Ledger> listener);

    // authentication related
    void createUserIfNotExists(@NonNull Username user, @NonNull BinaryResultListener listener);
    void retrieveUser(@NonNull String username, @NonNull DataListener<Username> listener);
}
