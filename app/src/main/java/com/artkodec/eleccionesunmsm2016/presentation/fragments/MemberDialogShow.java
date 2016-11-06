package com.artkodec.eleccionesunmsm2016.presentation.fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.artkodec.eleccionesunmsm2016.R;
import com.artkodec.eleccionesunmsm2016.data.entities.MemberEntity;
import com.artkodec.eleccionesunmsm2016.presentation.utils.Util_Fonts;

/**
 * Created by junior on 24/04/16.
 */
public class MemberDialogShow extends AlertDialog {

    TextView tvCode;
    TextView tvNumber;
    TextView faculty;
    TextView tvTable;
    TextView tvType;
    TextView tvName;
    private MemberEntity memberEntity;

    public MemberDialogShow(Context context, MemberEntity studentEntity) {
        super(context);
        this.memberEntity = studentEntity;
        initDialog();
    }

    private void initDialog() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        final View view = inflater.inflate(R.layout.dialog_member, null);
        setView(view);


        tvCode = (TextView) view.findViewById(R.id.tv_code);
        tvNumber = (TextView) view.findViewById(R.id.tv_number);
        faculty = (TextView) view.findViewById(R.id.faculty);
        tvTable = (TextView) view.findViewById(R.id.tv_table);
        tvType = (TextView) view.findViewById(R.id.tv_type);;

        tvCode.setText(memberEntity.getCode());
        tvNumber.setText(memberEntity.getNumber());
        faculty.setText(memberEntity.getFaculty());
        tvTable.setText(memberEntity.getTable());
        tvType.setText(memberEntity.getType());

        tvCode.setTypeface(Util_Fonts.setFontLight(getContext()));
        tvNumber.setTypeface(Util_Fonts.setFontLight(getContext()));
        faculty.setTypeface(Util_Fonts.setFontLight(getContext()));
        tvTable.setTypeface(Util_Fonts.setFontLight(getContext()));
        tvType.setTypeface(Util_Fonts.setFontLight(getContext()));
        tvName=(TextView) view.findViewById(R.id.tv_name);
        tvName.setText(memberEntity.getName());
        tvName.setTypeface(Util_Fonts.setFontLight(getContext()));

    }


}
