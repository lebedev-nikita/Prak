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

public class EmployeeInfoTest {
    public ChromeDriver cd;
    public DivisionTableManager dtm = new DivisionTableManager();
    public EmployeeTableManager etm = new EmployeeTableManager();
    public String pageURL = "http://localhost:8080/employees/1";

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
    public void testEditEmployee() {
        // newName
        cd.get(pageURL);
        cd.findElementById("newName").clear();
        cd.findElementById("newName").sendKeys("testEditEmployee");
        cd.findElementById("ChangeName").click();
        cd.get(pageURL);
        assertEquals("testEditEmployee", cd.findElementById("Name").getText());

        cd.get(pageURL);
        cd.findElementById("newName").clear();
        cd.findElementById("newName").sendKeys("Иван");
        cd.findElementById("ChangeName").click();
        cd.get(pageURL);
        assertEquals("Иван", cd.findElementById("Name").getText());

        // newSurname
        cd.get(pageURL);
        cd.findElementById("newSurname").clear();
        cd.findElementById("newSurname").sendKeys("testEditEmployee");
        cd.findElementById("ChangeSurname").click();
        cd.get(pageURL);
        assertEquals("testEditEmployee", cd.findElementById("Surname").getText());

        cd.get(pageURL);
        cd.findElementById("newSurname").clear();
        cd.findElementById("newSurname").sendKeys("Иванов");
        cd.findElementById("ChangeSurname").click();
        cd.get(pageURL);
        assertEquals("Иванов", cd.findElementById("Surname").getText());

        // newPatronymic
        cd.get(pageURL);
        cd.findElementById("newPatronymic").clear();
        cd.findElementById("newPatronymic").sendKeys("testEditEmployee");
        cd.findElementById("ChangePatronymic").click();
        cd.get(pageURL);
        assertEquals("testEditEmployee", cd.findElementById("Patronymic").getText());

        cd.get(pageURL);
        cd.findElementById("newPatronymic").clear();
        cd.findElementById("newPatronymic").sendKeys("Иванович");
        cd.findElementById("ChangePatronymic").click();
        cd.get(pageURL);
        assertEquals("Иванович", cd.findElementById("Patronymic").getText());

        // newEducation
        cd.get(pageURL);
        cd.findElementById("newEducation").clear();
        cd.findElementById("newEducation").sendKeys("testEditEmployee");
        cd.findElementById("ChangeEducation").click();
        cd.get(pageURL);
        assertEquals("testEditEmployee", cd.findElementById("Education").getText());

        cd.get(pageURL);
        cd.findElementById("newEducation").clear();
        cd.findElementById("newEducation").sendKeys("Среднее специальное");
        cd.findElementById("ChangeEducation").click();
        cd.get(pageURL);
        assertEquals("Среднее специальное", cd.findElementById("Education").getText());
    }

    @Test
    public void testNewPosition_and_DeletePosition() {
        boolean metId22 = false;

        cd.get(pageURL);
        ArrayList<WebElement> idColumn1 = getColumn("idColumn");
        int size1 = idColumn1.size();
        System.out.println("size1: " + size1);
        for (WebElement we: idColumn1) {
            metId22 = metId22 || we.getText().equals("22");
        }
        assertFalse(metId22);

        cd.findElementById("newPositionId").clear();
        cd.findElementById("newPositionId").sendKeys("22");
        cd.findElementById("newPositionSalary").clear();
        cd.findElementById("newPositionSalary").sendKeys("22000");
        cd.findElementById("addPosition").click();

        cd.get(pageURL);
        ArrayList<WebElement> idColumn2 = getColumn("idColumn");
        int size2 = idColumn2.size();
        System.out.println("size2: " + size2);
        for (WebElement we: idColumn2) {
            metId22 = metId22 || we.getText().equals("22");
        }
        assertTrue(metId22);
        metId22 = false;

        cd.findElementById("deletePositionId").clear();
        cd.findElementById("deletePositionId").sendKeys("22");
        cd.findElementById("removePosition").click();

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
