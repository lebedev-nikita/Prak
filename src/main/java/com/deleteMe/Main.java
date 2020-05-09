package com.deleteMe;

import com.db.DAO.DivisionTableManager;
import com.db.DAO.EmployeeTableManager;
import com.db.entity.Division;
import com.db.entity.EmpPos;
import com.db.entity.Employee;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DivisionTableManager dtm = new DivisionTableManager();
        List<Division> divisionList = dtm.listLike("отд", "", "","", "");
        for (Division div: divisionList) {
            System.out.println(div);
        }
    }
}
