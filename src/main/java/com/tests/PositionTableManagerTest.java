package com.tests;

import com.db.DAO.PositionTableManager;
import com.db.entity.Position;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PositionTableManagerTest
{
    PositionTableManager ptm;
    @Before
    public void init()
    {
        ptm = new PositionTableManager();
    }

    @Test
    public void test_save_delete_getById()
    {
        Position tmpPos1 = new Position(1, "Аналитик", "Анализировать");
        Position tmpPos2 = new Position(2, "Программист", "Программировать");
        Position tmpPos3 = new Position(3, "Художник", "Рисовать");
        ptm.save(tmpPos1);
        ptm.save(tmpPos2);
        ptm.save(tmpPos3);

        Position tmpPos01 = ptm.getById(tmpPos1.getId());
        Position tmpPos02 = ptm.getById(tmpPos2.getId());
        Position tmpPos03 = ptm.getById(tmpPos3.getId());
        assertEquals(tmpPos1.toString(), tmpPos01.toString());
        assertEquals(tmpPos2.toString(), tmpPos02.toString());
        assertEquals(tmpPos3.toString(), tmpPos03.toString());

        ptm.delete(tmpPos1);
        ptm.delete(tmpPos2);
        ptm.delete(tmpPos3);
        assertNull(ptm.getById(tmpPos1.getId()));
        assertNull(ptm.getById(tmpPos2.getId()));
        assertNull(ptm.getById(tmpPos3.getId()));
    }

    @Test
    public void test_update()
    {
        Position tmpPos1 = new Position(1, "Аналитик", "Анализировать");
        Position tmpPos2 = new Position(2, "Программист", "Программировать");
        ptm.save(tmpPos1);
        ptm.save(tmpPos2);

        tmpPos1.setName("Николай");
        tmpPos2.setDivisionId(8);
        ptm.update(tmpPos1);
        ptm.update(tmpPos2);

        Position tmpPos01 = ptm.getById(tmpPos1.getId());
        Position tmpPos02 = ptm.getById(tmpPos2.getId());
        assertEquals(tmpPos1.toString(), tmpPos01.toString());
        assertEquals(tmpPos2.toString(), tmpPos02.toString());

        ptm.delete(tmpPos1);
        ptm.delete(tmpPos2);
    }

    @Test
    public void test_listByName()
    {
        int size1 = ptm.listByName("ик").size();
        Position tmpPos1 = new Position(1, "Аналитик", "Анализировать");
        Position tmpPos2 = new Position(2, "Программист", "Программировать");
        Position tmpPos3 = new Position(3, "Художник", "Рисовать");
        ptm.save(tmpPos1);
        ptm.save(tmpPos2);
        ptm.save(tmpPos3);

        int size2 = ptm.listByName("ик").size();
        assertTrue(size1 == size2 - 2);

        ptm.delete(tmpPos1);
        ptm.delete(tmpPos2);
        ptm.delete(tmpPos3);
    }

    @Test
    public void test_listByDivisionId()
    {
        int size1 = ptm.listByDivisionId(1).size();
        Position tmpPos1 = new Position(1, "Аналитик", "Анализировать");
        Position tmpPos2 = new Position(1, "Программист", "Программировать");
        Position tmpPos3 = new Position(1, "Художник", "Рисовать");
        ptm.save(tmpPos1);
        ptm.save(tmpPos2);
        ptm.save(tmpPos3);

        int size2 = ptm.listByDivisionId(1).size();
        assertTrue(size1 == size2 - 3);

        ptm.delete(tmpPos1);
        ptm.delete(tmpPos2);
        ptm.delete(tmpPos3);
    }

    // @Test
    // public void hqlRequest()
    // {
    //     // TODO: удалить этот метод
    // }
}
