package com.artkodec.eleccionesunmsm2016.data.repositories.remote.request;


import com.artkodec.eleccionesunmsm2016.data.entities.CandidateEntitiy;


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by junior on 24/04/16.
 */
public interface CandidateRequest {
    @GET("candidate/")
    Call<ArrayList<CandidateEntitiy>> getCandidate();




}
