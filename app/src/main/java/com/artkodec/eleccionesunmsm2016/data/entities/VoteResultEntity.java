package com.artkodec.eleccionesunmsm2016.data.entities;

import java.io.Serializable;

/**
 * Created by developer on 22/07/2016.
 */
public class VoteResultEntity implements Serializable {

    private String id;
    private boolean vote;
    private double vote_countcachay;
    private double vote_countvilla;
    private double vote_countnule;

    public double getVote_countnule() {
        return vote_countnule;
    }

    public void setVote_countnule(double vote_countnule) {
        this.vote_countnule = vote_countnule;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isVote() {
        return vote;
    }

    public void setVote(boolean vote) {
        this.vote = vote;
    }

    public double getVote_countcachay() {
        return vote_countcachay;
    }

    public void setVote_countcachay(double vote_countcachay) {
        this.vote_countcachay = vote_countcachay;
    }

    public double getVote_countvilla() {
        return vote_countvilla;
    }

    public void setVote_countvilla(double vote_countvilla) {
        this.vote_countvilla = vote_countvilla;
    }
}
