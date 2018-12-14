package com.framgia.gotosalon.screen.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResource());
        initComponent();
        initData();
    }

    abstract protected int getLayoutResource();

    abstract protected void initComponent();

    abstract protected void initData();

    protected void navigateScreen(Context context, Class<?> activity) {
        startActivity(new Intent(context, activity));
    }
}
