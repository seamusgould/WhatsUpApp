package com.example.whatsupapp.model;

import androidx.annotation.NonNull;
import java.io.Serializable;

public class Username implements Serializable {
    private String username;
    private AuthKey authKey;

    public Username() {}

    public Username(String username, String password){

        this.username = username;
        this.authKey = new AuthKey(password);
    }

    public String getUsername(){ return this.username; }
    public AuthKey getAuthKey(){ return this.authKey; }

    public boolean validatePassword(String password){
        return this.authKey.validatePassword(password);
    }

    @Override
    @NonNull
    public String toString(){
        return String.format("User %s, authKey: %s", this.username, this.authKey.toString());
    }
}
