package com.artkodec.eleccionesunmsm2016.data.repositories.remote.request;


import com.artkodec.eleccionesunmsm2016.data.entities.CandidateEntitiy;
import com.artkodec.eleccionesunmsm2016.data.entities.MemberEntity;
import com.artkodec.eleccionesunmsm2016.data.entities.PosgradeEntity;
import com.artkodec.eleccionesunmsm2016.data.entities.StudentEntity;
import com.artkodec.eleccionesunmsm2016.data.entities.TeacherEntity;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by junior on 24/04/16.
 */
public interface StudentRequest {
    @GET("student/{id}/")
    Call<ArrayList<StudentEntity>> getStudent(@Path("id") String cod);
    @GET("posgrado/{id}/")
    Call<ArrayList<PosgradeEntity>> getPosgrado(@Path("id") String cod);
    @GET("teacher/{id}/")
    Call<ArrayList<TeacherEntity>> getTeacher(@Path("id") String cod);
    @GET("member/{id}/")
    Call<ArrayList<MemberEntity>> getMember(@Path("id") String cod);




}
