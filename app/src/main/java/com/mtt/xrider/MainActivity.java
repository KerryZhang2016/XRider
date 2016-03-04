package com.mtt.xrider;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

import com.mtt.xrider.adapter.XRiderAdapter;
import com.mtt.xrider.listener.HidingScrollListener;

public class MainActivity extends XRiderBaseActivity implements View.OnClickListener,
        NavigationView.OnNavigationItemSelectedListener,SwipeRefreshLayout.OnRefreshListener{

    private final String TAG = MainActivity.class.getSimpleName();

    private CollapsingToolbarLayout collapsingToolbarLayout;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private FloatingActionButton floatingActionButton;
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;

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
        collapsingToolbarLayout.setTitle("Kerry");

        setStatusBarColorForKitkat(R.color.color_status_bar);

        //fab
        floatingActionButton = (FloatingActionButton) findViewById(R.id.main_fab);
        floatingActionButton.setOnClickListener(this);
        CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams();
        final int fabBottomMargin = lp.bottomMargin;

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.main_srl);
        swipeRefreshLayout.setOnRefreshListener(this);

        recyclerView = (RecyclerView) findViewById(R.id.main_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setHasFixedSize(true);
        recyclerView.addOnScrollListener(new HidingScrollListener() {
            @Override
            public void onHide() {
                floatingActionButton.animate()
                        .translationY(floatingActionButton.getHeight() + fabBottomMargin)
                        .setInterpolator(new AccelerateInterpolator(2))
                        .start();
            }

            @Override
            public void onShow() {
                floatingActionButton.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2)).start();
            }
        });
        XRiderAdapter mAdapter = new XRiderAdapter(MainActivity.this, null,null);
        recyclerView.setAdapter(mAdapter);
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

    @Override
    public void onRefresh() {

    }

    @Override
    public void onClick(View view) {

    }
}
