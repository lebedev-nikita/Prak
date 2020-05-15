package com.controller.requests;

public class PositionInfoRequest {
    private String newName;
    private int newDivisionId;
    private String newResponsibilities;
    private int newEmployeeId;
    private int newEmployeeSalary;
    private int deleteEmployeeId;

    public int getDeleteEmployeeId() {
        return deleteEmployeeId;
    }

    public void setDeleteEmployeeId(int deleteEmployeeId) {
        this.deleteEmployeeId = deleteEmployeeId;
    }

    public int getNewEmployeeId() {
        return newEmployeeId;
    }

    public void setNewEmployeeId(int newEmployeeId) {
        this.newEmployeeId = newEmployeeId;
    }

    public int getNewEmployeeSalary() {
        return newEmployeeSalary;
    }

    public void setNewEmployeeSalary(int newEmployeeSalary) {
        this.newEmployeeSalary = newEmployeeSalary;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public int getNewDivisionId() {
        return newDivisionId;
    }

    public void setNewDivisionId(int newDivisionId) {
        this.newDivisionId = newDivisionId;
    }

    public String getNewResponsibilities() {
        return newResponsibilities;
    }

    public void setNewResponsibilities(String newResponsibilities) {
        this.newResponsibilities = newResponsibilities;
    }
}
