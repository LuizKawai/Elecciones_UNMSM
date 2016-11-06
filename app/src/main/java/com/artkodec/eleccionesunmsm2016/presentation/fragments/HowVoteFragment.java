package com.artkodec.eleccionesunmsm2016.presentation.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.artkodec.eleccionesunmsm2016.R;
import com.artkodec.eleccionesunmsm2016.data.entities.CandidateEntitiy;
import com.artkodec.eleccionesunmsm2016.presentation.utils.Util_Fonts;
import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by manu on 01/03/16.
 */
public class HowVoteFragment extends Fragment {




    private CandidateEntitiy newsEntity;

    public static HowVoteFragment newInstance() {

        return new HowVoteFragment();
    }

    public HowVoteFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_vote_how, container, false);
        ButterKnife.bind(this, view);
        return view;
    }




}
