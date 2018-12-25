package com.framgia.gotosalon.screen.signup;

import android.util.Patterns;

import com.framgia.gotosalon.data.model.Account;
import com.framgia.gotosalon.data.repository.AuthenicationRepository;

public class SignUpPresenter implements SignUpContract.Presenter {
    private AuthenicationRepository mRepository;
    private SignUpContract.View mView;

    public SignUpPresenter(AuthenicationRepository repository) {
        mRepository = repository;
    }

    @Override
    public void setView(SignUpContract.View view) {
        mView = view;
    }

    @Override
    public boolean validateSignUp(Account account) {
        if (account.getEmail().isEmpty()) {
            mView.onEmptyFieldEmail();
            return false;
        }
        if (account.getPassword().isEmpty()) {
            mView.onEmptyFieldPassword();
            return false;
        }
        if (account.getRePassword().isEmpty()) {
            mView.onEmptyFieldRePassword();
            return false;
        }
        if (account.getUsername().isEmpty()) {
            mView.onEmptyFieldUsername();
            return false;
        }
        if (account.getPassword().length() < 6) {
            mView.onShortPassword();
            return false;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(account.getEmail()).matches()) {
            mView.onInvalidEmailForm();
            return false;
        }
        if (!account.getPassword().equals(account.getRePassword())) {
            mView.onDoNotMatchPassword();
            return false;
        }
        return true;
    }
}
