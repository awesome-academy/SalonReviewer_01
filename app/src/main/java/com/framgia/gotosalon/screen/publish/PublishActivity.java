package com.framgia.gotosalon.screen.publish;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.framgia.gotosalon.R;

public class PublishActivity extends AppCompatActivity {
    private static final String EXTRA_USER_KEY = "EXTRA_USER_KEY";

    public static Intent getPublishIntent(Context context, String userId) {
        Intent intent = new Intent(context, PublishActivity.class);
        intent.putExtra(EXTRA_USER_KEY, userId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish);
    }
}
