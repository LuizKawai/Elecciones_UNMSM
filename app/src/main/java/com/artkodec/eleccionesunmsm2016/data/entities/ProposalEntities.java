package com.artkodec.eleccionesunmsm2016.data.entities;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by junior on 21/07/16.
 */
public class ProposalEntities implements Serializable {
    private String id;
    private String name;
    private ArrayList<String> proposal_cachay;
    private ArrayList<String> proposal_villa;

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

    public ArrayList<String> getProposal_cachay() {
        return proposal_cachay;
    }

    public void setProposal_cachay(ArrayList<String> proposal_cachay) {
        this.proposal_cachay = proposal_cachay;
    }

    public ArrayList<String> getProposal_villa() {
        return proposal_villa;
    }

    public void setProposal_villa(ArrayList<String> proposal_villa) {
        this.proposal_villa = proposal_villa;
    }
}
