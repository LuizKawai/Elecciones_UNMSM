package com.artkodec.eleccionesunmsm2016.presentation.contracts;

import android.support.annotation.NonNull;

import com.artkodec.eleccionesunmsm2016.data.entities.CandidateEntitiy;
import com.artkodec.eleccionesunmsm2016.presentation.core.BasePresenter;
import com.artkodec.eleccionesunmsm2016.presentation.core.BaseView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by junior on 15/07/16.
 */
public interface ContractCandidates {

    interface View extends BaseView<Presenter> {

        void setLoadingIndicator(boolean active);
        void showCandidates(ArrayList<CandidateEntitiy> candidateEntitiys);
        void showCandidateDetailsUi(CandidateEntitiy candidateEntitiy);
        void showMessage(String msg);
        void showLoadingNewsError();
        boolean isActive();

    }

    interface Presenter extends BasePresenter {

        void loadNews(boolean forceUpdate);
        void openNewsDetails(@NonNull CandidateEntitiy candidateEntitiy);

    }
}
