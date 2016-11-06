package com.artkodec.eleccionesunmsm2016.data.repositories.remote.request;


import com.artkodec.eleccionesunmsm2016.data.entities.VoteEntity;
import com.artkodec.eleccionesunmsm2016.data.entities.VoteResultEntity;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by junior on 24/04/16.
 */
public interface ChartRequest {
    @FormUrlEncoded
    @POST("logisticreate/")
    Call<VoteEntity> vote(@Field("vote") String vote,@Field("id") String id );

    @GET("logistic/")
    Call<ArrayList<VoteResultEntity>> getresult();




}
