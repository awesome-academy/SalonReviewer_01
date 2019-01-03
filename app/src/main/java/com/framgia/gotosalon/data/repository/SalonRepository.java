package com.framgia.gotosalon.data.repository;

import com.framgia.gotosalon.data.source.SalonDataSource;
import com.google.firebase.database.ValueEventListener;

public class SalonRepository implements SalonDataSource.Remote {
    private SalonDataSource.Remote mDataSource;
    private static SalonRepository sInstance;

    private SalonRepository(SalonDataSource.Remote dataSource) {
        mDataSource = dataSource;
    }

    public static SalonRepository getInstance(SalonDataSource.Remote dataSource) {
        if (sInstance == null) {
            sInstance = new SalonRepository(dataSource);
        }
        return sInstance;
    }

    @Override
    public void getSalons(ValueEventListener listener) {
        mDataSource.getSalons(listener);
    }
}
