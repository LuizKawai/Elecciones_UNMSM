package com.artkodec.eleccionesunmsm2016.data.entities;

import java.io.Serializable;

/**
 * Created by developer on 22/07/2016.
 */
public class VoteEntity implements Serializable {

    private String id;
    private String vote;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVote() {
        return vote;
    }

    public void setVote(String vote) {
        this.vote = vote;
    }
}
