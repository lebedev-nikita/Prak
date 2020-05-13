package com.webtests;

import com.db.DAO.DivisionTableManager;
import com.db.DAO.EmployeeTableManager;
import com.db.DAO.PositionTableManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PositionsTest {
    public ChromeDriver cd;
    public DivisionTableManager dtm = new DivisionTableManager();
    public EmployeeTableManager etm = new EmployeeTableManager();
    public PositionTableManager ptm = new PositionTableManager();
    public String pageURL = "http://localhost:8080/positions";

    // ===================================================================================

    private void createNewPosition(String postName, int postDivisionId, String postResponsibilities) {
        cd.findElementById("postName").clear();
        cd.findElementById("postName").sendKeys(postName);

        cd.findElementById("postDivisionId").clear();
        cd.findElementById("postDivisionId").sendKeys(Integer.toString(postDivisionId));

        cd.findElementById("postResponsibilities").clear();
        cd.findElementById("postResponsibilities").sendKeys(postResponsibilities);

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


    private void deleteLastPosition() {
        cd.get(pageURL);
        int deleteId = Integer.parseInt(getLastValue("idColumn"));
        ptm.delete(ptm.getById(deleteId));
        cd.get(pageURL);
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

        createNewPosition("testFilter1", 1, "Есть");
        createNewPosition("testFilter2", 2, "Спать");
        createNewPosition("testFilter3", 3, "Есть");
        createNewPosition("testFilter4", 4, "Спать");

        // WebElement getName, headDivName, chiefName, chiefSurname, chiefPatronymic, Filter;
        // ArrayList<WebElement> divNameColumn, headDivNameColumn, chiefFullNameColumn;
        WebElement getName, getResponsibilities, getDivisionName, getDivisionId, Filter;
        ArrayList<WebElement> idColumn, nameColumn, responsibilitiesColumn, divisionNameColumn, divisionIdColumn;

        // 1
        cd.get(pageURL);

        getName = cd.findElementById("getName");
        getResponsibilities = cd.findElementById("getResponsibilities");
        getDivisionName = cd.findElementById("getDivisionName");
        getDivisionId = cd.findElementById("getDivisionId");

        Filter = cd.findElementById("Filter");

        getName.clear();
        getResponsibilities.clear();
        getDivisionName.clear();
        getDivisionId.clear();

        getName.sendKeys("testFilter");
        Filter.click();

        idColumn = getColumn("idColumn");
        nameColumn = getColumn("nameColumn");
        responsibilitiesColumn = getColumn("responsibilitiesColumn");
        divisionNameColumn = getColumn("divisionNameColumn");
        divisionIdColumn = getColumn("divisionIdColumn");

        for (int i = 0; i < idColumn.size(); i++) {
            System.out.println(nameColumn.get(i).getText());
            assertTrue(nameColumn.get(i).getText().contains("testFilter"));
        }
        System.out.println("Stage 1 passed");

        // 2
        cd.get(pageURL);

        getName = cd.findElementById("getName");
        getResponsibilities = cd.findElementById("getResponsibilities");
        getDivisionName = cd.findElementById("getDivisionName");
        getDivisionId = cd.findElementById("getDivisionId");

        Filter = cd.findElementById("Filter");

        getName.clear();
        getResponsibilities.clear();
        getDivisionName.clear();
        getDivisionId.clear();

        getName.sendKeys("testFilter");
        getResponsibilities.sendKeys("Есть");
        Filter.click();

        idColumn = getColumn("idColumn");
        nameColumn = getColumn("nameColumn");
        responsibilitiesColumn = getColumn("responsibilitiesColumn");
        divisionNameColumn = getColumn("divisionNameColumn");
        divisionIdColumn = getColumn("divisionIdColumn");

        for (int i = 0; i < idColumn.size(); i++) {
            assertTrue(nameColumn.get(i).getText().contains("testFilter"));
            assertTrue(responsibilitiesColumn.get(i).getText().contains("Есть"));
        }
        System.out.println("Stage 2 passed");


        // 3
        cd.get(pageURL);

        getName = cd.findElementById("getName");
        getResponsibilities = cd.findElementById("getResponsibilities");
        getDivisionName = cd.findElementById("getDivisionName");
        getDivisionId = cd.findElementById("getDivisionId");

        Filter = cd.findElementById("Filter");

        getName.clear();
        getResponsibilities.clear();
        getDivisionName.clear();
        getDivisionId.clear();

        getName.sendKeys("testFilter");
        getResponsibilities.sendKeys("Спать");
        getDivisionName.sendKeys("отдел");
        Filter.click();

        idColumn = getColumn("idColumn");
        nameColumn = getColumn("nameColumn");
        responsibilitiesColumn = getColumn("responsibilitiesColumn");
        divisionNameColumn = getColumn("divisionNameColumn");
        divisionIdColumn = getColumn("divisionIdColumn");

        for (int i = 0; i < idColumn.size(); i++) {
            assertTrue(nameColumn.get(i).getText().contains("testFilter"));
            assertTrue(responsibilitiesColumn.get(i).getText().contains("Спать"));
            assertTrue(divisionNameColumn.get(i).getText().contains("отдел"));
        }
        System.out.println("Stage 3 passed");


        deleteLastPosition();
        deleteLastPosition();
        deleteLastPosition();
        deleteLastPosition();
    }

    @Test
    public void testDelete() {
        createNewPosition("testDelete", 1,"Должна удаляться успешно");

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
    public void testColumn_id_and_PositionName() {
        createNewPosition("testColumn_id_and_DivisionName", 1, "Some responsibilities");

        ArrayList<WebElement> nameColumn = getColumn("nameColumn");

        String valueInColumn = getLastValue("idColumn");
        System.out.println("Value in column: " + valueInColumn);

        System.out.println("divNameColumn size: " + nameColumn.size());
        nameColumn.get(findMaxIdOffset()).click();

        String valueInDivisionInfo = cd.findElementById("ID").getText();
        System.out.println(valueInDivisionInfo);

        assertEquals(valueInDivisionInfo, valueInColumn);

        deleteLastPosition();
    }

    @Test
    public void testColumn_PositionName() {
        createNewPosition("testColumn_PositionName", 1, "test");
        String lastPosName = getLastValue("nameColumn");
        System.out.println("Last posName in column: " + lastPosName);

        assertEquals("testColumn_PositionName", lastPosName);

        deleteLastPosition();
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
