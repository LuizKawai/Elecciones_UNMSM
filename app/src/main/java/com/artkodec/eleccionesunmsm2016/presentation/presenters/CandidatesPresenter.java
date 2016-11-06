package com.artkodec.eleccionesunmsm2016.presentation.presenters;

import android.content.Context;
import android.support.annotation.NonNull;

import com.artkodec.eleccionesunmsm2016.data.entities.CandidateEntitiy;
import com.artkodec.eleccionesunmsm2016.data.repositories.remote.ServiceGeneratorSimple;
import com.artkodec.eleccionesunmsm2016.data.repositories.remote.request.CandidateRequest;
import com.artkodec.eleccionesunmsm2016.presentation.contracts.ContractCandidates;
import com.artkodec.eleccionesunmsm2016.presentation.presenters.commons.CommunicatePresenterCandidatesItem;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by junior on 15/07/16.
 */
public class CandidatesPresenter implements ContractCandidates.Presenter,CommunicatePresenterCandidatesItem {


    private final ContractCandidates.View mNewsView;
    private Context context;
    private boolean mFirstLoad = true;
    private String next;


    public CandidatesPresenter(@NonNull ContractCandidates.View mNewsView, @NonNull Context context) {
        this.context = checkNotNull(context, "context cannot be null!");
        this.mNewsView = checkNotNull(mNewsView, "newsView cannot be null!");
        this.mNewsView.setPresenter(this);
    }

    @Override
    public void loadNews(boolean forceUpdate) {
        loadNews(forceUpdate || mFirstLoad, true);
            mFirstLoad = false;
    }

    @Override
    public void openNewsDetails(@NonNull CandidateEntitiy candidateEntitiy) {

    }

    private void loadNews(boolean forceUpdate, final boolean showLoadingUI) {



            if (showLoadingUI) {
                mNewsView.setLoadingIndicator(true);
            }
            final CandidateRequest newsRequest =
                    ServiceGeneratorSimple.createService(CandidateRequest.class);

            Call<ArrayList<CandidateEntitiy>> call = newsRequest.getCandidate();

            call.enqueue(new Callback<ArrayList<CandidateEntitiy>>() {
                @Override
                public void onResponse(Call<ArrayList<CandidateEntitiy>> call, Response<ArrayList<CandidateEntitiy>> response) {
                    if (response.isSuccessful()) {


                        mNewsView.showCandidates(response.body());

                        if (!mNewsView.isActive()) {
                            return;
                        }
                        if (showLoadingUI) {
                            mNewsView.setLoadingIndicator(false);
                        }
                    } else {

                        if (!mNewsView.isActive()) {
                            return;
                        }
                        if (showLoadingUI) {
                            mNewsView.setLoadingIndicator(false);
                        }
                        mNewsView.showLoadingNewsError();

                    }
                }

                @Override
                public void onFailure(Call<ArrayList<CandidateEntitiy>> call, Throwable t) {

                    if (!mNewsView.isActive()) {
                        return;
                    }
                    if (showLoadingUI) {
                        mNewsView.setLoadingIndicator(false);
                    }
                    mNewsView.showMessage("No se pudo cargar la lista de candidatos, revise su conexión a internet");
                }

            });




    }


    @Override
    public void start() {
        loadNews(false);
    }

    @Override
    public void clickItem(CandidateEntitiy candidateEntitiy) {
        mNewsView.showCandidateDetailsUi(candidateEntitiy);
    }
}
