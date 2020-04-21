package com.tests;

import com.db.DAO.EmployeeTableManager;
import com.db.entity.Employee;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeTableManagerTest
{
    EmployeeTableManager etm;
    @Before
    public void init()
    {
        etm = new EmployeeTableManager();
    }

    @Test
    public void test_save_delete_getById()
    {
        Employee tmpEmp1 = new Employee("Иванов", "Иван", "Иванович", "Высшее");
        Employee tmpEmp2 = new Employee("Петров", "Петр", "Петрович", "Высшее");
        Employee tmpEmp3 = new Employee("Семенов", "Семен", "Семенович", "Высшее");
        etm.save(tmpEmp1);
        etm.save(tmpEmp2);
        etm.save(tmpEmp3);

        Employee tmpEmp01 = etm.getById(tmpEmp1.getId());
        Employee tmpEmp02 = etm.getById(tmpEmp2.getId());
        Employee tmpEmp03 = etm.getById(tmpEmp3.getId());
        assertEquals(tmpEmp1.toString(), tmpEmp01.toString());
        assertEquals(tmpEmp2.toString(), tmpEmp02.toString());
        assertEquals(tmpEmp3.toString(), tmpEmp03.toString());

        etm.delete(tmpEmp1);
        etm.delete(tmpEmp2);
        etm.delete(tmpEmp3);
        assertNull(etm.getById(tmpEmp1.getId()));
        assertNull(etm.getById(tmpEmp2.getId()));
        assertNull(etm.getById(tmpEmp3.getId()));
    }
    /* ======= */

    @Test
    public void test_update()
    {
        Employee tmpEmp1 = new Employee("Иванов", "Иван", "Иванович", "Высшее");
        Employee tmpEmp2 = new Employee("Петров", "Петр", "Петрович", "Высшее");
        Employee tmpEmp3 = new Employee("Семенов", "Семен", "Семенович", "Высшее");
        Employee tmpEmp4 = new Employee("Антонов", "Антон", "Антонович", "Высшее");
        etm.save(tmpEmp1);
        etm.save(tmpEmp2);
        etm.save(tmpEmp3);
        etm.save(tmpEmp4);

        tmpEmp1.setName("Николай");
        tmpEmp2.setSurname("Николаев");
        tmpEmp3.setPatronymic("Николаевич");
        tmpEmp4.setEducation("Среднее");
        etm.update(tmpEmp1);
        etm.update(tmpEmp2);
        etm.update(tmpEmp3);
        etm.update(tmpEmp4);

        Employee tmpEmp01 = etm.getById(tmpEmp1.getId());
        Employee tmpEmp02 = etm.getById(tmpEmp2.getId());
        Employee tmpEmp03 = etm.getById(tmpEmp3.getId());
        Employee tmpEmp04 = etm.getById(tmpEmp4.getId());
        assertEquals(tmpEmp1.toString(), tmpEmp01.toString());
        assertEquals(tmpEmp2.toString(), tmpEmp02.toString());
        assertEquals(tmpEmp3.toString(), tmpEmp03.toString());
        assertEquals(tmpEmp4.toString(), tmpEmp04.toString());

        etm.delete(tmpEmp1);
        etm.delete(tmpEmp2);
        etm.delete(tmpEmp3);
        etm.delete(tmpEmp4);
    }

    @Test
    public void test_listByNameSurname()
    {
        int size1 = etm.listByNameSurname("Иван", "ван").size();
        Employee tmpEmp1 = new Employee("Иванов", "Иван", "Иванович", "Высшее");
        Employee tmpEmp2 = new Employee("Петров", "Петр", "Петрович", "Высшее");
        Employee tmpEmp3 = new Employee("Семенов", "Семен", "Семенович", "Высшее");
        etm.save(tmpEmp1);
        etm.save(tmpEmp2);
        etm.save(tmpEmp3);

        int size2 = etm.listByNameSurname("Иван", "ван").size();
        assertTrue(size1 == size2 - 1);

        etm.delete(tmpEmp1);
        etm.delete(tmpEmp2);
        etm.delete(tmpEmp3);
    }

    // @Test
    // public void hqlRequest() {
    //     // TODO: удалить этот метод
    // }
}
