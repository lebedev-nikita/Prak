package com.tests;

import com.db.DAO.EmpPosTableManager;
import com.db.entity.EmpPos;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EmpPosTableManagerTest
{
    EmpPosTableManager eptm;
    @Before
    public void init()
    {
        eptm = new EmpPosTableManager();
    }

    @Test
    public void test_update_getById()
    {
        EmpPos tmpEmpPos1 = new EmpPos(1, 2, "2010-10-10", "2018-01-12", 40000);
        EmpPos tmpEmpPos2 = new EmpPos(1, 2, "2011-10-10", "2016-01-12", 60000);
        eptm.save(tmpEmpPos1);
        eptm.save(tmpEmpPos2);

        tmpEmpPos1.setEmpId(1);
        tmpEmpPos2.setPosId(8);
        eptm.update(tmpEmpPos1);
        eptm.update(tmpEmpPos2);

        EmpPos tmpEmpPos01 = eptm.getById(tmpEmpPos1.getId());
        EmpPos tmpEmpPos02 = eptm.getById(tmpEmpPos2.getId());
        assertEquals(tmpEmpPos1.toString(), tmpEmpPos01.toString());
        assertEquals(tmpEmpPos2.toString(), tmpEmpPos02.toString());

        eptm.delete(tmpEmpPos1);
        eptm.delete(tmpEmpPos2);
    }

    @Test
    public void test_listByEmpId()
    {
       int size1 = eptm.listByEmpId(1).size();

        EmpPos tmpEmpPos1 = new EmpPos(1, 2, "2010-10-10", "2018-01-12", 40000);
        EmpPos tmpEmpPos2 = new EmpPos(1, 2, "2011-10-10", "2016-01-12", 60000);
        EmpPos tmpEmpPos3 = new EmpPos(1, 2, "2005-04-01", "2017-08-02", 71000);
        eptm.save(tmpEmpPos1);
        eptm.save(tmpEmpPos2);
        eptm.save(tmpEmpPos3);

       int size2 = eptm.listByEmpId(1).size();
       assertTrue(size1 == size2 - 3);

        eptm.delete(tmpEmpPos1);
        eptm.delete(tmpEmpPos2);
        eptm.delete(tmpEmpPos3);
        assertEquals(size1, eptm.listByEmpId(1).size());
    }

    @Test
    public void test_listByPosId()
    {
       int size1 = eptm.listByPosId(2).size();

        EmpPos tmpEmpPos1 = new EmpPos(1, 2, "2010-10-10", "2018-01-12", 40000);
        EmpPos tmpEmpPos2 = new EmpPos(1, 2, "2011-10-10", "2016-01-12", 60000);
        EmpPos tmpEmpPos3 = new EmpPos(1, 2, "2005-04-01", "2017-08-02", 71000);
        eptm.save(tmpEmpPos1);
        eptm.save(tmpEmpPos2);
        eptm.save(tmpEmpPos3);

       int size2 = eptm.listByPosId(2).size();
       assertTrue(size1 == size2 - 3);

        eptm.delete(tmpEmpPos1);
        eptm.delete(tmpEmpPos2);
        eptm.delete(tmpEmpPos3);
        assertEquals(size1, eptm.listByPosId(2).size());
    }

    // @Test
    // public void hqlRequest() {
    //     // TODO: delete this method
    // }
}
