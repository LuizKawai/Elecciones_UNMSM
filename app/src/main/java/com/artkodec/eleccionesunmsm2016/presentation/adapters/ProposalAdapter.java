package com.artkodec.eleccionesunmsm2016.presentation.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.artkodec.eleccionesunmsm2016.R;
import com.artkodec.eleccionesunmsm2016.presentation.presenters.commons.CommunicatePresenterCandidatesItem;
import com.artkodec.eleccionesunmsm2016.presentation.utils.Util_Fonts;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by junior on 27/05/16.
 */
public class ProposalAdapter extends RecyclerView.Adapter<ProposalAdapter.ViewHolder> {


    private Context context;
    private ArrayList<String> companyEntities;
    private LayoutInflater inflater;


    public ProposalAdapter(Context context, ArrayList<String> companyEntities) {
        this.context = context;
        this.companyEntities = companyEntities;
        this.inflater = LayoutInflater.from(context);


    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_proposal, parent, false);
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String candidateEntitiy = companyEntities.get(position);

        holder.text.setText(candidateEntitiy);
        if (position % 2 == 0) {
            holder.itemView.setBackgroundColor(context.getResources().getColor(R.color.colorPrimaryDark));
        } else {
            holder.itemView.setBackgroundColor(context.getResources().getColor(R.color.red));
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


    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.text)
        TextView text;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
