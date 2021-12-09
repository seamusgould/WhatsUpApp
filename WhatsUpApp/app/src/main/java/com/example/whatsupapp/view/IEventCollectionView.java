package com.example.whatsupapp.view;

import com.example.whatsupapp.model.EventCollection;

public interface IEventCollectionView {

    interface Listener {
        void onNewEvent();
        EventCollection getEventCollection();
    }

    void onEventCollectionUpdated(EventCollection eventCollection);
}
