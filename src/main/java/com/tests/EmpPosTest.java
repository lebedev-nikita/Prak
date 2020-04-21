package com.tests;

import com.db.entity.EmpPos;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmpPosTest
{
    EmpPos tmpEmpPos;

    @Before
    public void initEmpPos()
    {
        tmpEmpPos = new EmpPos(1, 2, "2003-02-01", "2010-03-01", 40000);
    }

    @Test
    public void test_setId_getId()
    {
        tmpEmpPos.setId(10);
        assertEquals(10, tmpEmpPos.getId().intValue());
        tmpEmpPos.setId(8);
        assertEquals(8, tmpEmpPos.getId().intValue());
    }

    @Test
    public void test_setSalary_getSalary()
    {
        tmpEmpPos.setSalary(100000);
        assertEquals(100000, tmpEmpPos.getSalary().intValue());
        tmpEmpPos.setSalary(80000);
        assertEquals(80000, tmpEmpPos.getSalary().intValue());
    }

    @Test
    public void test_setEmployeeId_getEmployeeId()
    {
        tmpEmpPos.setEmpId(10);
        assertEquals(10, tmpEmpPos.getEmpId().intValue());
        tmpEmpPos.setEmpId(8);
        assertEquals(8, tmpEmpPos.getEmpId().intValue());
    }

    @Test
    public void test_setPositionId_getPositionId()
    {
        tmpEmpPos.setPosId(10);
        assertEquals(10, tmpEmpPos.getPosId().intValue());
        tmpEmpPos.setPosId(8);
        assertEquals(8, tmpEmpPos.getPosId().intValue());
    }

    @Test
    public void test_setStartDate_getStartDate()
    {
        tmpEmpPos.setStartDate("1999-04-02");
        assertEquals("1999-04-02", tmpEmpPos.getStartDate());
        tmpEmpPos.setStartDate("2005-05-20");
        assertEquals("2005-05-20", tmpEmpPos.getStartDate());
    }

    @Test
    public void test_setFinishDate_getFinishDate()
    {
        tmpEmpPos.setFinishDate("1999-04-02");
        assertEquals("1999-04-02", tmpEmpPos.getFinishDate());
        tmpEmpPos.setFinishDate("2005-05-20");
        assertEquals("2005-05-20", tmpEmpPos.getFinishDate());
    }

    @Test
    public void test_toString()
    {
        tmpEmpPos.setEmpId(10);
        assertEquals("DivPos [employeeId=10, positionId=2, startDate=2003-02-01, finishDate=2010-03-01, salary=40000]", tmpEmpPos.toString());
        tmpEmpPos.setEmpId(9);
        assertEquals("DivPos [employeeId=9, positionId=2, startDate=2003-02-01, finishDate=2010-03-01, salary=40000]", tmpEmpPos.toString());
    }
}
