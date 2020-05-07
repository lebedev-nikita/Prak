package com.deleteMe;

import com.db.DAO.DivisionTableManager;
import com.db.entity.Division;

public class Main {
    public static void main(String[] args) {
        DivisionTableManager dtm = new DivisionTableManager();
        Division div = dtm.getById(1);
        System.out.println(div.toString());
        System.out.println(div.getChief().toString());
    }
}
