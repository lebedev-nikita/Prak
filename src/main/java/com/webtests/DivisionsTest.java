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
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
import static org.junit.Assert.*;

public class DivisionsTest {
    public ChromeDriver cd;
    public DivisionTableManager dtm = new DivisionTableManager();
    public EmployeeTableManager etm = new EmployeeTableManager();
    public String pageURL = "http://localhost:8080/divisions";

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
        cd.get(pageURL);
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
        cd.get(pageURL);

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
        cd.get(pageURL);

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
        cd.get(pageURL);

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
        cd.get(pageURL);

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
    public void testDelete() throws InterruptedException {
        createNewDivision("testDelete", 1,1);

        System.out.println("Title: " + cd.getTitle());
        int size1 = getColumn("idColumn").size();
        String lastId1 = getLastValue("idColumn");
        System.out.println("size1: " + size1);
        System.out.println("lastId1: " + lastId1);

        WebElement deleteId = cd.findElementById("deleteId");
        deleteId.clear();
        deleteId.click();
        deleteId.sendKeys(lastId1);
        System.out.println("ID TO DELETE: " + deleteId.getAttribute("value"));
        cd.findElementById("Delete").click();

        cd.get(pageURL);

        int size2 = getColumn("idColumn").size();
        String lastId2 = getLastValue("idColumn");

        System.out.println("size2: " + size2);
        System.out.println("lastId2: " + lastId2);

        assertNotEquals(lastId1, lastId2);
        assertEquals(size1 - 1, size2);
    }

    @Test
    public void testColumn_id_and_DivisionName() {
        createNewDivision("testColumn_id_and_DivisionName", 1, 1);

        ArrayList<WebElement> divNameColumn = getColumn("divNameColumn");

        String valueInColumn = getLastValue("idColumn");
        System.out.println("Value in column: " + valueInColumn);

        System.out.println("divNameColumn size: " + divNameColumn.size());
        WebElement divName = divNameColumn.get(findMaxIdOffset());
        System.out.println("href: " + divName.getAttribute("href"));
        divName.click();

        String idInDivisionInfo = cd.findElementById("ID").getText();
        System.out.println("idInDivisionInfo: " + idInDivisionInfo);

        assertEquals(idInDivisionInfo, valueInColumn);

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
