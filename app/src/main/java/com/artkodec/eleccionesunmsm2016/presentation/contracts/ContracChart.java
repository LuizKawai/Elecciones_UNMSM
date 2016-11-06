package com.artkodec.eleccionesunmsm2016.presentation.contracts;

import com.artkodec.eleccionesunmsm2016.presentation.core.BasePresenter;
import com.artkodec.eleccionesunmsm2016.presentation.core.BaseView;

/**
 * Created by junior on 15/07/16.
 */
public interface ContracChart {

    interface View extends BaseView<Presenter> {


        void showPorcentajes(double c, double v,double n);
        void showMessage(String msg);
        void setLoadingIndicator(boolean active);
        void showRefreshPercent();
        boolean isActive();

    }

    interface Presenter extends BasePresenter {
        void voteCandidate(int active,String id);
        void getpercent();


    }
}
