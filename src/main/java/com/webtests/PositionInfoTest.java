package com.webtests;

import com.db.DAO.DivisionTableManager;
import com.db.DAO.EmployeeTableManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class PositionInfoTest {
    public ChromeDriver cd;
    public DivisionTableManager dtm = new DivisionTableManager();
    public EmployeeTableManager etm = new EmployeeTableManager();
    public String pageURL = "http://localhost:8080/positions/1";

    // ===================================================================================
    private ArrayList<WebElement> getColumn(String columnId) {
        return (ArrayList<WebElement>) cd.findElementsById(columnId);
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
    // ===================================================================================

    @Before
    public void before() {

        System.setProperty(
                "webdriver.chrome.driver",
                "/Users/Nikita/Work/FinalProject/src/main/resources/chromedriver"
        );

        cd = new ChromeDriver();

        System.out.println("===== " + "test started" + " =====");
    }

    @After
    public void after() {
        cd.quit();
        System.out.println("===== " + "test finished" + " =====");
    }

    @Test
    public void testEditPosition() {
        // newName
        cd.get(pageURL);
        cd.findElementById("newName").clear();
        cd.findElementById("newName").sendKeys("testEditPosition");
        cd.findElementById("ChangeName").click();
        cd.get(pageURL);
        assertEquals("testEditPosition", cd.findElementById("Name").getText());

        cd.get(pageURL);
        cd.findElementById("newName").clear();
        cd.findElementById("newName").sendKeys("Менеджер");
        cd.findElementById("ChangeName").click();
        cd.get(pageURL);
        assertEquals("Менеджер", cd.findElementById("Name").getText());

        // newResponsibilities
        cd.get(pageURL);
        cd.findElementById("newResponsibilities").clear();
        cd.findElementById("newResponsibilities").sendKeys("testEditPosition");
        cd.findElementById("ChangeResponsibilities").click();
        cd.get(pageURL);
        assertEquals("testEditPosition", cd.findElementById("Responsibilities").getText());

        cd.get(pageURL);
        cd.findElementById("newResponsibilities").clear();
        cd.findElementById("newResponsibilities").sendKeys("Управление персоналом");
        cd.findElementById("ChangeResponsibilities").click();
        cd.get(pageURL);
        assertEquals("Управление персоналом", cd.findElementById("Responsibilities").getText());

        // newDivisionId
        cd.get(pageURL);
        cd.findElementById("newDivisionId").clear();
        cd.findElementById("newDivisionId").sendKeys("8");
        cd.findElementById("ChangeDivision").click();
        cd.get(pageURL);
        assertEquals(dtm.getById(8).getName(), cd.findElementById("Division").getText());

        cd.get(pageURL);
        cd.findElementById("newDivisionId").clear();
        cd.findElementById("newDivisionId").sendKeys("2");
        cd.findElementById("ChangeDivision").click();
        cd.get(pageURL);
        assertEquals(dtm.getById(2).getName(), cd.findElementById("Division").getText());
    }

    @Test
    public void testAddEmployee_and_RemoveEmployee() {
        boolean metId22 = false;

        cd.get(pageURL);
        ArrayList<WebElement> idColumn1 = getColumn("idColumn");
        int size1 = idColumn1.size();
        System.out.println("size1: " + size1);
        for (WebElement we: idColumn1) {
            metId22 = metId22 || we.getText().equals("22");
        }
        assertFalse(metId22);

        System.out.println("URL: " + cd.getCurrentUrl());
        cd.get(pageURL);
        cd.findElementById("newEmployeeId").clear();
        cd.findElementById("newEmployeeId").sendKeys("22");
        cd.findElementById("newEmployeeSalary").clear();
        cd.findElementById("newEmployeeSalary").sendKeys("22000");
        cd.findElementById("addEmployee").click();

        cd.get(pageURL);
        ArrayList<WebElement> idColumn2 = getColumn("idColumn");
        int size2 = idColumn2.size();
        System.out.println("size2: " + size2);
        for (WebElement we: idColumn2) {
            metId22 = metId22 || we.getText().equals("22");
        }
        assertTrue(metId22);
        metId22 = false;

        cd.findElementById("deleteEmployeeId").clear();
        cd.findElementById("deleteEmployeeId").sendKeys("22");
        cd.findElementById("removeEmployee").click();

        cd.get(pageURL);
        ArrayList<WebElement> idColumn3 = getColumn("idColumn");
        int size3 = idColumn3.size();
        System.out.println("size3: " + size3);
        for (WebElement we: idColumn3) {
            metId22 = metId22 || we.getText().equals("22");
        }
        assertFalse(metId22);

        assertTrue(size1 == size3);
        assertTrue(size1 == size2 - 1);
    }

    @Test
    public void testDivisionsButton()
    {
        cd.get(pageURL);
        cd.findElementById("btnDivisions").click();
        System.out.println(cd.getTitle());
        assertEquals(cd.getTitle(), "Divisions");
    }

    @Test
    public void testEmployeesButton()
    {
        cd.get(pageURL);
        cd.findElementById("btnEmployees").click();
        System.out.println(cd.getTitle());
        assertEquals(cd.getTitle(), "Employees");
    }

    @Test
    public void testPositionsButton()
    {
        cd.get(pageURL);
        cd.findElementById("btnPositions").click();
        System.out.println(cd.getTitle());
        assertEquals(cd.getTitle(), "Positions");
    }
}
