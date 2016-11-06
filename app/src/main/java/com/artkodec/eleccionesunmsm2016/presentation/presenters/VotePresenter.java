package com.artkodec.eleccionesunmsm2016.presentation.presenters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.artkodec.eleccionesunmsm2016.data.entities.MemberEntity;
import com.artkodec.eleccionesunmsm2016.data.entities.PosgradeEntity;
import com.artkodec.eleccionesunmsm2016.data.entities.StudentEntity;
import com.artkodec.eleccionesunmsm2016.data.entities.TeacherEntity;
import com.artkodec.eleccionesunmsm2016.data.repositories.remote.ServiceGeneratorSimple;
import com.artkodec.eleccionesunmsm2016.data.repositories.remote.request.StudentRequest;
import com.artkodec.eleccionesunmsm2016.presentation.contracts.VoteContract;
import com.artkodec.eleccionesunmsm2016.presentation.fragments.MemberDialogShow;
import com.artkodec.eleccionesunmsm2016.presentation.fragments.PosgradoDialogShow;
import com.artkodec.eleccionesunmsm2016.presentation.fragments.StudentDialogShow;
import com.artkodec.eleccionesunmsm2016.presentation.fragments.TeacherDialogShow;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by junior on 11/07/16.
 */
public class VotePresenter implements VoteContract.Presenter {

    private final VoteContract.View mRegisterView;
    private Context context;



    public VotePresenter(
            @NonNull VoteContract.View authView, @NonNull Context context) {
        this.mRegisterView = checkNotNull(authView, "mAuthView cannot be null!");
        this.context = checkNotNull(context, "mAuthView cannot be null!");
        this.mRegisterView.setPresenter(this);

    }



    @Override
    public void start() {

    }

    @Override
    public void searchVote1(@NonNull String code) {
        StudentRequest studentRequest =
                ServiceGeneratorSimple.createService(StudentRequest.class);
        Call<ArrayList<StudentEntity>> call = studentRequest.getStudent(code);
        mRegisterView.setLoadingIndicator(true);
        call.enqueue(new Callback<ArrayList<StudentEntity>>() {
            @Override
            public void onResponse(Call<ArrayList<StudentEntity>> call, Response<ArrayList<StudentEntity>> response) {
                if (response.isSuccessful()) {


                    if(response.body().size()>0){
                        mRegisterView.setLoadingIndicator(false);
                        mRegisterView.registerSucessfully1(response.body().get(0));
                    }else{
                        mRegisterView.setLoadingIndicator(false);
                        mRegisterView.showLoadingError("No se encontró ningún resultado");
                    }
                } else {
                    mRegisterView.setLoadingIndicator(false);
                    mRegisterView.showLoadingError("No se encontró ningún resultado");
                }
            }

            @Override
            public void onFailure(Call<ArrayList<StudentEntity>> call, Throwable t) {
                mRegisterView.setLoadingIndicator(false);
                mRegisterView.showLoadingError("No se pudo conectar al servidor, revise su conexión a internet");
            }
        });
    }

    @Override
    public void searchVote2(@NonNull String code) {
        StudentRequest studentRequest =
                ServiceGeneratorSimple.createService(StudentRequest.class);
        Call<ArrayList<PosgradeEntity>> call = studentRequest.getPosgrado(code);
        mRegisterView.setLoadingIndicator(true);
        call.enqueue(new Callback<ArrayList<PosgradeEntity>>() {
            @Override
            public void onResponse(Call<ArrayList<PosgradeEntity>> call, Response<ArrayList<PosgradeEntity>> response) {
                if (response.isSuccessful()) {

                    if(response.body().size()>0){
                        mRegisterView.setLoadingIndicator(false);
                        mRegisterView.registerSucessfully2(response.body().get(0));
                    }else{
                        mRegisterView.setLoadingIndicator(false);
                        mRegisterView.showLoadingError("No se encontró ningún resultado");
                    }
                } else {
                    mRegisterView.setLoadingIndicator(false);
                    mRegisterView.showLoadingError("No se encontró ningún resultado");
                }
            }

            @Override
            public void onFailure(Call<ArrayList<PosgradeEntity>> call, Throwable t) {
                mRegisterView.setLoadingIndicator(false);
                mRegisterView.showLoadingError("No se pudo conectar al servidor, revise su conexión a internet");
            }
        });
    }

    @Override
    public void searchVote3(@NonNull String code) {
        StudentRequest studentRequest =
                ServiceGeneratorSimple.createService(StudentRequest.class);
        Call<ArrayList<TeacherEntity>> call = studentRequest.getTeacher(code);
        mRegisterView.setLoadingIndicator(true);
        call.enqueue(new Callback<ArrayList<TeacherEntity>>() {
            @Override
            public void onResponse(Call<ArrayList<TeacherEntity>> call, Response<ArrayList<TeacherEntity>> response) {
                if (response.isSuccessful()) {

                    if(response.body().size()>0){
                        mRegisterView.setLoadingIndicator(false);
                        mRegisterView.registerSucessfully3(response.body().get(0));
                    }else{
                        mRegisterView.setLoadingIndicator(false);
                        mRegisterView.showLoadingError("No se encontró ningún resultado");
                    }
                } else {
                    mRegisterView.setLoadingIndicator(false);
                    mRegisterView.showLoadingError("No se encontró ningún resultado");
                }
            }

            @Override
            public void onFailure(Call<ArrayList<TeacherEntity>> call, Throwable t) {
                mRegisterView.setLoadingIndicator(false);
                mRegisterView.showLoadingError("No se pudo conectar al servidor, revise su conexión a internet");
            }
        });
    }

    @Override
    public void searchVote4(@NonNull String code) {
        StudentRequest studentRequest =
                ServiceGeneratorSimple.createService(StudentRequest.class);
        Call<ArrayList<MemberEntity>> call = studentRequest.getMember(code);
        mRegisterView.setLoadingIndicator(true);
        call.enqueue(new Callback<ArrayList<MemberEntity>>() {
            @Override
            public void onResponse(Call<ArrayList<MemberEntity>> call, Response<ArrayList<MemberEntity>> response) {
                if(response.body().size()>0){
                    mRegisterView.setLoadingIndicator(false);
                    mRegisterView.registerSucessfully4(response.body().get(0));
                }else{
                    mRegisterView.setLoadingIndicator(false);
                    mRegisterView.showLoadingError("No se encontró ningún resultado");
                }
            }

            @Override
            public void onFailure(Call<ArrayList<MemberEntity>> call, Throwable t) {
                mRegisterView.setLoadingIndicator(false);
                mRegisterView.showLoadingError("No se pudo conectar al servidor, revise su conexión a internet");
            }
        });
    }
}
