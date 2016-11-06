package com.artkodec.eleccionesunmsm2016.presentation.presenters;

import android.content.Context;
import android.support.annotation.NonNull;

import com.artkodec.eleccionesunmsm2016.data.entities.ProposalEntities;
import com.artkodec.eleccionesunmsm2016.data.repositories.remote.ServiceGeneratorSimple;
import com.artkodec.eleccionesunmsm2016.data.repositories.remote.request.ProposalRequest;
import com.artkodec.eleccionesunmsm2016.presentation.contracts.ContractProposals;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by junior on 15/07/16.
 */
public class ProposalPresenter implements ContractProposals.Presenter {


    private final ContractProposals.View mNewsView;
    private Context context;
    private boolean mFirstLoad = true;
    private String next;


    public ProposalPresenter(@NonNull ContractProposals.View mNewsView, @NonNull Context context) {
        this.context = checkNotNull(context, "context cannot be null!");
        this.mNewsView = checkNotNull(mNewsView, "newsView cannot be null!");
        this.mNewsView.setPresenter(this);
    }


    @Override
    public void start() {

    }



    @Override
    public void loadProposal(String filter) {


            mNewsView.setLoadingIndicator(true);

        final ProposalRequest newsRequest =
                ServiceGeneratorSimple.createService(ProposalRequest.class);

        Call<ArrayList<ProposalEntities>> call = newsRequest.getCandidate(filter);

        call.enqueue(new Callback<ArrayList<ProposalEntities>>() {
            @Override
            public void onResponse(Call<ArrayList<ProposalEntities>> call, Response<ArrayList<ProposalEntities>> response) {
                if (response.isSuccessful()) {


                    mNewsView.showProposal(response.body().get(0));

                    if (!mNewsView.isActive()) {
                        return;
                    }

                        mNewsView.setLoadingIndicator(false);

                } else {

                    if (!mNewsView.isActive()) {
                        return;
                    }

                    mNewsView.setLoadingIndicator(false);

                    mNewsView.showMessage("No se pudo cargar las propuestas, inténtelo nuevamente");

                }
            }

            @Override
            public void onFailure(Call<ArrayList<ProposalEntities>> call, Throwable t) {

                if (!mNewsView.isActive()) {
                    return;
                }

                    mNewsView.setLoadingIndicator(false);

                mNewsView.showMessage("Ocurrió un problema, verifique su conexión a internet");
            }

        });
    }


}
