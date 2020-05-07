package com.deleteMe;

import com.db.DAO.DivisionTableManager;
import com.db.entity.Division;

public class Main {
    public static void main(String[] args) {
        DivisionTableManager dtm = new DivisionTableManager();
        Division div = dtm.getById(4);
        System.out.println(div.toString());
        System.out.println(div.getHeadDiv().toString());
    }
}
