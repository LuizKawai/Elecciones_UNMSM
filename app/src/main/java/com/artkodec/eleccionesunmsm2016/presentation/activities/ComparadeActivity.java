package com.artkodec.eleccionesunmsm2016.presentation.activities;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import com.artkodec.eleccionesunmsm2016.R;
import com.artkodec.eleccionesunmsm2016.presentation.core.BaseActivity;
import com.artkodec.eleccionesunmsm2016.presentation.fragments.ProposalFragment;
import com.artkodec.eleccionesunmsm2016.presentation.presenters.ProposalPresenter;
import com.artkodec.eleccionesunmsm2016.presentation.utils.ActivityUtils;


/**
 * Created by junior on 10/07/16.
 */
public class ComparadeActivity extends BaseActivity {

    private ProposalPresenter registerUserPresenter;

    private ProposalFragment registerUserFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_principal);
        //toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setTitle("Compara las Propuestas");
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setDisplayShowHomeEnabled(true);

        registerUserFragment =
                (ProposalFragment) getSupportFragmentManager().findFragmentById(R.id.layout_content_frame);


        if (registerUserFragment == null) {
            registerUserFragment = ProposalFragment.newInstance();
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(), registerUserFragment, R.id.layout_content_frame);
        }

        this.registerUserPresenter = new ProposalPresenter(
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
