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
public class DetailCandidateFragment extends Fragment {

    public static final String EXTRA_NEWS = "NEW_PARAMETER";
    @BindView(R.id.image_news)
    ImageView imageNews;
    @BindView(R.id.candidate_title)
    TextView candidateTitle;
    @BindView(R.id.party_title)
    TextView partyTitle;
    @BindView(R.id.tv_ola_morada)
    TextView tvOlaMorada;
    @BindView(R.id.news_description)
    TextView newsDescription;
    @BindView(R.id.image_candidate)
    ImageView imageCandidate;
    @BindView(R.id.biografia_description)
    TextView biografiaDescription;
    @BindView(R.id.iv_logo)
    ImageView ivLogo;
    @BindView(R.id.proposal)
    TextView proposal;


    private CandidateEntitiy newsEntity;

    public static DetailCandidateFragment newInstance(CandidateEntitiy newsEntity) {

        Bundle arguments = new Bundle();
        arguments.putSerializable(EXTRA_NEWS, newsEntity);
        DetailCandidateFragment fragment = new DetailCandidateFragment();
        fragment.setArguments(arguments);
        return fragment;
    }

    public DetailCandidateFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        Bundle arg = getArguments();
        newsEntity = (CandidateEntitiy) arg.getSerializable(EXTRA_NEWS);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.layout_detail_news, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Glide.with(getContext()).load(newsEntity.getImg3())
                .into(imageNews);
        Glide.with(getContext()).load(newsEntity.getImg2())
                .into(ivLogo);
        Glide.with(getContext()).load(newsEntity.getImg1())
                .into(imageCandidate);

        biografiaDescription.setText(newsEntity.getBiography());

        String content =  "";

        for (int i = 0; i < newsEntity.getProposals().size(); i++) {
            content = content +  (i + 1) + ". " + newsEntity.getProposals().get(i)+"\n";
        }


        newsDescription.setText(newsEntity.getInfo_party() );
        candidateTitle.setText(newsEntity.getName());
        partyTitle.setText(newsEntity.getParty_name());
        proposal.setText(content);

        newsDescription.setTypeface(Util_Fonts.setFontLight(getContext()));
        proposal.setTypeface(Util_Fonts.setFontLight(getContext()));
        biografiaDescription.setTypeface(Util_Fonts.setFontLight(getContext()));
        candidateTitle.setTypeface(Util_Fonts.setFontLight(getContext()));
        partyTitle.setTypeface(Util_Fonts.setFontLight(getContext()));

    }


}
