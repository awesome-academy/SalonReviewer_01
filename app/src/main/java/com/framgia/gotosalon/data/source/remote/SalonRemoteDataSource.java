package com.framgia.gotosalon.data.source.remote;

import com.framgia.gotosalon.data.source.SalonDataSource;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;

public class SalonRemoteDataSource implements SalonDataSource.Remote {
    private DatabaseReference mDatabaseReference;
    private StorageReference mStorageReference;
    private static SalonRemoteDataSource sInstance;

    private SalonRemoteDataSource(DatabaseReference databaseReference, StorageReference storageReference) {
        mDatabaseReference = databaseReference;
        mStorageReference = storageReference;
    }

    public static SalonRemoteDataSource getInstance(DatabaseReference databaseReference,
                                                    StorageReference storageReference) {
        if (sInstance == null) {
            sInstance = new SalonRemoteDataSource(databaseReference, storageReference);
        }
        return sInstance;
    }

    @Override
    public void getSalons(ValueEventListener listener) {
        mDatabaseReference.addValueEventListener(listener);
    }
}
