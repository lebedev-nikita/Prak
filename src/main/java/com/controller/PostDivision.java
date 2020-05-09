package com.controller;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PostDivision {
    private String name;
    private int headDivId;
    private int chiefId;

    public PostDivision() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeadDivId() {
        return headDivId;
    }

    public void setHeadDivId(int headDivId) {
        this.headDivId = headDivId;
    }

    public int getChiefId() {
        return chiefId;
    }

    public void setChiefId(int chiefId) {
        this.chiefId = chiefId;
    }
}
