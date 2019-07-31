package com.example.navaspk.nypopular.view;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.navaspk.nypopular.R;

public class PopularMainActivity extends AppCompatActivity implements View.OnClickListener {

    private DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle mActionBarDrawerToggle;
    NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popular_main);
        configureNavigationDrawer();
        configureToolbar();
        initUI();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.collps_menu, menu);
        return true;
    }

    private void configureToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_container);
        setSupportActionBar(toolbar);

        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(false);
        actionbar.setHomeButtonEnabled(true);
        //actionbar.setHomeAsUpIndicator(R.drawable.home_new_icon);
        //actionbar.setHomeAsUpIndicator(R.drawable.ic_action_menu);

        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.app_name,R.string.app_name);
        //mDrawerLayout.setDrawerListener(mActionBarDrawerToggle);
        if (mActionBarDrawerToggle != null)
            mActionBarDrawerToggle.syncState();

        ImageView tooBarSettings = (ImageView) findViewById(R.id.toolbar_settings_imageview);
        tooBarSettings.setOnClickListener(this);
    }

    private void configureNavigationDrawer() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.navigation_drawer);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView
                .OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                Fragment frag = null;
                int itemId = menuItem.getItemId();
                if (itemId == R.id.home_item) {
                    //f = new RefreshFragment();
                } else if (itemId == R.id.about_item) {
                    //f = new StopFragment();
                }
                if (frag != null) {
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.framelayout_container, frag);
                    transaction.commit();
                    mDrawerLayout.closeDrawers();
                    return true;
                }
                return false;
            }
        });
    }

    private void initUI() {
        PopularHomeFragment frag = new PopularHomeFragment();
        if (frag != null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.framelayout_container, frag);
            transaction.commitAllowingStateLoss();
            mDrawerLayout.closeDrawers();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            // Android home
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
            // manage other entries
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolbar_settings_imageview:
                openSettingsDrawer();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(mNavigationView)) {
            closeSettingsDrawer();
        } else {
            super.onBackPressed();
        }
    }

    private void closeSettingsDrawer() {
        mDrawerLayout.closeDrawer(mNavigationView);
    }

    private void openSettingsDrawer() {
            mDrawerLayout.openDrawer(mNavigationView);
    }
}
