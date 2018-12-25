package com.framgia.gotosalon.screen.home;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.framgia.gotosalon.R;
import com.framgia.gotosalon.screen.base.BaseActivity;

public class HomeActivity extends BaseActivity {

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_home;
    }

    @Override
    protected void initComponent() {
        ViewPager viewPager = findViewById(R.id.view_pager_home);
        HomePageAdapter adapter = new HomePageAdapter(getSupportFragmentManager(), getApplicationContext());
        TabLayout tabLayout = findViewById(R.id.tab_home);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    protected void initData() {

    }
}
