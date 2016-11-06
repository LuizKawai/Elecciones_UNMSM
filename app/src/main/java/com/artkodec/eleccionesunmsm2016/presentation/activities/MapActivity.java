package com.artkodec.eleccionesunmsm2016.presentation.activities;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.artkodec.eleccionesunmsm2016.R;
import com.artkodec.eleccionesunmsm2016.data.entities.PointEntity;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by junior on 20/03/16.
 */
public class MapActivity extends AppCompatActivity {


    @BindView(R.id.btn_close)
    ImageButton btnClose;
    @BindView(R.id.btn_car)
    ImageButton btnCar;
    private GoogleMap googleMap;
    private ArrayList<PointEntity> pointEntities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_map);
        ButterKnife.bind(this);
        try {
            pointEntities= new ArrayList<>();
            initArray();
            initilizeMap();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initArray(){
        pointEntities.add(
                new PointEntity(-12.052291, -77.087331,"Facultad de Ingeniería de Minas",1,"Descripcion"));
        pointEntities.add(
                new PointEntity(-12.060683, -77.084689,"Facultad de Ingeniería Geológica",1,"Descripcion"));
        pointEntities.add(
                new PointEntity(-12.060491, -77.084087,"Facultad de Ingeniería Metalúrgica",1,"Descripcion"));
        pointEntities.add(
                new PointEntity(-12.055801, -77.087102,"Facultad de Ingeniería Civil",1,"Descripcion"));
        pointEntities.add(
                new PointEntity(-12.055255, -77.086147,"Facultad de Ingeniería Geográfica",1,"Descripcion"));

        pointEntities.add(
                new PointEntity(-12.053624, -77.087296 , "Facultad de Psicología",1,"Descripcion"));
        pointEntities.add(
                new PointEntity(-12.054401, -77.086031, "Facultad de Ondontología",1,"Descripcion"));
        pointEntities.add(
                new PointEntity(-12.053404, -77.085741, "Facultad de Ingeniería de Sistemas e Informática",1,"Descripcion"));
        /*pointEntities.add(
                new PointEntity(-12.053404, -77.085687,"Instituto de Medicina Tropical",1,"Descripcion"));*/
        pointEntities.add(
                new PointEntity(-12.054747, -77.084915,"Facultad de Educación",1,"Descripcion"));
        pointEntities.add(
                new PointEntity(-12.055460, -77.086953 ,"Facultad de Ingeniería Electrónica",1,"Descripcion"));
        pointEntities.add(
                new PointEntity(-12.055785, -77.085558 ,"Biblioteca Central Pedro Zulen",1,"Descripcion"));
        pointEntities.add(
                new PointEntity(-12.056646, -77.086375 ,"Sede Central Jorge Basadre",1,"Descripcion"));
        pointEntities.add(
                new PointEntity(-12.057737, -77.083264,"Estadio Olímpico de la UNMSM",1,"Descripcion"));
        pointEntities.add(
                new PointEntity(-12.059132, -77.084337 ,"Gimmasio UNMSM",1,"Descripcion"));
        pointEntities.add(
                new PointEntity(-12.060129, -77.083361 ,"Facultad de Química e Ingeniería Química",1,"Descripcion"));
        pointEntities.add(
                new PointEntity(-12.059300, -77.083125,"Comedor Universitario",1,"Descripcion"));
        pointEntities.add(
                new PointEntity(-12.060150, -77.082267 ,"Facultad de Ciencias Matemáticas",1,"Descripcion"));
        pointEntities.add(
                new PointEntity(-12.059783, -77.082085,"Facultad de Ciencias Biológicas",1,"Descripcion"));
        pointEntities.add(
                new PointEntity(-12.059971, -77.081677,"Facultad de Ciencias Físicas",1,"Descripcion"));
        pointEntities.add(
                new PointEntity(-12.059856, -77.080808,"Facultad de Ingeniería Industrial",1,"Descripcion"));
        pointEntities.add(
                new PointEntity(-12.058572, -77.080803, "Facultad de Derecho y Ciencias Políticas",1,"Descripcion"));
        pointEntities.add(
                new PointEntity(-12.057942, -77.080610 ,"Facultad de Ciencias Económicas",1,"Descripcion"));
        pointEntities.add(
                new PointEntity(-12.057806, -77.081597 ,"Facultad de Ciencias Administrativas",1,"Descripcion"));
        pointEntities.add(
                new PointEntity(-12.057229, -77.081297 ,"Facultad de Letras y Ciencias Humanas",1,"Descripcion"));
















    }




    @OnClick(R.id.btn_close)
    public void closeActivity() {
        MapActivity.this.finish();
    }

    private void initilizeMap() {
        if (googleMap == null) {

            googleMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
            googleMap.getUiSettings().setAllGesturesEnabled(true);
            googleMap.getUiSettings().setZoomControlsEnabled(false);

            CameraPosition camPos = new CameraPosition.Builder()
                    .target(new LatLng(-12.058471,
                            -77.084949))
                    .zoom(16)
                    .build();
            if (pointEntities != null)
                for (int i = 0; i < pointEntities.size(); i++) {
               /* if(arrayList.get(i).getC_type().equals("R"))*/
                    googleMap.addMarker(new MarkerOptions()
                            .position(
                                    new LatLng(pointEntities.get(i).getLat(),
                                            pointEntities.get(i).getLon()))
                            .title(pointEntities.get(i).getName())
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
               /* else
                    googleMap.addMarker(new MarkerOptions()
                            .position(
                                    new LatLng(arrayList.get(i).getLocation().getLatitude(),
                                            arrayList.get(i).getLocation().getLongitude()))
                            .title(arrayList.get(i).getAddress())
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));*/
                }
            CameraUpdate camUpd3 = CameraUpdateFactory.newCameraPosition(camPos);
            googleMap.moveCamera(camUpd3);

            if (googleMap == null) {
                Toast.makeText(getApplicationContext(), "Sorry! unable to create maps", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            initilizeMap();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @OnClick({R.id.btn_close, R.id.btn_car})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_close:
                this.finish();
                break;
            case R.id.btn_car:
                break;
        }
    }
}
