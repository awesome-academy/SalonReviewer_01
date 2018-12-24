package com.framgia.gotosalon.screen.login;

import android.app.ProgressDialog;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.framgia.gotosalon.R;
import com.framgia.gotosalon.data.model.Account;
import com.framgia.gotosalon.data.repository.AuthenicationRepository;
import com.framgia.gotosalon.data.source.SavingAccountPreference;
import com.framgia.gotosalon.data.source.local.AuthenicationLocalDataSoucre;
import com.framgia.gotosalon.data.source.remote.AuthenicationRemoteDataSoucre;
import com.framgia.gotosalon.screen.base.BaseActivity;
import com.framgia.gotosalon.screen.home.HomeActivity;
import com.framgia.gotosalon.screen.signup.SignUpActivity;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends BaseActivity implements View.OnClickListener, LoginContract.View {
    private static final String FILE_NAME_PREFERENCE = "FileName";
    private static final String MSG_PLEASE_WAIT = "please wait few second";
    private LoginContract.Presenter mPresenter;
    private EditText mEditTextEmail;
    private EditText mEditTextPassword;
    private CheckBox mCheckBoxRemember;
    private ProgressDialog mDialog;
    private Account mAccount;

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
        mCheckBoxRemember = findViewById(R.id.check_box_remember);
        mDialog = new ProgressDialog(this);
    }

    @Override
    protected void initData() {
        mPresenter = new LoginPresenter(AuthenicationRepository.getInstance(
                AuthenicationRemoteDataSoucre.getInstance(FirebaseAuth.getInstance()),
                AuthenicationLocalDataSoucre.getInstance(new SavingAccountPreference(
                        getSharedPreferences(FILE_NAME_PREFERENCE, MODE_PRIVATE)))));
        mPresenter.setView(this);
        mAccount = new Account();
        mPresenter.restoreAccount(mAccount);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_sign_in:
                mAccount.setEmail(mEditTextEmail.getText().toString());
                mAccount.setPassword(mEditTextPassword.getText().toString());
                mAccount.setRemember(mCheckBoxRemember.isChecked());
                mPresenter.saveAccount(mAccount);
                mPresenter.signIn(mAccount);
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

    @Override
    public void onRestoringAccount(Account account) {
        mEditTextEmail.setText(account.getEmail());
        mEditTextPassword.setText(account.getPassword());
        mCheckBoxRemember.setChecked(account.isRemember());
    }

    @Override
    public void showProgressDialog() {
        mDialog.setCancelable(false);
        mDialog.setTitle(R.string.tittle_sign_in);
        mDialog.setMessage(MSG_PLEASE_WAIT);
        mDialog.show();
    }

    @Override
    public void hideProgressDialog() {
        mDialog.hide();
    }
}
