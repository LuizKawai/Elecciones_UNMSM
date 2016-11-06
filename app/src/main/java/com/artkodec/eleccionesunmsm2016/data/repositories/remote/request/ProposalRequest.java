package com.artkodec.eleccionesunmsm2016.data.repositories.remote.request;


import com.artkodec.eleccionesunmsm2016.data.entities.CandidateEntitiy;
import com.artkodec.eleccionesunmsm2016.data.entities.ProposalEntities;

import java.lang.reflect.Array;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by junior on 24/04/16.
 */
public interface ProposalRequest {
    @GET("proposal/{id}")
    Call<ArrayList<ProposalEntities>> getCandidate(@Path("id") String filter);




}
