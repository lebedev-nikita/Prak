package com.controller.requests;

public class EmployeeInfoRequest {
    String newSurname;
    String newName;
    String newPatronymic;
    String newEducation;
    int newPositionId;
    int newPositionSalary;
    int deletePositionId;

    public int getDeletePositionId() {
        return deletePositionId;
    }

    public void setDeletePositionId(int deletePositionId) {
        this.deletePositionId = deletePositionId;
    }

    public int getNewPositionSalary() {
        return newPositionSalary;
    }

    public void setNewPositionSalary(int newPositionSalary) {
        this.newPositionSalary = newPositionSalary;
    }

    public int getNewPositionId() {
        return newPositionId;
    }

    public void setNewPositionId(int newPositionId) {
        this.newPositionId = newPositionId;
    }

    public String getNewSurname() {
        return newSurname;
    }

    public void setNewSurname(String newSurname) {
        this.newSurname = newSurname;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getNewPatronymic() {
        return newPatronymic;
    }

    public void setNewPatronymic(String newPatronymic) {
        this.newPatronymic = newPatronymic;
    }

    public String getNewEducation() {
        return newEducation;
    }

    public void setNewEducation(String newEducation) {
        this.newEducation = newEducation;
    }
}
