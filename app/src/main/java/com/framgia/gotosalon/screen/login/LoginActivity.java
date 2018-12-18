package com.framgia.gotosalon.screen.login;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.framgia.gotosalon.R;
import com.framgia.gotosalon.data.model.Account;
import com.framgia.gotosalon.data.repository.AuthenicationRepository;
import com.framgia.gotosalon.data.source.remote.AuthenicationRemoteDataSoucre;
import com.framgia.gotosalon.screen.base.BaseActivity;
import com.framgia.gotosalon.screen.home.HomeActivity;
import com.framgia.gotosalon.screen.signup.SignUpActivity;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends BaseActivity implements View.OnClickListener, LoginContract.View {
    private LoginContract.Presenter mPresenter;
    private EditText mEditTextEmail;
    private EditText mEditTextPassword;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_sign_in;
    }

    @Override
    protected void initComponent() {
        mEditTextEmail = findViewById(R.id.edit_email);
        mEditTextPassword = findViewById(R.id.edit_password);
        findViewById(R.id.button_sign_in).setOnClickListener(this);
        findViewById(R.id.image_back).setOnClickListener(this);
        findViewById(R.id.text_sign_up).setOnClickListener(this);
    }

    @Override
    protected void initData() {
        mPresenter = new LoginPresenter(AuthenicationRepository.getInstance(
                AuthenicationRemoteDataSoucre.getInstance(FirebaseAuth.getInstance())));
        mPresenter.setView(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_sign_in:
                Account account = new Account(mEditTextEmail.getText().toString(), mEditTextPassword.getText().toString());
                mPresenter.signIn(account);
                break;
            case R.id.text_sign_up:
                navigateScreen(this, SignUpActivity.class);
                break;
            case R.id.image_back:
                finish();
                break;
        }
    }

    @Override
    public void onSignInSuccess() {
        navigateScreen(LoginActivity.this, HomeActivity.class);
    }

    @Override
    public void onEmptyFieldEmail() {
        Toast.makeText(this, R.string.error_empty_field_email, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onEmptyFieldPassword() {
        Toast.makeText(this, R.string.error_empty_field_password, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onInvalidEmail() {
        Toast.makeText(this, R.string.error_email, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onInvalidPassword() {
        Toast.makeText(this, R.string.error_password, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onInvalidEmailForm() {
        Toast.makeText(this, R.string.error_email_form, Toast.LENGTH_SHORT).show();
    }
}
