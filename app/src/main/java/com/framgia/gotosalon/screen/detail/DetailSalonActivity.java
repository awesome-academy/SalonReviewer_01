package com.framgia.gotosalon.screen.detail;

import android.support.v7.widget.Toolbar;
import android.view.View;

import com.framgia.gotosalon.R;
import com.framgia.gotosalon.screen.base.BaseActivity;

public class DetailSalonActivity extends BaseActivity {
    @Override
    protected int getLayoutResource() {
        return R.layout.activity_detail_salon;
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
    }

    @Override
    protected void initData() {

    }
}
