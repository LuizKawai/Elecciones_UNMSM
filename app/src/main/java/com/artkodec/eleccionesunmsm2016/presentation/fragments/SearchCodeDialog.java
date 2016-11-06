package com.artkodec.eleccionesunmsm2016.presentation.fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.artkodec.eleccionesunmsm2016.R;
import com.artkodec.eleccionesunmsm2016.presentation.contracts.VoteContract;
import com.artkodec.eleccionesunmsm2016.presentation.utils.Util_Fonts;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Length;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;

import java.util.List;

/**
 * Created by junior on 24/04/16.
 */
public class SearchCodeDialog extends AlertDialog implements Validator.ValidationListener {
    private Validator validator;
    private VoteContract.View editCompanyView;
    private String field;

    @NotEmpty(message = "Este campo no puede ser vacío")
    @Length( min=6,max = 8, message = "Longitud de caracteres no esta entre el rango de 6 a 8 caracteres ")
    EditText editText_parameter;
    Button btn_add_control;
    public SearchCodeDialog(Context context, VoteContract.View editCompanyView, String field){
        super(context);
        this.editCompanyView = editCompanyView;
        this.field=field;
        initDialog();
    }
    private void initDialog() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        final View view = inflater.inflate(R.layout.dialog_address, null);
        setView(view);

        btn_add_control = (Button) view.findViewById(R.id.btn_search);
        editText_parameter = (EditText) view.findViewById(R.id.tv_company_direction);
        editText_parameter.setTypeface(Util_Fonts.setFontLight(getContext()));

        validator = new Validator(this);
        validator.setValidationListener(this);

        btn_add_control.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validator.validate();
            }
        });


    }



    @Override
    public void onValidationSucceeded() {
        this.dismiss();
        if(field.equals("1"))
            editCompanyView.searchVote1(editText_parameter.getText().toString());
        if(field.equals("2"))
            editCompanyView.searchVote2(editText_parameter.getText().toString());
        if(field.equals("3"))
            editCompanyView.searchVote3(editText_parameter.getText().toString());
        if(field.equals("4"))
            editCompanyView.searchVote4(editText_parameter.getText().toString());



    }


    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        for (ValidationError error : errors) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage(getContext());
            // Display error messages ;)
            if (view instanceof EditText) {
                ((EditText) view).setError(message);
            } else {
                Toast.makeText(getContext(),message, Toast.LENGTH_SHORT).show();
            }
        }
    }

}
