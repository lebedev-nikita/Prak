package com.deleteMe;

import com.db.DAO.EmpPosTableManager;
import com.db.entity.EmpPos;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EmpPosTableManager eptm = new EmpPosTableManager();
        List<EmpPos> epl = eptm.getByIdPair(19,1);
        for (EmpPos ep: epl) {
            System.out.println(ep);
        }
    }
}
