package com.mtt.xrider;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends XRiderBaseActivity implements View.OnClickListener,
        NavigationView.OnNavigationItemSelectedListener{

    private final String TAG = MainActivity.class.getSimpleName();

    private CollapsingToolbarLayout collapsingToolbarLayout;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private FloatingActionButton floatingActionButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initDrawer();
    }

    /**
     * 初始化基础View
     * */
    private void initViews() {
        toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        // 标题
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.main_collapse_layout);
        collapsingToolbarLayout.setTitle(" ");

        setStatusBarColorForKitkat(R.color.color_status_bar);

        //fab
        floatingActionButton = (FloatingActionButton) findViewById(R.id.main_fab);
        floatingActionButton.setOnClickListener(this);
    }

    /**
     * 初始化抽屉
     */
    private void initDrawer() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.main_nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View headerLayout = navigationView.inflateHeaderView(R.layout.nav_header_main);
        drawerLayout = (DrawerLayout) findViewById(R.id.main_drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
    }


    @Override
    public void onClick(View view) {

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_set:
                break;
            case R.id.nav_about:
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return false;
    }
}
