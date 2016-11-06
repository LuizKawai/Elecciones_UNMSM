package com.artkodec.eleccionesunmsm2016.presentation.presenters;

import android.content.Context;
import android.support.annotation.NonNull;

import com.artkodec.eleccionesunmsm2016.data.entities.VoteEntity;
import com.artkodec.eleccionesunmsm2016.data.entities.VoteResultEntity;
import com.artkodec.eleccionesunmsm2016.data.repositories.remote.ServiceGeneratorSimple;
import com.artkodec.eleccionesunmsm2016.data.repositories.remote.request.ChartRequest;
import com.artkodec.eleccionesunmsm2016.presentation.contracts.ContracChart;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by junior on 15/07/16.
 */
public class ChartPresenter implements ContracChart.Presenter {


    private final ContracChart.View mNewsView;
    private Context context;
    private boolean mFirstLoad = true;
    private String next;


    public ChartPresenter(@NonNull ContracChart.View mNewsView, @NonNull Context context) {
        this.context = checkNotNull(context, "context cannot be null!");
        this.mNewsView = checkNotNull(mNewsView, "newsView cannot be null!");
        this.mNewsView.setPresenter(this);
    }


    @Override
    public void start() {
        getpercent();
    }




    @Override
    public void voteCandidate(int active, String id) {
        mNewsView.setLoadingIndicator(true);

        final ChartRequest newsRequest =
                ServiceGeneratorSimple.createService(ChartRequest.class);

        Call<VoteEntity> call = newsRequest.vote(String.valueOf(active),id);

        call.enqueue(new Callback<VoteEntity>() {
            @Override
            public void onResponse(Call<VoteEntity> call, Response<VoteEntity> response) {
                if (response.isSuccessful()) {


                    mNewsView.showMessage("Tu voto fue registrado exitosamente, gracias por ayudarnos a mejorar la encuesta");
                    mNewsView.showRefreshPercent();

                    if (!mNewsView.isActive()) {
                        return;
                    }

                    mNewsView.setLoadingIndicator(false);

                } else {

                    if (!mNewsView.isActive()) {
                        return;
                    }

                    mNewsView.setLoadingIndicator(false);

                    mNewsView.showMessage("Tu voto ya se encuentra registrado");

                }
            }

            @Override
            public void onFailure(Call<VoteEntity> call, Throwable t) {

                if (!mNewsView.isActive()) {
                    return;
                }

                mNewsView.setLoadingIndicator(false);

                mNewsView.showMessage("Ocurrió un problema, verifique su conexión a internet");
            }

        });
    }

    @Override
    public void getpercent() {

        mNewsView.setLoadingIndicator(true);

        final ChartRequest newsRequest =
                ServiceGeneratorSimple.createService(ChartRequest.class);

        Call<ArrayList<VoteResultEntity>> call = newsRequest.getresult();

        call.enqueue(new Callback<ArrayList<VoteResultEntity>>() {
            @Override
            public void onResponse(Call<ArrayList<VoteResultEntity>> call, Response<ArrayList<VoteResultEntity>> response) {
                if (response.isSuccessful()) {

                    VoteResultEntity voteResultEntity =response.body().get(0);
                    mNewsView.showPorcentajes(voteResultEntity.getVote_countcachay(),voteResultEntity.getVote_countvilla(),
                            voteResultEntity.getVote_countnule());

                    if (!mNewsView.isActive()) {
                        return;
                    }

                    mNewsView.setLoadingIndicator(false);

                } else {

                    if (!mNewsView.isActive()) {
                        return;
                    }

                    mNewsView.setLoadingIndicator(false);

                    mNewsView.showMessage("No se pudo cargar la información, inténtelo nuevamente ");

                }
            }

            @Override
            public void onFailure(Call<ArrayList<VoteResultEntity>> call, Throwable t) {

                if (!mNewsView.isActive()) {
                    return;
                }

                mNewsView.setLoadingIndicator(false);

                mNewsView.showMessage("Ocurrió un problema, verifique su conexión a internet");
            }

        });


    }
}
