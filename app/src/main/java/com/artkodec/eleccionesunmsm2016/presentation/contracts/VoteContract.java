package com.artkodec.eleccionesunmsm2016.presentation.contracts;

import android.support.annotation.NonNull;

import com.artkodec.eleccionesunmsm2016.data.entities.MemberEntity;
import com.artkodec.eleccionesunmsm2016.data.entities.PosgradeEntity;
import com.artkodec.eleccionesunmsm2016.data.entities.StudentEntity;
import com.artkodec.eleccionesunmsm2016.data.entities.TeacherEntity;
import com.artkodec.eleccionesunmsm2016.presentation.core.BasePresenter;
import com.artkodec.eleccionesunmsm2016.presentation.core.BaseView;


/**
 * Created by junior on 11/07/16.
 */
public interface VoteContract {

    interface View extends BaseView<Presenter> {

        void setLoadingIndicator(boolean active);

        void showLoadingError(@NonNull String error);

        void registerSucessfully1(StudentEntity studentEntity);
        void registerSucessfully2(PosgradeEntity posgradeEntity);
        void registerSucessfully3(TeacherEntity teacherEntity);
        void registerSucessfully4(MemberEntity memberEntity);
        void searchVote1(@NonNull String code);
        void searchVote2(@NonNull String code);
        void searchVote3(@NonNull String code);
        void searchVote4(@NonNull String code);


        boolean isActive();
    }

    interface Presenter extends BasePresenter {

        void searchVote1(@NonNull String code);
        void searchVote2(@NonNull String code);
        void searchVote3(@NonNull String code);
        void searchVote4(@NonNull String code);

    }
}
