package com.artkodec.eleccionesunmsm2016.presentation.contracts;

import android.support.annotation.NonNull;

import com.artkodec.eleccionesunmsm2016.data.entities.CandidateEntitiy;
import com.artkodec.eleccionesunmsm2016.data.entities.ProposalEntities;
import com.artkodec.eleccionesunmsm2016.presentation.core.BasePresenter;
import com.artkodec.eleccionesunmsm2016.presentation.core.BaseView;

import java.util.ArrayList;

/**
 * Created by junior on 15/07/16.
 */
public interface ContractProposals {

    interface View extends BaseView<Presenter> {

        void setLoadingIndicator(boolean active);
        void showProposal(ProposalEntities candidateEntitiys);
        void showMessage(String msg);
        void showLoadingNewsError();
        boolean isActive();

    }

    interface Presenter extends BasePresenter {

        void loadProposal(String filter);


    }
}
