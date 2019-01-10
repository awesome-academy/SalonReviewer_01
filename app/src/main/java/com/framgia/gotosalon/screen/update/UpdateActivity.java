package com.framgia.gotosalon.screen.update;

import android.content.Context;
import android.content.Intent;

import com.framgia.gotosalon.data.model.Salon;
import com.framgia.gotosalon.screen.base.BaseActivity;

public class UpdateActivity extends BaseActivity {
    private static final String EXTRA_USER_KEY = "EXTRA_USER_KEY";

    public static Intent getUpdateIntent(Context context, Salon salon) {
        Intent intent = new Intent(context, UpdateActivity.class);
        intent.putExtra(EXTRA_USER_KEY, salon);
        return intent;
    }

    @Override
    protected int getLayoutResource() {
        return 0;
    }

    @Override
    protected void initComponent() {

    }

    @Override
    protected void initData() {

    }
}
