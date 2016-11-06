package com.artkodec.eleccionesunmsm2016.presentation.fragments;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.artkodec.eleccionesunmsm2016.R;
import com.artkodec.eleccionesunmsm2016.data.entities.CandidateEntitiy;
import com.artkodec.eleccionesunmsm2016.data.entities.ProposalEntities;
import com.artkodec.eleccionesunmsm2016.presentation.activities.DetailCandidateActivity;
import com.artkodec.eleccionesunmsm2016.presentation.adapters.CandidatesAdapter;
import com.artkodec.eleccionesunmsm2016.presentation.adapters.ProposalAdapter;
import com.artkodec.eleccionesunmsm2016.presentation.contracts.ContractCandidates;
import com.artkodec.eleccionesunmsm2016.presentation.contracts.ContractProposals;
import com.artkodec.eleccionesunmsm2016.presentation.core.BaseFragment;
import com.artkodec.eleccionesunmsm2016.presentation.presenters.CandidatesPresenter;
import com.artkodec.eleccionesunmsm2016.presentation.presenters.ProposalPresenter;
import com.artkodec.eleccionesunmsm2016.presentation.presenters.commons.CommunicatePresenterCandidatesItem;
import com.artkodec.eleccionesunmsm2016.presentation.utils.ScrollChildSwipeRefreshLayout;

import java.lang.reflect.Array;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by junior on 15/07/16.
 */
public class ProposalFragment extends BaseFragment implements ContractProposals.View {
    public static final int NUM_COL=2;

    @BindView(R.id.sp_relationship)
    Spinner spRelationship;
    @BindView(R.id.list_proposal)
    RecyclerView listProposal;
    private Unbinder unbinder;
    private ContractProposals.Presenter mPresenter;
    private ProposalAdapter candidatesAdapter;
    private GridLayoutManager linearLayoutManager;
    ProgressDialog progressDialog;

    public static ProposalFragment newInstance() {
        return new ProposalFragment();
    }

    @Override
    public void onResume() {
        super.onResume();
        initView();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new ProposalPresenter(this, getContext());

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.layout_comparate, container, false);
        unbinder = ButterKnife.bind(this, root);
        // Set up progress indicator

        return root;
    }

    @Override
    protected void initView() {
        super.initView();
        setHasOptionsMenu(true);
        mPresenter = new ProposalPresenter(this, getContext());
        listProposal.setHasFixedSize(true);
        linearLayoutManager = new GridLayoutManager(getContext(),NUM_COL);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        listProposal.setLayoutManager(linearLayoutManager);
        candidatesAdapter = new ProposalAdapter(getContext(), new ArrayList<String>());
        listProposal.setAdapter(candidatesAdapter);
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Cargando");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(false);
        progressDialog.setIndeterminateDrawable(getResources().getDrawable(R.drawable.circle_progress));

        spRelationship.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if(position==0){
                    candidatesAdapter = new ProposalAdapter(getContext(), new ArrayList<String>());
                    listProposal.setAdapter(candidatesAdapter);
                }
                if(position==1){
                    mPresenter.loadProposal("eje");
                }
                if(position==2){
                    mPresenter.loadProposal("tconocimiento");
                }
                if(position==3){
                    mPresenter.loadProposal("iconocimiento");
                }
                if(position==4){
                    mPresenter.loadProposal("lineasaccion");
                }
                if(position==5){
                    mPresenter.loadProposal("academico");
                }
                if(position==6){
                    mPresenter.loadProposal("investigacion");
                }
                if(position==7){
                    mPresenter.loadProposal("proyeccion");
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

    }





    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @Override
    public void setLoadingIndicator(final boolean active) {
        if (active) {

            progressDialog.show();
        } else {
            if (progressDialog != null)
                progressDialog.dismiss();
        }
    }

    @Override
    public void showProposal(ProposalEntities candidateEntitiys) {

        ArrayList<String> list = new ArrayList<>();
        int auxpar=0;
        int auximpar=1;
        for (int i = 0; i <candidateEntitiys.getProposal_cachay().size() ; i++) {

                    list.add(candidateEntitiys.getProposal_cachay().get(i));
                    list.add(candidateEntitiys.getProposal_villa().get(i));

        }


         candidatesAdapter = new ProposalAdapter(getContext(), list);

        if (listProposal != null) {

            listProposal.setAdapter(candidatesAdapter);
        }
    }





    @Override
    public void showMessage(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoadingNewsError() {
        showMessage("No se pudo cargar la lista de candidatos");
    }

    @Override
    public boolean isActive() {
        return isAdded();
    }


    @Override
    public void setPresenter(ContractProposals.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }
}
