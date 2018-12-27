package com.framgia.gotosalon.data.source;

import com.google.firebase.database.ValueEventListener;

public interface SalonDataSource {
    interface Remote {
        void getSalons(ValueEventListener listener);
    }
}
