package com.deleteMe;

import com.db.DAO.DivisionTableManager;
import com.db.entity.Division;
import com.db.entity.Employee;

public class Main {
    public static void main(String[] args) {
        DivisionTableManager dtm = new DivisionTableManager();
        Division div = dtm.getById(1);

        // getEmployees() возвращает одного начальника
        Employee emp = div.getEmployees();

        for (Division d: emp.getDivisions()) {
            System.out.println(d);
        }
    }
}
