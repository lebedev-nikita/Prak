package com.webtests;

import com.db.DAO.DivisionTableManager;
import com.db.DAO.EmployeeTableManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class DivisionInfoTest {
    public ChromeDriver cd;
    public DivisionTableManager dtm = new DivisionTableManager();
    public EmployeeTableManager etm = new EmployeeTableManager();
    public String pageURL = "http://localhost:8080/divisions/1";

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
    public void testEditDivision() {
        // newName
        cd.get(pageURL);
        cd.findElementById("newName").clear();
        cd.findElementById("newName").sendKeys("testEditDivision");
        cd.findElementById("ChangeName").click();
        assertEquals("testEditDivision", cd.getTitle());

        cd.get(pageURL);
        cd.findElementById("newName").clear();
        cd.findElementById("newName").sendKeys("Отдел аналитики");
        cd.findElementById("ChangeName").click();
        assertEquals("Отдел аналитики", cd.getTitle());

        // newHeadDivisionId
        cd.get(pageURL);
        cd.findElementById("newHeadDivisionId").clear();
        cd.findElementById("newHeadDivisionId").sendKeys("4");
        cd.findElementById("ChangeHead").click();
        cd.get(pageURL);
        cd.findElementById("Head division").click();
        assertEquals("4", cd.findElementById("ID").getText());

        cd.get(pageURL);
        cd.findElementById("newHeadDivisionId").clear();
        cd.findElementById("newHeadDivisionId").sendKeys("7");
        cd.findElementById("ChangeHead").click();
        cd.get(pageURL);
        cd.findElementById("Head division").click();
        assertEquals("7", cd.findElementById("ID").getText());

        // newChiefId
        cd.get(pageURL);
        cd.findElementById("newChiefId").clear();
        cd.findElementById("newChiefId").sendKeys("12");
        cd.findElementById("ChangeChief").click();
        cd.get(pageURL);
        cd.findElementById("Chief").click();
        assertEquals("12", cd.findElementById("ID").getText());

        cd.get(pageURL);
        cd.findElementById("newChiefId").clear();
        cd.findElementById("newChiefId").sendKeys("11");
        cd.findElementById("ChangeChief").click();
        cd.get(pageURL);
        cd.findElementById("Chief").click();
        assertEquals("11", cd.findElementById("ID").getText());


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
