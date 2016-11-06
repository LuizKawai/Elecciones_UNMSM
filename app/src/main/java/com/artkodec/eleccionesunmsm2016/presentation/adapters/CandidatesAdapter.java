package com.artkodec.eleccionesunmsm2016.presentation.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.artkodec.eleccionesunmsm2016.R;
import com.artkodec.eleccionesunmsm2016.data.entities.CandidateEntitiy;
import com.artkodec.eleccionesunmsm2016.presentation.presenters.commons.CommunicatePresenterCandidatesItem;
import com.artkodec.eleccionesunmsm2016.presentation.utils.Util_Fonts;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by junior on 27/05/16.
 */
public class CandidatesAdapter extends RecyclerView.Adapter<CandidatesAdapter.ViewHolder> implements ClickCandidateListener {



    private Context context;
    private ArrayList<CandidateEntitiy> companyEntities;
    private LayoutInflater inflater;
    CommunicatePresenterCandidatesItem communicatePresenterCompanyItem;

    LinearLayout linearLayout;
    LinearLayout normalLayout;

    public CandidatesAdapter(Context context, ArrayList<CandidateEntitiy> companyEntities, CommunicatePresenterCandidatesItem communicatePresenterCandidatesItem) {
        this.context = context;
        this.companyEntities = companyEntities;
        this.inflater = LayoutInflater.from(context);
        this.communicatePresenterCompanyItem = communicatePresenterCandidatesItem;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_company, parent, false);
        return new ViewHolder(v, this);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CandidateEntitiy candidateEntitiy = companyEntities.get(position);

        holder.tvCandidateName.setText(candidateEntitiy.getName());
        holder.tvMatchName.setText(candidateEntitiy.getParty_name());

        holder.tvCandidateName.setTypeface(Util_Fonts.setFontNormal(context));
        holder.tvMatchName.setTypeface(Util_Fonts.setFontLight(context));



        if (candidateEntitiy.getImg1() != null)
            Glide.with(context).load(candidateEntitiy.getImg1()).into(holder.logoCompany);
        else{
            // Glide.clear(holder.logoCompany);
            // remove the placeholder (optional); read comments below
            holder.logoCompany.setImageDrawable(null);
        }
        /*holder.tvNameCompany.setText(UtilString.capitalizeFirstLetter(companyEntity.getName()));
        holder.tvDetailCompany.setTypeface(Util_Fonts.setFontLight(context));
        holder.tvNameCompany.setTypeface(Util_Fonts.setFontNormal(context));
        holder.tvNumLikes.setTypeface(Util_Fonts.setFontLight(context));
        holder.tvWeRecycle.setTypeface(Util_Fonts.setFontLight(context));
        holder.tv_s_d_f.setTypeface(Util_Fonts.setFontLight(context));
        holder.tv_l_m.setTypeface(Util_Fonts.setFontLight(context));
        holder.tvPhone.setTypeface(Util_Fonts.setFontLight(context));


            Glide.with(context).load(companyEntity.getPhoto()).into(holder.logoCompany);*/


    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return companyEntities.size();
    }


    @Override
    public void onClick(int position) {
        CandidateEntitiy companyEntity = companyEntities.get(position);
        communicatePresenterCompanyItem.clickItem(companyEntity);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.logo_company)
        ImageView logoCompany;
        @BindView(R.id.tv_candidate_name)
        TextView tvCandidateName;
        @BindView(R.id.tv_match_name)
        TextView tvMatchName;


        ClickCandidateListener clickCandidateListener;

        public ViewHolder(View view, ClickCandidateListener clickCandidateListener) {
            super(view);
            this.clickCandidateListener = clickCandidateListener;
            ButterKnife.bind(this, view);
            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {
            clickCandidateListener.onClick(getAdapterPosition());
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
