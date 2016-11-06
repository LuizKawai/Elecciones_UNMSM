package com.artkodec.eleccionesunmsm2016.data.entities;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by junior on 15/07/16.
 */
public class CandidateEntitiy implements Serializable {

    private String id;
    private String name;
    private String party_name;
    private String biography;
    private String img1;
    private String img2;
    private String img3;
    private ArrayList<String> proposals;
    private String info_party;

    public String getInfo_party() {
        return info_party;
    }

    public void setInfo_party(String info_party) {
        this.info_party = info_party;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParty_name() {
        return party_name;
    }

    public void setParty_name(String party_name) {
        this.party_name = party_name;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public String getImg3() {
        return img3;
    }

    public void setImg3(String img3) {
        this.img3 = img3;
    }

    public ArrayList<String> getProposals() {
        return proposals;
    }

    public void setProposals(ArrayList<String> proposals) {
        this.proposals = proposals;
    }
}
