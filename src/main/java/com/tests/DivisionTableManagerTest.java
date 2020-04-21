package com.tests;

import com.db.DAO.DivisionTableManager;
import com.db.entity.Division;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DivisionTableManagerTest
{
    DivisionTableManager dtm;

    @Before
    public void init()
    {
        dtm = new DivisionTableManager();
    }

    @Test
    public void test_save_delete_getById()
    {
        Division tmpDiv1 = new Division("Отдел аналитики", 1, 1);
        Division tmpDiv2 = new Division("Отдел веб-дизайна", 1, 1);
        Division tmpDiv3 = new Division("Отдел разработки", 1, 1);
        dtm.save(tmpDiv1);
        dtm.save(tmpDiv2);
        dtm.save(tmpDiv3);

        Division tmpDiv01 = dtm.getById(tmpDiv1.getId());
        Division tmpDiv02 = dtm.getById(tmpDiv2.getId());
        Division tmpDiv03 = dtm.getById(tmpDiv3.getId());
        assertEquals(tmpDiv1.toString(), tmpDiv01.toString());
        assertEquals(tmpDiv2.toString(), tmpDiv02.toString());
        assertEquals(tmpDiv3.toString(), tmpDiv03.toString());

        dtm.delete(tmpDiv1);
        dtm.delete(tmpDiv2);
        dtm.delete(tmpDiv3);
        assertNull(dtm.getById(tmpDiv1.getId()));
        assertNull(dtm.getById(tmpDiv2.getId()));
        assertNull(dtm.getById(tmpDiv3.getId()));
    }

    @Test
    public void test_update()
    {
        Division tmpDiv1 = new Division("Отдел аналитики", 1, 1);
        Division tmpDiv2 = new Division("Отдел веб-дизайна", 1, 1);
        Division tmpDiv3 = new Division("Отдел разработки", 1, 1);
        dtm.save(tmpDiv1);
        dtm.save(tmpDiv2);
        dtm.save(tmpDiv3);

        tmpDiv1.setName("Тестовый отдел");
        tmpDiv2.setHeadDivId(tmpDiv3.getId());
        tmpDiv3.setChiefId(10);
        dtm.update(tmpDiv1);
        dtm.update(tmpDiv2);
        dtm.update(tmpDiv3);

        Division tmpDiv01 = dtm.getById(tmpDiv1.getId());
        Division tmpDiv02 = dtm.getById(tmpDiv2.getId());
        Division tmpDiv03 = dtm.getById(tmpDiv3.getId());
        assertEquals(tmpDiv1.toString(), tmpDiv01.toString());
        assertEquals(tmpDiv2.toString(), tmpDiv02.toString());
        assertEquals(tmpDiv3.toString(), tmpDiv03.toString());

        dtm.delete(tmpDiv1);
        dtm.delete(tmpDiv2);
        dtm.delete(tmpDiv3);
    }

    @Test
    public void test_listByChiefId()
    {
        Division tmpDiv1 = new Division("Отдел аналитики", 1, 90);
        Division tmpDiv2 = new Division("Отдел веб-дизайна", 1, 90);
        Division tmpDiv3 = new Division("Отдел разработки", 1, 90);
        dtm.save(tmpDiv1);
        dtm.save(tmpDiv2);
        dtm.save(tmpDiv3);
        Division tmpDiv4 = new Division("Отдел аналитики", 1, 91);
        Division tmpDiv5 = new Division("Отдел веб-дизайна", 1, 91);
        Division tmpDiv6 = new Division("Отдел разработки", 1, 91);
        dtm.save(tmpDiv4);
        dtm.save(tmpDiv5);
        dtm.save(tmpDiv6);

        List<Division> divList1 = dtm.listByChiefId(90);
        assertTrue(divList1.size() >= 3);
        for (Division div : divList1)
            assertEquals(90, div.getChiefId().intValue());

        List<Division> divList2 = dtm.listByChiefId(91);
        assertTrue(divList2.size() >= 3);
        for (Division div : divList2)
            assertEquals(91, div.getChiefId().intValue());

        dtm.delete(tmpDiv1);
        dtm.delete(tmpDiv2);
        dtm.delete(tmpDiv3);
        dtm.delete(tmpDiv4);
        dtm.delete(tmpDiv5);
        dtm.delete(tmpDiv6);
    }


    @Test
    public void test_listByName()
    {
        Division tmpDiv1 = new Division("Отдел аналитики", 1, 90);
        Division tmpDiv2 = new Division("Отдел аналитики", 1, 90);
        Division tmpDiv3 = new Division("Отдел аналитики", 1, 90);
        dtm.save(tmpDiv1);
        dtm.save(tmpDiv2);
        dtm.save(tmpDiv3);
        Division tmpDiv4 = new Division("Отдел дизайна", 1, 90);
        Division tmpDiv5 = new Division("Отдел дизайна", 1, 90);
        Division tmpDiv6 = new Division("Отдел дизайна", 1, 90);
        dtm.save(tmpDiv4);
        dtm.save(tmpDiv5);
        dtm.save(tmpDiv6);

        List<Division> divList1 = dtm.listByName("Отдел аналитики");
        assertTrue(divList1.size() >= 3);
        for (Division div : divList1)
            assertEquals("Отдел аналитики", div.getName());

        List<Division> divList2 = dtm.listByName("Отдел дизайна");
        assertTrue(divList2.size() >= 3);
        for (Division div : divList2)
            assertEquals("Отдел дизайна", div.getName());

        dtm.delete(tmpDiv1);
        dtm.delete(tmpDiv2);
        dtm.delete(tmpDiv3);
        dtm.delete(tmpDiv4);
        dtm.delete(tmpDiv5);
        dtm.delete(tmpDiv6);
    }


    @Test
    public void test_listByHeadDivId()
    {
        Division tmpDiv1 = new Division("Отдел аналитики", 1, null);
        Division tmpDiv2 = new Division("Отдел аналитики", 1, null);
        Division tmpDiv3 = new Division("Отдел аналитики", 1, null);
        dtm.save(tmpDiv1);
        dtm.save(tmpDiv2);
        dtm.save(tmpDiv3);
        Division tmpDiv4 = new Division("Отдел дизайна", 2, null);
        Division tmpDiv5 = new Division("Отдел дизайна", 2, null);
        Division tmpDiv6 = new Division("Отдел дизайна", 2, null);
        dtm.save(tmpDiv4);
        dtm.save(tmpDiv5);
        dtm.save(tmpDiv6);

        List<Division> divList1 = dtm.listByHeadDivId(1);
        assertTrue(divList1.size() >= 3);
        for (Division div : divList1)
            assertEquals(1, div.getHeadDivId().intValue());

        List<Division> divList2 = dtm.listByHeadDivId(2);
        assertTrue(divList2.size() >= 3);
        for (Division div : divList2)
            assertEquals(2, div.getHeadDivId().intValue());

        dtm.delete(tmpDiv1);
        dtm.delete(tmpDiv2);
        dtm.delete(tmpDiv3);
        dtm.delete(tmpDiv4);
        dtm.delete(tmpDiv5);
        dtm.delete(tmpDiv6);
    }

    @Test
    public void test_listAllDivisions()
    {
        Division tmpDiv1 = new Division("Отдел аналитики", 1, null);
        Division tmpDiv2 = new Division("Отдел аналитики", 1, null);
        Division tmpDiv3 = new Division("Отдел аналитики", 1, null);
        Division tmpDiv4 = new Division("Отдел дизайна", 2, null);
        Division tmpDiv5 = new Division("Отдел дизайна", 2, null);
        Division tmpDiv6 = new Division("Отдел дизайна", 2, null);
        dtm.save(tmpDiv1);
        dtm.save(tmpDiv2);
        dtm.save(tmpDiv3);
        dtm.save(tmpDiv4);
        dtm.save(tmpDiv5);
        dtm.save(tmpDiv6);

        List<Division> divList = dtm.listAllDivisions();
        assertTrue(divList.size() >= 6);
        Division div1 = null;
        for (Division div2 : divList) {
            if (div1 != null) {
                assertNotEquals(div1.toString(), div2.toString());
            }
            div1 = div2;
        }

        dtm.delete(tmpDiv1);
        dtm.delete(tmpDiv2);
        dtm.delete(tmpDiv3);
        dtm.delete(tmpDiv4);
        dtm.delete(tmpDiv5);
        dtm.delete(tmpDiv6);
    }

    // @Test
    // public void hqlRequest()
    // {
    //     // TODO: удалить этот метод
    // }
}
