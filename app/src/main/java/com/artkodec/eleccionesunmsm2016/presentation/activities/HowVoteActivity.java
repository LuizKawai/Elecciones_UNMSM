package com.artkodec.eleccionesunmsm2016.presentation.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.artkodec.eleccionesunmsm2016.R;
import com.artkodec.eleccionesunmsm2016.data.entities.CandidateEntitiy;
import com.artkodec.eleccionesunmsm2016.presentation.fragments.DetailCandidateFragment;
import com.artkodec.eleccionesunmsm2016.presentation.fragments.HowVoteFragment;
import com.artkodec.eleccionesunmsm2016.presentation.utils.ActivityUtils;


/**
 * Created by junior on 25/05/16.
 */
public class HowVoteActivity extends AppCompatActivity {

    public static final String EXTRA_NEWS = "NEW_PARAMETER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_back);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();

        ab.setDisplayHomeAsUpEnabled(true);
        ab.setDisplayShowHomeEnabled(true);
        ab.setTitle("¿Cómo votar?");
        // Get the requested task id




        HowVoteFragment fragment = (HowVoteFragment) getSupportFragmentManager()
                .findFragmentById(R.id.layout_content_frame);


        if (fragment == null) {
            fragment = HowVoteFragment.newInstance();

            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    fragment, R.id.layout_content_frame);
        }




    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }



}
