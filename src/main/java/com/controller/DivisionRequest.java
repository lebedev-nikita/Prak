package com.controller;

public class DivisionRequest {
    private String getName;
    private String postName;
    private String headDivName;
    private String chiefName;
    private String chiefSurname;
    private String chiefPatronymic;
    private int headDivId;

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

    private int chiefId;

    public DivisionRequest() {}

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getGetName() {
        return getName;
    }

    public void setGetName(String getName) {
        this.getName = getName;
    }

    public String getHeadDivName() {
        return headDivName;
    }

    public void setHeadDivName(String headDivName) {
        this.headDivName = headDivName;
    }

    public String getChiefName() {
        return chiefName;
    }

    public void setChiefName(String chiefName) {
        this.chiefName = chiefName;
    }

    public String getChiefSurname() {
        return chiefSurname;
    }

    public void setChiefSurname(String chiefSurname) {
        this.chiefSurname = chiefSurname;
    }

    public String getChiefPatronymic() {
        return chiefPatronymic;
    }

    public void setChiefPatronymic(String chiefPatronymic) {
        this.chiefPatronymic = chiefPatronymic;
    }
}
