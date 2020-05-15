package com.controller.requests;

public class PositionRequest {
    private int id;
    private String getName;
    private String getResponsibilities;
    private int getDivisionId;
    private String getDivisionName;

    private String postName;
    private int postDivisionId;
    private String postResponsibilities;

    public String getGetDivisionName() {
        return getDivisionName;
    }

    public void setGetDivisionName(String getDivisionName) {
        this.getDivisionName = getDivisionName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGetDivisionId() {
        return getDivisionId;
    }

    public void setGetDivisionId(int getDivisionId) {
        this.getDivisionId = getDivisionId;
    }

    public String getGetName() {
        return getName;
    }

    public void setGetName(String getName) {
        this.getName = getName;
    }

    public String getGetResponsibilities() {
        return getResponsibilities;
    }

    public void setGetResponsibilities(String getResponsibilities) {
        this.getResponsibilities = getResponsibilities;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public int getPostDivisionId() {
        return postDivisionId;
    }

    public void setPostDivisionId(int postDivisionId) {
        this.postDivisionId = postDivisionId;
    }

    public String getPostResponsibilities() {
        return postResponsibilities;
    }

    public void setPostResponsibilities(String postResponsibilities) {
        this.postResponsibilities = postResponsibilities;
    }
}
