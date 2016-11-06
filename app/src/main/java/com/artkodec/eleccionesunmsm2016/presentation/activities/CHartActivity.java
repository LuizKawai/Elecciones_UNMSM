package com.artkodec.eleccionesunmsm2016.presentation.activities;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import com.artkodec.eleccionesunmsm2016.R;
import com.artkodec.eleccionesunmsm2016.presentation.core.BaseActivity;
import com.artkodec.eleccionesunmsm2016.presentation.fragments.ChartFragment;
import com.artkodec.eleccionesunmsm2016.presentation.presenters.ChartPresenter;
import com.artkodec.eleccionesunmsm2016.presentation.utils.ActivityUtils;


/**
 * Created by junior on 10/07/16.
 */
public class CHartActivity extends BaseActivity {

    private ChartPresenter registerUserPresenter;

    private ChartFragment registerUserFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back);
        //toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setTitle("Encuestas Generales");
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setDisplayShowHomeEnabled(true);

        registerUserFragment =
                (ChartFragment) getSupportFragmentManager().findFragmentById(R.id.layout_content_frame);


        if (registerUserFragment == null) {
            registerUserFragment = ChartFragment.newInstance();
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(), registerUserFragment, R.id.layout_content_frame);
        }

        this.registerUserPresenter = new ChartPresenter(
                registerUserFragment,
                this
        );
    }

    public void showMessageError(String message) {
        CoordinatorLayout container = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        super.showMessage(container, message);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }





}
