package com.infosupport.domain;

import java.io.Serializable;

public class CompositeKey implements Serializable {

    private int id;
    private long vragenlijst;

    public CompositeKey() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getVragenlijst() {
        return vragenlijst;
    }

    public void setVragenlijst(long vragenlijst) {
        this.vragenlijst = vragenlijst;
    }
}
