package com.tests;

import com.db.entity.Position;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PositionTest
{
    Position tmpPos;


    @Before
    public void initPosition()
    {
        tmpPos = new Position(1, "Аналитик", "Анализ данных");
    }


    @Test
    public void test_setId_getId()
    {
        tmpPos.setId(10);
        assertEquals(10, tmpPos.getId().intValue());
        tmpPos.setId(8);
        assertEquals(8, tmpPos.getId().intValue());
    }

    @Test
    public void test_setDivisionId_getDivisionId()
    {
        tmpPos.setDivisionId(10);
        assertEquals(10, tmpPos.getDivisionId().intValue());
        tmpPos.setDivisionId(8);
        assertEquals(8, tmpPos.getDivisionId().intValue());
    }

    @Test
    public void test_setName_getName()
    {
        tmpPos.setName("SomeName1");
        assertEquals("SomeName1", tmpPos.getName());
        tmpPos.setName("SomeName2");
        assertEquals("SomeName2", tmpPos.getName());
    }

    @Test
    public void test_setResponsibilities_getResponsibilities()
    {
        tmpPos.setResponsibilities("Рисовать графики");
        assertEquals("Рисовать графики", tmpPos.getResponsibilities());
        tmpPos.setResponsibilities("Делать презентации");
        assertEquals("Делать презентации", tmpPos.getResponsibilities());
    }

    @Test
    public void test_toString()
    {
        tmpPos.setId(10);
        assertEquals("Position [id=10, divisionId=1, name=Аналитик, responsibilities=Анализ данных]", tmpPos.toString());
        tmpPos.setId(9);
        assertEquals("Position [id=9, divisionId=1, name=Аналитик, responsibilities=Анализ данных]", tmpPos.toString());
    }
}
