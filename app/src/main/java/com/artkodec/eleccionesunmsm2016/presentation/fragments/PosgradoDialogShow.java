package com.artkodec.eleccionesunmsm2016.presentation.fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.artkodec.eleccionesunmsm2016.R;
import com.artkodec.eleccionesunmsm2016.data.entities.PosgradeEntity;
import com.artkodec.eleccionesunmsm2016.data.entities.StudentEntity;
import com.artkodec.eleccionesunmsm2016.presentation.utils.Util_Fonts;

/**
 * Created by junior on 24/04/16.
 */
public class PosgradoDialogShow extends AlertDialog  {

    TextView tvCode;
    TextView tvNumber;
    TextView faculty;
    TextView tvTable;
    TextView tvName;
    private PosgradeEntity posgradeEntity;

    public PosgradoDialogShow(Context context, PosgradeEntity posgradeEntity) {
        super(context);
        this.posgradeEntity =posgradeEntity;
        initDialog();
    }

    private void initDialog() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        final View view = inflater.inflate(R.layout.dialog_posgrado, null);
        setView(view);


        tvCode = (TextView) view.findViewById(R.id.tv_code);
        tvNumber = (TextView) view.findViewById(R.id.tv_number);
        faculty = (TextView) view.findViewById(R.id.faculty);
        tvTable = (TextView) view.findViewById(R.id.tv_table);

        tvCode.setText(posgradeEntity.getCode());
        tvNumber.setText(posgradeEntity.getNumber());
        faculty.setText(posgradeEntity.getFaculty());
        tvTable.setText(posgradeEntity.getTable());

        tvCode.setTypeface(Util_Fonts.setFontLight(getContext()));
        tvNumber.setTypeface(Util_Fonts.setFontLight(getContext()));
        faculty.setTypeface(Util_Fonts.setFontLight(getContext()));
        tvTable.setTypeface(Util_Fonts.setFontLight(getContext()));
        tvName=(TextView) view.findViewById(R.id.tv_name);
        tvName.setText(posgradeEntity.getName());
        tvName.setTypeface(Util_Fonts.setFontLight(getContext()));


    }


}
