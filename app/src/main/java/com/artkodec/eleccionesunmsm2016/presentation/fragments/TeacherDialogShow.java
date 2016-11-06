package com.artkodec.eleccionesunmsm2016.presentation.fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.artkodec.eleccionesunmsm2016.R;
import com.artkodec.eleccionesunmsm2016.data.entities.TeacherEntity;
import com.artkodec.eleccionesunmsm2016.presentation.utils.Util_Fonts;

import butterknife.BindView;

/**
 * Created by junior on 24/04/16.
 */
public class TeacherDialogShow extends AlertDialog {

    TextView tvCode;
    TextView tvNumber;
    TextView faculty;
    TextView tvTable;
    TextView tvCategory;
    TextView tvName;
    private TeacherEntity teacherEntity;

    public TeacherDialogShow(Context context, TeacherEntity teacherEntity) {
        super(context);
        this.teacherEntity = teacherEntity;
        initDialog();
    }

    private void initDialog() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        final View view = inflater.inflate(R.layout.dialog_teacher, null);
        setView(view);


        tvCode = (TextView) view.findViewById(R.id.tv_code);
        tvNumber = (TextView) view.findViewById(R.id.tv_number);
        faculty = (TextView) view.findViewById(R.id.faculty);
        tvTable = (TextView) view.findViewById(R.id.tv_table);
        tvCategory = (TextView) view.findViewById(R.id.tv_category);
        tvName=(TextView) view.findViewById(R.id.tv_name);
        tvName.setText(teacherEntity.getName());
        tvName.setTypeface(Util_Fonts.setFontLight(getContext()));

        tvCode.setText(teacherEntity.getCode());
        tvNumber.setText(teacherEntity.getNumber());
        faculty.setText(teacherEntity.getFaculty());
        tvTable.setText(teacherEntity.getTable());
        tvCategory.setText(teacherEntity.getTable());


        tvCode.setTypeface(Util_Fonts.setFontLight(getContext()));
        tvNumber.setTypeface(Util_Fonts.setFontLight(getContext()));
        faculty.setTypeface(Util_Fonts.setFontLight(getContext()));
        tvTable.setTypeface(Util_Fonts.setFontLight(getContext()));
        tvCategory.setTypeface(Util_Fonts.setFontLight(getContext()));


    }


}
