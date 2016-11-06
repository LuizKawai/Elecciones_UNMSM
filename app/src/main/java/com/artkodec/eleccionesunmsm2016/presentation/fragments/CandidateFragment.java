package com.artkodec.eleccionesunmsm2016.presentation.fragments;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.artkodec.eleccionesunmsm2016.R;
import com.artkodec.eleccionesunmsm2016.data.entities.CandidateEntitiy;
import com.artkodec.eleccionesunmsm2016.presentation.activities.CHartActivity;
import com.artkodec.eleccionesunmsm2016.presentation.activities.ComparadeActivity;
import com.artkodec.eleccionesunmsm2016.presentation.activities.DetailCandidateActivity;
import com.artkodec.eleccionesunmsm2016.presentation.activities.MainActivity;
import com.artkodec.eleccionesunmsm2016.presentation.adapters.CandidatesAdapter;
import com.artkodec.eleccionesunmsm2016.presentation.contracts.ContractCandidates;
import com.artkodec.eleccionesunmsm2016.presentation.core.BaseFragment;
import com.artkodec.eleccionesunmsm2016.presentation.presenters.CandidatesPresenter;
import com.artkodec.eleccionesunmsm2016.presentation.presenters.commons.CommunicatePresenterCandidatesItem;
import com.artkodec.eleccionesunmsm2016.presentation.utils.AuthLocalData;
import com.artkodec.eleccionesunmsm2016.presentation.utils.ScrollChildSwipeRefreshLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by junior on 15/07/16.
 */
public class CandidateFragment extends BaseFragment implements ContractCandidates.View {


    @BindView(R.id.candi_list)
    RecyclerView candiList;
    @BindView(R.id.candidateLL)
    LinearLayout candidateLL;
    @BindView(R.id.noNewsMain)
    TextView noNewsMain;
    @BindView(R.id.noNews)
    LinearLayout noNews;
    @BindView(R.id.candidateContainer)
    RelativeLayout candidateContainer;
    @BindView(R.id.refresh_layout)
    ScrollChildSwipeRefreshLayout refreshLayout;
    @BindView(R.id.btn_cmp)
    Button btnCmp;
    private Unbinder unbinder;
    private ContractCandidates.Presenter mPresenter;
    private CandidatesAdapter candidatesAdapter;
    private LinearLayoutManager linearLayoutManager;

    public static CandidateFragment newInstance() {
        return new CandidateFragment();
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
        initView();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new CandidatesPresenter(this, getContext());
        AuthLocalData authLocalData = new AuthLocalData(getContext());
        if (!authLocalData.isLogin()) {
            AlertDialog alertDialog = AskOption();
            alertDialog.show();
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.layout_candidates, container, false);
        unbinder = ButterKnife.bind(this, root);
        noNews.setVisibility(View.GONE);

        // Set up progress indicator
        final ScrollChildSwipeRefreshLayout swipeRefreshLayout =
                (ScrollChildSwipeRefreshLayout) root.findViewById(R.id.refresh_layout);
        swipeRefreshLayout.setColorSchemeColors(
                ContextCompat.getColor(getActivity(), R.color.colorPrimary),
                ContextCompat.getColor(getActivity(), R.color.colorAccent),
                ContextCompat.getColor(getActivity(), R.color.colorPrimaryDark)
        );
        // Set the scrolling view in the custom SwipeRefreshLayout.
        swipeRefreshLayout.setScrollUpChild(candiList);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.loadNews(true);
            }
        });
        return root;
    }

    @Override
    protected void initView() {
        super.initView();

        setHasOptionsMenu(true);
        mPresenter = new CandidatesPresenter(this, getContext());
        candiList.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        candiList.setLayoutManager(linearLayoutManager);
        candidatesAdapter = new CandidatesAdapter(getContext(), new ArrayList<CandidateEntitiy>(), (CommunicatePresenterCandidatesItem) mPresenter);
        candiList.setAdapter(candidatesAdapter);

    }

    private AlertDialog AskOption() {
        AlertDialog myQuittingDialogBox = new AlertDialog.Builder(getContext())
                //set message, title, and icon
                .setTitle("Encuesta")
                .setMessage("Colabora con tu voto en la encuesta para la elección de nuestro rector")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {
                        Intent intent = new Intent(getContext(), CHartActivity.class);
                        startActivity(intent);
                    }

                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();

                    }
                })
                .create();

        return myQuittingDialogBox;

    }


    @Override
    public void setPresenter(ContractCandidates.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @Override
    public void setLoadingIndicator(final boolean active) {
        if (getView() == null) {
            return;
        }
        final SwipeRefreshLayout srl =
                (SwipeRefreshLayout) getView().findViewById(R.id.refresh_layout);

        // Make sure setRefreshing() is called after the layout is done with everything else.
        srl.post(new Runnable() {
            @Override
            public void run() {
                srl.setRefreshing(active);
            }
        });
    }

    @Override
    public void showCandidates(ArrayList<CandidateEntitiy> candidateEntitiys) {
        candidatesAdapter = new CandidatesAdapter(getContext(), candidateEntitiys, (CommunicatePresenterCandidatesItem) mPresenter);

        if (candiList != null) {

            candiList.setAdapter(candidatesAdapter);
        }
    }

    @Override
    public void showCandidateDetailsUi(CandidateEntitiy candidateEntitiy) {
        Intent intent = new Intent(getContext(), DetailCandidateActivity.class);
        intent.putExtra(DetailCandidateActivity.EXTRA_NEWS, candidateEntitiy);
        startActivity(intent);
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoadingNewsError() {
        showMessage("No se pudo cargar la lista de candidatos");
    }

    @Override
    public boolean isActive() {
        return isAdded();
    }


    @OnClick(R.id.btn_cmp)
    public void onClick() {
        Intent intent = new Intent(getContext(), ComparadeActivity.class);
        startActivity(intent);

    }
}
