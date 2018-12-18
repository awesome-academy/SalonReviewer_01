package com.framgia.gotosalon.screen.login;

import com.framgia.gotosalon.data.model.Account;

public interface LoginContract {
    interface View {
        void onSignInSuccess();

        void onEmptyFieldEmail();

        void onEmptyFieldPassword();

        void onInvalidEmail();

        void onInvalidPassword();

        void onInvalidEmailForm();
    }

    interface Presenter<View> {
        void setView(LoginContract.View view);

        void signIn(Account account);

        boolean isValidAccount(Account account);
    }
}
