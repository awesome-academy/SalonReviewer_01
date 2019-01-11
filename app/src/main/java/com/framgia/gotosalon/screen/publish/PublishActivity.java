package com.framgia.gotosalon.screen.publish;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.framgia.gotosalon.R;
import com.framgia.gotosalon.screen.base.BaseActivity;

public class PublishActivity extends BaseActivity {
    private static final String EXTRA_USER_KEY = "EXTRA_USER_KEY";
    private Spinner mSpinnerOpen;
    private Spinner mSpinnerClose;

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
    }

    @Override
    protected void initData() {

    }
}
