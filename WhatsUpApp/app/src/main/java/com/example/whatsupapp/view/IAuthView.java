package com.example.whatsupapp.view;

public interface IAuthView {

    interface Listener{
        void onRegister(String username, String password, IAuthView authView);
        void onSigninAttempt(String username, String password, IAuthView authView);
    }
    void onRegisterSuccess();
    void onInvalidCredentials();
    void onUserAlreadyExists();
}
