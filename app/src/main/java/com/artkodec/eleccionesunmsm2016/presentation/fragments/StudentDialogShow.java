package com.artkodec.eleccionesunmsm2016.presentation.fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.artkodec.eleccionesunmsm2016.R;
import com.artkodec.eleccionesunmsm2016.data.entities.StudentEntity;
import com.artkodec.eleccionesunmsm2016.presentation.utils.Util_Fonts;
import com.bumptech.glide.util.Util;
import com.mobsandgeeks.saripaar.Validator;

import butterknife.BindView;

/**
 * Created by junior on 24/04/16.
 */
public class StudentDialogShow extends AlertDialog  {

    TextView tvCode;
    TextView tvNumber;
    TextView faculty;
    TextView tvTable;
    TextView tvName;
    private StudentEntity studentEntity;

    public StudentDialogShow(Context context, StudentEntity studentEntity) {
        super(context);
        this.studentEntity=studentEntity;
        initDialog();
    }

    private void initDialog() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        final View view = inflater.inflate(R.layout.dialog_student, null);
        setView(view);


        tvCode = (TextView) view.findViewById(R.id.tv_code);
        tvNumber = (TextView) view.findViewById(R.id.tv_number);
        faculty = (TextView) view.findViewById(R.id.faculty);
        tvTable = (TextView) view.findViewById(R.id.tv_table);

        tvCode.setText(studentEntity.getCode());
        tvNumber.setText(studentEntity.getNumber());
        faculty.setText(studentEntity.getFaculty());
        tvTable.setText(studentEntity.getTable());

        tvCode.setTypeface(Util_Fonts.setFontLight(getContext()));
        tvNumber.setTypeface(Util_Fonts.setFontLight(getContext()));
        faculty.setTypeface(Util_Fonts.setFontLight(getContext()));
        tvTable.setTypeface(Util_Fonts.setFontLight(getContext()));
        tvName=(TextView) view.findViewById(R.id.tv_name);
        tvName.setText(studentEntity.getName());
        tvName.setTypeface(Util_Fonts.setFontLight(getContext()));


    }


}
