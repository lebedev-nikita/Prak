package com.controller;

public class DivisionInfoRequest {
    private String newName;
    private int newHeadDivisionId;
    private int newChiefId;

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public int getNewHeadDivisionId() {
        return newHeadDivisionId;
    }

    public void setNewHeadDivisionId(int newHeadDivisionId) {
        this.newHeadDivisionId = newHeadDivisionId;
    }

    public int getNewChiefId() {
        return newChiefId;
    }

    public void setNewChiefId(int newChiefId) {
        this.newChiefId = newChiefId;
    }
}
