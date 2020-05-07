package com.deleteMe;

import com.db.DAO.DivisionTableManager;
import com.db.DAO.EmployeeTableManager;
import com.db.entity.Division;
import com.db.entity.EmpPos;
import com.db.entity.Employee;
import com.db.entity.Position;

public class Main {
    public static void main(String[] args) {
//        DivisionTableManager dtm = new DivisionTableManager();
//        Division div = dtm.getById(4);
//        System.out.println(div.toString());
//        System.out.println(div.getHeadDiv().toString());

        EmployeeTableManager etm = new EmployeeTableManager();
        Employee emp = etm.getById(4);
        System.out.println("Size: " + emp.getEp().size());
        for (EmpPos ep: emp.getEp()) {
            System.out.println(ep);
            System.out.println(ep.getPos());
        }
    }
}
