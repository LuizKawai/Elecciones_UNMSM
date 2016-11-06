package com.artkodec.eleccionesunmsm2016.presentation.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.artkodec.eleccionesunmsm2016.R;
import com.artkodec.eleccionesunmsm2016.data.entities.MemberEntity;
import com.artkodec.eleccionesunmsm2016.data.entities.PosgradeEntity;
import com.artkodec.eleccionesunmsm2016.data.entities.StudentEntity;
import com.artkodec.eleccionesunmsm2016.data.entities.TeacherEntity;
import com.artkodec.eleccionesunmsm2016.presentation.activities.VoteActivity;
import com.artkodec.eleccionesunmsm2016.presentation.contracts.VoteContract;
import com.artkodec.eleccionesunmsm2016.presentation.core.BaseFragment;
import com.artkodec.eleccionesunmsm2016.presentation.utils.Util_Fonts;
import com.mobsandgeeks.saripaar.Validator;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by junior on 11/07/16.
 */
public class VoteFragment extends BaseFragment implements VoteContract.View {


    @BindView(R.id.floro)
    TextView floro;
    @BindView(R.id.btn_1)
    Button btn1;
    @BindView(R.id.btn_2)
    Button btn2;
    @BindView(R.id.btn_3)
    Button btn3;
    @BindView(R.id.btn_4)
    Button btn4;
    private Unbinder unbinder;
    ProgressDialog progressDialog;
    private Validator validator;
    private VoteContract.Presenter mPresenter;
    private SearchCodeDialog searchCodeDialog;
    private StudentDialogShow studentDialogShow;
    private TeacherDialogShow teacherDialogShow;
    private MemberDialogShow memberDialogShow;
    private PosgradoDialogShow posgradoDialogShow;

    public static VoteFragment newInstance() {
        return new VoteFragment();
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
        initView();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_vote, container, false);
        unbinder = ButterKnife.bind(this, root);
        return root;
    }

    @Override
    protected void initView() {
        super.initView();
        setHasOptionsMenu(true);
        floro.setTypeface(Util_Fonts.setFontLight(getContext()));

        progressDialog = new ProgressDialog(getContext());
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Buscando");
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

    /**
     * Call the method for register user from menu OK
     */
    public void registerUser() {
        validator.validate();
    }

    @Override
    public void showLoadingError(@NonNull String error) {
        ((VoteActivity) getActivity()).showMessageError(error);
    }

    @Override
    public void registerSucessfully1(StudentEntity studentEntity) {
        studentDialogShow = new StudentDialogShow(getContext(),studentEntity);
        studentDialogShow.show();
    }

    @Override
    public void registerSucessfully2(PosgradeEntity posgradeEntity) {
        posgradoDialogShow= new PosgradoDialogShow(getContext(),posgradeEntity);
        posgradoDialogShow.show();
    }

    @Override
    public void registerSucessfully3(TeacherEntity teacherEntity) {
        teacherDialogShow = new TeacherDialogShow(getContext(),teacherEntity);
        teacherDialogShow.show();
    }

    @Override
    public void registerSucessfully4(MemberEntity memberEntity) {
        memberDialogShow = new MemberDialogShow(getContext(),memberEntity);
        memberDialogShow.show();

    }


    @Override
    public void searchVote1(@NonNull String code) {
        mPresenter.searchVote1(code);
    }

    @Override
    public void searchVote2(@NonNull String code) {
        mPresenter.searchVote2(code);
    }

    @Override
    public void searchVote3(@NonNull String code) {
        mPresenter.searchVote3(code);
    }

    @Override
    public void searchVote4(@NonNull String code) {
        mPresenter.searchVote4(code);
    }


    @Override
    public boolean isActive() {
        return isAdded();
    }

    @Override
    public void setPresenter(VoteContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @OnClick({R.id.btn_1, R.id.btn_2, R.id.btn_3,R.id.btn_4})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_1:
                searchCodeDialog = new SearchCodeDialog(getContext(),this,"1");
                searchCodeDialog.show();
                break;
            case R.id.btn_2:
                searchCodeDialog = new SearchCodeDialog(getContext(),this,"2");
                searchCodeDialog.show();
                break;
            case R.id.btn_3:
                searchCodeDialog = new SearchCodeDialog(getContext(),this,"3");
                searchCodeDialog.show();
                break;
            case R.id.btn_4:
                searchCodeDialog = new SearchCodeDialog(getContext(),this,"4");
                searchCodeDialog.show();
                break;
        }
    }
}
