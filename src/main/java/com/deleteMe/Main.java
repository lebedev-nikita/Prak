package com.deleteMe;

import com.db.DAO.EmployeeTableManager;
import com.db.entity.EmpPos;
import com.db.entity.Employee;

public class Main {
    public static void main(String[] args) {
//        DivisionTableManager dtm = new DivisionTableManager();
//        Division div = dtm.getById(4);
//        System.out.println(div.toString());
//        System.out.println(div.getHeadDiv().toString());

        EmployeeTableManager etm = new EmployeeTableManager();
        Employee emp = etm.getById(4);
        System.out.println("Size: " + emp.getEmpPos().size());
        for (EmpPos ep: emp.getEmpPos()) {
            System.out.println(ep);
            System.out.println(ep.getPos().getDivision());
        }
    }
}
