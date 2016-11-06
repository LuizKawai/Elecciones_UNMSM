package com.artkodec.eleccionesunmsm2016.data.entities;

import java.io.Serializable;

/**
 * Created by junior on 15/07/16.
 */
public class PointEntity implements Serializable{
    private double lat;
    private double lon;
    private String name;
    private String description;
    private int image;

    public PointEntity(double lat, double lon, String name, int image,String description ) {
        this.lat = lat;
        this.lon = lon;
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
