package com.framgia.gotosalon.screen.publish;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.framgia.gotosalon.R;
import com.framgia.gotosalon.screen.base.BaseActivity;

public class PublishActivity extends BaseActivity implements View.OnClickListener {
    private static final String EXTRA_USER_KEY = "EXTRA_USER_KEY";
    private static final int ACTION_PICK_REQUEST = 1996;
    private static final String IMAGE_MIME_TYPE = "image/*";
    private Spinner mSpinnerOpen;
    private Spinner mSpinnerClose;
    private ImageView mImageChoose;
    private Uri mUri;

    public static Intent getPublishIntent(Context context, String userId) {
        Intent intent = new Intent(context, PublishActivity.class);
        intent.putExtra(EXTRA_USER_KEY, userId);
        return intent;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_publish;
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

        mSpinnerOpen = findViewById(R.id.spinner_open);
        mSpinnerOpen.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.spiner_time)));
        mSpinnerClose = findViewById(R.id.spinner_close);
        mSpinnerClose.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.spiner_time)));

        mImageChoose = findViewById(R.id.image_choose);
        findViewById(R.id.image_choose).setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ACTION_PICK_REQUEST &&
                resultCode == RESULT_OK && data != null && data.getData() != null) {
            mUri = data.getData();
            mImageChoose.setImageURI(mUri);
        } else {
            Toast.makeText(this, getResources().getString(R.string.error_spick_image), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_choose:
                Intent intent = new Intent();
                intent.setType(IMAGE_MIME_TYPE);
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, ACTION_PICK_REQUEST);
                break;
        }
    }
}
