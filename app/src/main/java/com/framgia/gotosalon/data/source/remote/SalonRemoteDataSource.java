package com.framgia.gotosalon.data.source.remote;

import com.framgia.gotosalon.data.source.SalonDataSource;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class SalonRemoteDataSource implements SalonDataSource.Remote {
    private DatabaseReference mReference;
    private static SalonRemoteDataSource sInstance;

    private SalonRemoteDataSource(DatabaseReference reference) {
        mReference = reference;
    }

    public static SalonRemoteDataSource getInstance(DatabaseReference reference) {
        if (sInstance == null) {
            sInstance = new SalonRemoteDataSource(reference);
        }
        return sInstance;
    }

    @Override
    public void getSalons(ValueEventListener listener) {
        mReference.addValueEventListener(listener);
    }
}
