package com.artkodec.eleccionesunmsm2016.presentation.activities;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.artkodec.eleccionesunmsm2016.R;
import com.artkodec.eleccionesunmsm2016.presentation.core.BaseActivity;
import com.artkodec.eleccionesunmsm2016.presentation.fragments.CandidateFragment;
import com.artkodec.eleccionesunmsm2016.presentation.utils.ActivityUtils;

public class MainActivity extends BaseActivity {

    DrawerLayout mDrawer;
    NavigationView navigationView;

    private Toolbar toolbar;
    private ActionBarDrawerToggle mDrawerToggle;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         *Setup the DrawerLayout and NavigationView
         */
        FrameLayout frameLayout = (FrameLayout)findViewById(R.id.layout_content_frame);
        mDrawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        navigationView = (NavigationView) findViewById(R.id.navigation);

        /**
         * Lets inflate the very first fragment
         */


        CandidateFragment guardifyFragment =
                (CandidateFragment) getSupportFragmentManager().findFragmentById(R.id.layout_content_frame);

        if (guardifyFragment == null) {
            guardifyFragment = CandidateFragment.newInstance();
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(), guardifyFragment, R.id.layout_content_frame);
        }

/*

        tabLayout = (TabLayout) activityView.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.setTabTextColors(getResources().getColorStateList(R.color.colorWhite));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);*/



        /**
         * Setup click events on the Navigation View Items.
         */

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setTitle(R.string.app_name);
        setupDrawerContent(navigationView);

        mDrawerToggle = new ActionBarDrawerToggle(
                this,                    /* host Activity */
                mDrawer,                    /* DrawerLayout object */
                toolbar,
                R.string.navigation_drawer_open,  /* "open drawer" description for accessibility */
                R.string.navigation_drawer_close  /* "close drawer" description for accessibility */
        );
        mDrawerToggle.syncState();
        mDrawer.setDrawerListener(mDrawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        mDrawerToggle.syncState();

    }





    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {


                        menuItem.setChecked(false);
                        menuItem.setCheckable(false);


                        switch (menuItem.getItemId()) {
                            case R.id.nav_where_vote:
                                Intent intent_how_vote = new Intent(getBaseContext(), VoteActivity.class);
                                intent_how_vote.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                                        | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                                startActivity(intent_how_vote);
                                break;
                            case R.id.nav_map:
                                Intent intent_map= new Intent(getBaseContext(), MapActivity.class);
                                startActivity(intent_map);
                                break;
                            case R.id.nav_how_vote:
                                Intent intent_how= new Intent(getBaseContext(), HowVoteActivity.class);
                                startActivity(intent_how);
                                break;
                            /*case R.id.nav_signout:
                                authLocalData.closeSession();
                                Intent intent = new Intent(getBaseContext(), LoginActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent);
                                finish();
                                break;*/


                            default:

                                break;
                        }
                        // Close the navigation drawer when an item is selected.
                        menuItem.setChecked(false);
                        // mDrawerLayout.closeDrawers();
                        return true;
                    }

                });
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawer.openDrawer(GravityCompat.START);
                return true;
            case R.id.action_next:
                Intent intent= new Intent(MainActivity.this,CHartActivity.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }




    @Override
    public void onBackPressed() {
        if (this.mDrawer.isDrawerOpen(GravityCompat.START)) {
            this.mDrawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.next, menu);
        return true;
    }




}
