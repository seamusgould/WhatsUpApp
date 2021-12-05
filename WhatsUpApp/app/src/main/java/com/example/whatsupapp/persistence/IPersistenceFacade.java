package com.example.whatsupapp.persistence;

import com.example.whatsupapp.model.Event;

public interface IPersistenceFacade {

    interface EventListener{
        void onEvemtReceived(Event event);
    }
}
