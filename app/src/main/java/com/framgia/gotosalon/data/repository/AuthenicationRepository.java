package com.framgia.gotosalon.data.repository;

import com.framgia.gotosalon.data.source.AuthenicationDataSource;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;

public class AuthenicationRepository implements AuthenicationDataSource.Remote {
    private AuthenicationDataSource.Remote mRemote;
    private static AuthenicationRepository sInstance;

    public AuthenicationRepository(AuthenicationDataSource.Remote remote) {
        mRemote = remote;
    }

    public static AuthenicationRepository getInstance(AuthenicationDataSource.Remote remote) {
        if (sInstance == null) {
            sInstance = new AuthenicationRepository(remote);
        }
        return sInstance;
    }

    @Override
    public void signInAccount(String email, String password, OnCompleteListener completeListener,
                              OnFailureListener failureListener) {
        mRemote.signInAccount(email, password, completeListener, failureListener);
    }
}
