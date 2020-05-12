package com.webtests;

import com.db.DAO.DivisionTableManager;
import com.db.DAO.EmployeeTableManager;
import com.db.entity.Division;
import com.sun.source.tree.AssertTree;
import com.sun.xml.internal.xsom.impl.scd.Iterators;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DivisionsTest {
    public ChromeDriver cd;
    public DivisionTableManager dtm = new DivisionTableManager();
    public EmployeeTableManager etm = new EmployeeTableManager();

    // ===================================================================================

    private void createNewDivision(String name, int headDivId, int chiefId) {
        cd.findElementById("postName").clear();
        cd.findElementById("postName").sendKeys(name);

        cd.findElementById("headDivId").clear();
        cd.findElementById("headDivId").sendKeys(Integer.toString(headDivId));

        cd.findElementById("chiefId").clear();
        cd.findElementById("chiefId").sendKeys(Integer.toString(chiefId));

        cd.findElementById("Create").click();
    }

    private int findMaxIdOffset() {
        ArrayList<WebElement> idColumn = getColumn("idColumn");
        int maxId = 0;
        int maxIdOffset = 0;
        for (int i = 0; i < idColumn.size(); i++) {
            int id = Integer.parseInt(idColumn.get(i).getText());
            if (id > maxId) {
                maxId = id;
                maxIdOffset = i;
            }
        }
        return maxIdOffset;
    }

    private String getLastValue(String columnId) {

        ArrayList<WebElement> column = getColumn(columnId);
        String lastValue = column.get(findMaxIdOffset()).getText();
        System.out.println("Last value: " + lastValue + "in column" + columnId);

        return lastValue;
    }

    private ArrayList<WebElement> getColumn(String columnId) {
        return (ArrayList<WebElement>) cd.findElementsById(columnId);
    }


    private void deleteLastDivision() {
        cd.get("http://localhost:8080/divisions");
        int deleteId = Integer.parseInt(getLastValue("idColumn"));
        dtm.delete(dtm.getById(deleteId));
    };

    // ===================================================================================

    @Before
    public void before() {

        System.setProperty(
                "webdriver.chrome.driver",
                "/Users/Nikita/Work/FinalProject/src/main/resources/chromedriver"
        );

        cd = new ChromeDriver();
        cd.get("http://localhost:8080/divisions");

        System.out.println("===== " + "test started" + " =====");
    }

    @After
    public void after() {
        cd.quit();
        System.out.println("===== " + "test finished" + " =====");
    }


//     @Test
//     public void example() {
// //        cd.findElement(By.id("employeesButton")).click();
// //        if (!cd.getTitle().equals("Employees")) {
// //            Assert.fail();
// //        }
//
// //        cd.findElementById("createDivisionPostName")
//         cd.findElement(By.id("simpleId")).clear();
//         cd.findElement(By.id("simpleId")).sendKeys("Отдел продаж");
//         System.out.println(cd.findElement(By.id("simpleId")).getAttribute("value"));
//
//         List<WebElement> webElementList = cd.findElements(By.id("multipleId")); // находит List<WebElement>
//
//    }

    @Test
    public void testFilter() {

        createNewDivision("testFilter1", 1, 1);
        createNewDivision("testFilter2", 1, 2);
        createNewDivision("testFilter3", 2, 1);
        createNewDivision("testFilter4", 2, 2);

        WebElement getName, headDivName, chiefName, chiefSurname, chiefPatronymic, Filter;
        ArrayList<WebElement> divNameColumn, headDivNameColumn, chiefFullNameColumn;

        // 1
        cd.get("http://localhost:8080/divisions");

        getName = cd.findElementById("getName");
        headDivName = cd.findElementById("headDivName");
        chiefName = cd.findElementById("chiefName");
        chiefSurname = cd.findElementById("chiefSurname");
        chiefPatronymic = cd.findElementById("chiefPatronymic");

        Filter = cd.findElementById("Filter");

        getName.clear();
        headDivName.clear();
        chiefName.clear();
        chiefSurname.clear();
        chiefPatronymic.clear();

        getName.sendKeys("testFilter");
        Filter.click();

        divNameColumn = getColumn("divNameColumn");
        headDivNameColumn = getColumn("headDivNameColumn");
        chiefFullNameColumn = getColumn("chiefFullNameColumn");

        for (int i = 0; i < divNameColumn.size(); i++) {
            System.out.println(divNameColumn.get(i).getText());
            assertTrue(divNameColumn.get(i).getText().contains("testFilter"));
        }
        System.out.println("Stage 1 passed");

        // 2

        cd.get("http://localhost:8080/divisions");
        getName = cd.findElementById("getName");
        headDivName = cd.findElementById("headDivName");
        chiefName = cd.findElementById("chiefName");
        chiefSurname = cd.findElementById("chiefSurname");
        chiefPatronymic = cd.findElementById("chiefPatronymic");

        Filter = cd.findElementById("Filter");

        getName.clear();
        headDivName.clear();
        chiefName.clear();
        chiefSurname.clear();
        chiefPatronymic.clear();

        getName.sendKeys("testFilter");
        chiefName.sendKeys(etm.getById(1).getName());
        Filter.click();

        divNameColumn = getColumn("divNameColumn");
        headDivNameColumn = getColumn("headDivNameColumn");
        chiefFullNameColumn = getColumn("chiefFullNameColumn");

        for (int i = 0; i < divNameColumn.size(); i++) {
            assertTrue(divNameColumn.get(i).getText().contains("testFilter"));
            assertTrue(chiefFullNameColumn.get(i).getText().contains(etm.getById(1).getFullName()));
        }
        System.out.println("Stage 2 passed");


        // 3
        cd.get("http://localhost:8080/divisions");
        getName = cd.findElementById("getName");
        headDivName = cd.findElementById("headDivName");
        chiefName = cd.findElementById("chiefName");
        chiefSurname = cd.findElementById("chiefSurname");
        chiefPatronymic = cd.findElementById("chiefPatronymic");

        Filter = cd.findElementById("Filter");

        getName.clear();
        headDivName.clear();
        chiefName.clear();
        chiefSurname.clear();
        chiefPatronymic.clear();

        getName.sendKeys("testFilter");
        chiefName.sendKeys(etm.getById(1).getName());
        headDivName.sendKeys(dtm.getById(2).getName());
        Filter.click();

        divNameColumn = getColumn("divNameColumn");
        headDivNameColumn = getColumn("headDivNameColumn");
        chiefFullNameColumn = getColumn("chiefFullNameColumn");

        for (int i = 0; i < divNameColumn.size(); i++) {
            assertTrue(divNameColumn.get(i).getText().contains("testFilter"));
            assertTrue(headDivNameColumn.get(i).getText().contains(dtm.getById(2).getName()));
            assertTrue(chiefFullNameColumn.get(i).getText().contains(etm.getById(1).getFullName()));
        }
        System.out.println("Stage 3 passed");


        deleteLastDivision();
        deleteLastDivision();
        deleteLastDivision();
        deleteLastDivision();
    }

    @Test
    public void testDelete() {
        createNewDivision("testDelete", 1,1);

        System.out.println("Title: " + cd.getTitle());
        int size1 = getColumn("idColumn").size();
        String lastId1 = getLastValue("idColumn");

        cd.findElementById("deleteId").clear();
        cd.findElementById("deleteId").sendKeys(lastId1);
        cd.findElementById("Delete").click();

        int size2 = getColumn("idColumn").size();
        String lastId2 = getLastValue("idColumn");

        assertNotEquals(lastId1, lastId2);
        assertEquals(size1 - 1, size2);
    }

    @Test
    public void testColumn_id_and_DivisionName() {
        createNewDivision("testColumn_id_and_DivisionName", 1, 1);

        ArrayList<WebElement> divName = getColumn("divNameColumn");

        String valueInColumn = getLastValue("idColumn");
        System.out.println("Value in column: " + valueInColumn);

        System.out.println("divNameColumn size: " + divName.size());
        divName.get(findMaxIdOffset()).click();

        String valueInDivisionInfo = cd.findElementById("ID").getText();
        System.out.println(valueInDivisionInfo);

        assertEquals(valueInDivisionInfo, valueInColumn);

        deleteLastDivision();
    }

    @Test
    public void testColumn_DivisionName() {
        createNewDivision("testColumn_DivisionName", 1, 1);
        String lastName = getLastValue("divNameColumn");
        System.out.println("Last divName in column: " + lastName);

        assertEquals(lastName, "testColumn_DivisionName");

        deleteLastDivision();
    }

    @Test
    public void testDivisionsButton()
    {
        cd.findElementById("btnDivisions").click();
        System.out.println(cd.getTitle());
        assertEquals(cd.getTitle(), "Divisions");
    }

    @Test
    public void testEmployeesButton()
    {
        cd.findElementById("btnEmployees").click();
        System.out.println(cd.getTitle());
        assertEquals(cd.getTitle(), "Employees");
    }

    @Test
    public void testPositionsButton()
    {
        cd.findElementById("btnPositions").click();
        System.out.println(cd.getTitle());
        assertEquals(cd.getTitle(), "Positions");
    }
}
