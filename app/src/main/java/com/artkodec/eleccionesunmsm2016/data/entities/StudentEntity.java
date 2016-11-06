package com.artkodec.eleccionesunmsm2016.data.entities;

import java.io.Serializable;

/**
 * Created by junior on 16/07/16.
 */
public class StudentEntity implements Serializable {

    private String id;
    private String number;
    private String code;
    private String name;
    private String faculty;
    private String table;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }
}
