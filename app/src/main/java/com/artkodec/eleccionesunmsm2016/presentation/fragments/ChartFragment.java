package com.artkodec.eleccionesunmsm2016.presentation.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.artkodec.eleccionesunmsm2016.R;
import com.artkodec.eleccionesunmsm2016.presentation.activities.CHartActivity;
import com.artkodec.eleccionesunmsm2016.presentation.contracts.ContracChart;
import com.artkodec.eleccionesunmsm2016.presentation.core.BaseFragment;
import com.artkodec.eleccionesunmsm2016.presentation.presenters.ChartPresenter;
import com.artkodec.eleccionesunmsm2016.presentation.utils.AuthLocalData;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by junior on 11/07/16.
 */
public class ChartFragment extends BaseFragment implements ContracChart.View {


    @BindView(R.id.selected_overlay1)
    View selectedOverlay1;
    @BindView(R.id.ll_1)
    RelativeLayout ll1;
    @BindView(R.id.selected_overlay2)
    View selectedOverlay2;
    @BindView(R.id.ll_2)
    RelativeLayout ll2;
    @BindView(R.id.btn_vote)
    Button btnVote;
    @BindView(R.id.btn_pin_1)
    ImageView btnPin1;
    @BindView(R.id.btn_pin_2)
    ImageView btnPin2;
    @BindView(R.id.chart)
    PieChart chart;
    @BindView(R.id.selected_overlay3)
    View selectedOverlay3;
    @BindView(R.id.ll_3)
    RelativeLayout ll3;
    private Unbinder unbinder;
    ProgressDialog progressDialog;
    private ContracChart.Presenter mPresenter;
    private int vote = 0;
    int num1, num2;


    public static ChartFragment newInstance() {
        return new ChartFragment();
    }

    @Override
    public void onResume() {
        super.onResume();
        initView();
        mPresenter.start();

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new ChartPresenter(this, getContext());

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_vote_candidate, container, false);
        unbinder = ButterKnife.bind(this, root);
        return root;
    }

    @Override
    protected void initView() {
        super.initView();

        progressDialog = new ProgressDialog(getContext());
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Registrando voto");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(false);
        progressDialog.setIndeterminateDrawable(getResources().getDrawable(R.drawable.circle_progress));


    }

    @Override
    public void setLoadingIndicator(boolean active) {
        if (active) {

            progressDialog.show();
        } else {
            if (progressDialog != null)
                progressDialog.dismiss();
        }
    }

    @Override
    public void showRefreshPercent() {
        mPresenter.getpercent();
        AuthLocalData authLocalData = new AuthLocalData(getContext());
        authLocalData.openSession();
    }


    @Override
    public void showPorcentajes(double c, double v,double n) {
        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new Entry((float) c, 1));
        entries.add(new Entry((float) v, 2));
        entries.add(new Entry((float) n, 3));

        PieDataSet dataset = new PieDataSet(entries, "");
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);
        ArrayList<String> labels = new ArrayList<String>();
        labels.add("Siempre San Marcos\n más independiente ");
        labels.add("Dignidad Sanmarquina");
        labels.add("En Blanco");
        PieData data = new PieData(labels, dataset); // initialize Piedata
        chart.setData(data);
        chart.setDescription("Encuesta por candidato a rector");
        chart.animateY(2000);
        chart.getLegend().setForm(Legend.LegendForm.CIRCLE);


    }

    @Override
    public void showMessage(String msg) {
        ((CHartActivity) getActivity()).showMessageError(msg);
    }

    @Override
    public boolean isActive() {
        return isAdded();
    }

    @Override
    public void setPresenter(ContracChart.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @OnClick({R.id.ll_1, R.id.ll_2,R.id.ll_3})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_1:
                selectedOverlay1.setVisibility(View.VISIBLE);
                selectedOverlay2.setVisibility(View.GONE);
                selectedOverlay3.setVisibility(View.GONE);
                vote = 1;
                break;
            case R.id.ll_2:
                selectedOverlay1.setVisibility(View.GONE);
                selectedOverlay2.setVisibility(View.VISIBLE);
                selectedOverlay3.setVisibility(View.GONE);
                vote = 2;
                break;
            case R.id.ll_3:
                selectedOverlay1.setVisibility(View.GONE);
                selectedOverlay2.setVisibility(View.GONE);
                selectedOverlay3.setVisibility(View.VISIBLE);
                vote = 3;
                break;
        }
    }

    @OnClick(R.id.btn_vote)
    public void onClick() {


        if (vote == 0) {
            showMessage("Seleccione una opción");
        } else {
            String android_id = Settings.Secure.getString(getContext().getContentResolver(),
                    Settings.Secure.ANDROID_ID);
            if (vote == 1) {
                mPresenter.voteCandidate(vote, android_id);
            }
            if (vote == 2) {
                mPresenter.voteCandidate(vote, android_id);
            }
            if (vote == 3) {
                mPresenter.voteCandidate(vote, android_id);
            }

        }

    }



}

