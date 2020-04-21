package com.tests;

import com.db.entity.Employee;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeTest
{
    Employee tmpEmployee;

    @Before
    public void initEmployee() throws Exception
    {
        tmpEmployee = new Employee("Иванов", "Иван", "Иванович", "Высшее");
    }

    @Test
    public void test_setId_getId()
    {
        tmpEmployee.setId(10);
        assertEquals(10, tmpEmployee.getId().intValue());
        tmpEmployee.setId(8);
        assertEquals(8, tmpEmployee.getId().intValue());
    }

    @Test
    public void test_setName_getName()
    {

        tmpEmployee.setName("SomeName1");
        assertEquals("SomeName1", tmpEmployee.getName());
        tmpEmployee.setName("SomeName2");
        assertEquals("SomeName2", tmpEmployee.getName());
    }

    @Test
    public void test_setSurname_getSurname()
    {

        tmpEmployee.setSurname("SomeSurname1");
        assertEquals("SomeSurname1", tmpEmployee.getSurname());
        tmpEmployee.setSurname("SomeSurname2");
        assertEquals("SomeSurname2", tmpEmployee.getSurname());
    }

    @Test
    public void test_setPatronymic_getPatronymic()
    {

        tmpEmployee.setPatronymic("SomePatronymic1");
        assertEquals("SomePatronymic1", tmpEmployee.getPatronymic());
        tmpEmployee.setPatronymic("SomePatronymic2");
        assertEquals("SomePatronymic2", tmpEmployee.getPatronymic());
    }

    @Test
    public void test_setEducation_getEducation()
    {
        tmpEmployee.setEducation("9 классов");
        assertEquals("9 классов", tmpEmployee.getEducation());
        tmpEmployee.setEducation("Среднее специальное");
        assertEquals("Среднее специальное", tmpEmployee.getEducation());
    }

    @Test
    public void test_toString()
    {
         tmpEmployee.setId(10);
         assertEquals("Employee [id=10, surname=Иванов, name=Иван, patronymic=Иванович, education=Высшее]", tmpEmployee.toString());
         tmpEmployee.setId(9);
         assertEquals("Employee [id=9, surname=Иванов, name=Иван, patronymic=Иванович, education=Высшее]", tmpEmployee.toString());
    }

}
