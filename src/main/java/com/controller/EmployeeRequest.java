package com.controller;

public class EmployeeRequest {
    public String getName;
    public String getSurname;
    public String getPatronymic;
    public String getEducation;

    public String postName;
    public String postSurname;
    public String postPatronymic;
    public String postEducation;

    public int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGetName() {
        return getName;
    }

    public void setGetName(String getName) {
        this.getName = getName;
    }

    public String getGetSurname() {
        return getSurname;
    }

    public void setGetSurname(String getSurname) {
        this.getSurname = getSurname;
    }

    public String getGetPatronymic() {
        return getPatronymic;
    }

    public void setGetPatronymic(String getPatronymic) {
        this.getPatronymic = getPatronymic;
    }

    public String getGetEducation() {
        return getEducation;
    }

    public void setGetEducation(String getEducation) {
        this.getEducation = getEducation;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getPostSurname() {
        return postSurname;
    }

    public void setPostSurname(String postSurname) {
        this.postSurname = postSurname;
    }

    public String getPostPatronymic() {
        return postPatronymic;
    }

    public void setPostPatronymic(String postPatronymic) {
        this.postPatronymic = postPatronymic;
    }

    public String getPostEducation() {
        return postEducation;
    }

    public void setPostEducation(String postEducation) {
        this.postEducation = postEducation;
    }
}
