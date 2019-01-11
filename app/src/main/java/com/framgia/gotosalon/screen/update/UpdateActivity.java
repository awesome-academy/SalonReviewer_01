package com.framgia.gotosalon.screen.update;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.bumptech.glide.Glide;
import com.framgia.gotosalon.R;
import com.framgia.gotosalon.data.model.Salon;
import com.framgia.gotosalon.screen.base.BaseActivity;

public class UpdateActivity extends BaseActivity {
    private static final String EXTRA_USER_KEY = "EXTRA_USER_KEY";
    private EditText mEditTextSalonName;
    private EditText mEditTextSalonAddress;
    private EditText mEditTextSalonPhone;
    private EditText mEditTextSalonEmail;
    private EditText mEditTextSalonDescription;
    private Spinner mSpinnerSalonOpen;
    private Spinner mSpinnerSalonClose;
    private ImageView mImageChoose;
    private Salon mSalon;

    public static Intent getUpdateIntent(Context context, Salon salon) {
        Intent intent = new Intent(context, UpdateActivity.class);
        intent.putExtra(EXTRA_USER_KEY, salon);
        return intent;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_update;
    }

    @Override
    protected void initComponent() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mEditTextSalonAddress = findViewById(R.id.edit_salon_address);
        mEditTextSalonName = findViewById(R.id.edit_salon_name);
        mEditTextSalonDescription = findViewById(R.id.edit_salon_description);
        mEditTextSalonEmail = findViewById(R.id.edit_salon_email);
        mEditTextSalonPhone = findViewById(R.id.edit_salon_phone);
        mImageChoose = findViewById(R.id.image_choose);

        mSpinnerSalonOpen = findViewById(R.id.spinner_open);
        mSpinnerSalonOpen.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.spiner_time)));

        mSpinnerSalonClose = findViewById(R.id.spinner_close);
        mSpinnerSalonClose.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.spiner_time)));
    }

    @Override
    protected void initData() {
        mSalon = (Salon) getIntent().getSerializableExtra(EXTRA_USER_KEY);
        mEditTextSalonPhone.setText(mSalon.getSalonPhone());
        mEditTextSalonEmail.setText(mSalon.getSalonEmail());
        mEditTextSalonDescription.setText(mSalon.getSalonDescription());
        mEditTextSalonName.setText(mSalon.getSalonName());
        mEditTextSalonAddress.setText(mSalon.getSalonAddress());
        Glide.with(this).load(mSalon.getImageUrl()).into(mImageChoose);
    }
}
