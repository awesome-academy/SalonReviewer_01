package com.framgia.gotosalon.data.source;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;

public interface AuthenicationDataSource {

    interface Remote {
        void signInAccount(String email, String password, OnCompleteListener completeListener,
                           OnFailureListener failureListener);
    }
}
