package com.webtests;

import com.db.DAO.EmployeeTableManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class EmployeesTest {
    public ChromeDriver cd;
    public EmployeeTableManager etm = new EmployeeTableManager();
    public String pageURL = "http://localhost:8080/employees";


    // ===================================================================================

    private void createNewEmployee(String name, String surname, String patronymic, String education) {
        cd.findElementById("postName").clear();
        cd.findElementById("postName").sendKeys(name);

        cd.findElementById("postSurname").clear();
        cd.findElementById("postSurname").sendKeys(surname);

        cd.findElementById("postPatronymic").clear();
        cd.findElementById("postPatronymic").sendKeys(patronymic);

        cd.findElementById("postEducation").clear();
        cd.findElementById("postEducation").sendKeys(education);

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
        System.out.println("Last value: " + lastValue + " in column " + columnId);

        return lastValue;
    }

    private ArrayList<WebElement> getColumn(String columnId) {
        return (ArrayList<WebElement>) cd.findElementsById(columnId);
    }

    private void deleteLastEmployee() {
        cd.get(pageURL);
        int deleteId = Integer.parseInt(getLastValue("idColumn"));
        etm.delete(etm.getById(deleteId));
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

        createNewEmployee("testFilter1", "Surname1", "Patr", "Школа");
        createNewEmployee("testFilter2", "Surname1", "Patr", "ПТУ");
        createNewEmployee("testFilter3", "Surname2", "Patr", "Школа");
        createNewEmployee("testFilter4", "Surname2", "Patr", "ПТУ");

        WebElement getName, getSurname, getPatronymic, getEducation, Filter;
        ArrayList<WebElement> fullNameColumn, educationColumn;

        // 1
        cd.get(pageURL);

        getName = cd.findElementById("getName");
        getSurname = cd.findElementById("getSurname");
        getPatronymic = cd.findElementById("getPatronymic");
        getEducation = cd.findElementById("getEducation");

        Filter = cd.findElementById("Filter");

        getName.clear();
        getSurname.clear();
        getPatronymic.clear();
        getEducation.clear();

        getName.sendKeys("testFilter");
        Filter.click();

        fullNameColumn = getColumn("fullNameColumn");

        for (int i = 0; i < fullNameColumn.size(); i++) {
            System.out.println(fullNameColumn.get(i).getText());
            assertTrue(fullNameColumn.get(i).getText().contains("testFilter"));
        }
        System.out.println("Stage 1 passed");

        // 2

        cd.get(pageURL);
        getName = cd.findElementById("getName");
        getSurname = cd.findElementById("getSurname");
        getPatronymic = cd.findElementById("getPatronymic");
        getEducation = cd.findElementById("getEducation");

        Filter = cd.findElementById("Filter");

        getName.clear();
        getSurname.clear();
        getPatronymic.clear();
        getEducation.clear();

        getName.sendKeys("testFilter");
        getEducation.sendKeys("ПТУ");
        Filter.click();

        fullNameColumn = getColumn("fullNameColumn");
        educationColumn = getColumn("educationColumn");

        for (int i = 0; i < fullNameColumn.size(); i++) {
            assertTrue(fullNameColumn.get(i).getText().contains("testFilter"));
            assertTrue(educationColumn.get(i).getText().contains("ПТУ"));
        }
        System.out.println("Stage 2 passed");


        // 3
        cd.get(pageURL);
        getName = cd.findElementById("getName");
        getSurname = cd.findElementById("getSurname");
        getPatronymic = cd.findElementById("getPatronymic");
        getEducation = cd.findElementById("getEducation");

        Filter = cd.findElementById("Filter");

        getName.clear();
        getSurname.clear();
        getPatronymic.clear();
        getEducation.clear();

        getName.sendKeys("testFilter");
        getEducation.sendKeys("Школа");
        getSurname.sendKeys("Surname2");
        Filter.click();

        fullNameColumn = getColumn("fullNameColumn");
        educationColumn = getColumn("educationColumn");

        for (int i = 0; i < fullNameColumn.size(); i++) {
            assertTrue(fullNameColumn.get(i).getText().contains("testFilter"));
            assertTrue(fullNameColumn.get(i).getText().contains("Surname2"));
            assertTrue(educationColumn.get(i).getText().contains("Школа"));
        }
        System.out.println("Stage 3 passed");


        deleteLastEmployee();
        deleteLastEmployee();
        deleteLastEmployee();
        deleteLastEmployee();
    }

    @Test
    public void testDelete() {
        createNewEmployee("testDelete", "Surname", "Patronymic", "Школа жизни");

        System.out.println("Current url: " + cd.getCurrentUrl());
        int size1 = getColumn("idColumn").size();
        String lastId1 = getLastValue("idColumn");

        System.out.println("Current url: " + cd.getCurrentUrl());

        cd.findElementById("deleteId").clear();
        cd.findElementById("deleteId").sendKeys(lastId1);
        cd.findElementById("Delete").click();

        int size2 = getColumn("idColumn").size();
        String lastId2 = getLastValue("idColumn");

        assertNotEquals(lastId1, lastId2);
        assertEquals(size1 - 1, size2);
    }

    @Test
    public void testColumn_id_and_EmployeeFullNameLink() {
        createNewEmployee("testColumn_id_and_EmployeeFullNameLink", "Иванов", "Иванович", "Музыкальное училище");

        ArrayList<WebElement> empName = getColumn("fullNameColumn");

        String valueInColumn = getLastValue("idColumn");
        System.out.println("Value in column: " + valueInColumn);

        System.out.println("fullNameColumn size: " + empName.size());
        empName.get(findMaxIdOffset()).click();

        String idInEmployeeInfo = cd.findElementById("ID").getText();
        System.out.println(idInEmployeeInfo);

        assertEquals(idInEmployeeInfo, valueInColumn);

        deleteLastEmployee();
    }

    @Test
    public void testColumn_fullName() {
        createNewEmployee("testColumn_fullName", "Тополев", "Тополевич", "Аграрный университет");
        String lastName = getLastValue("fullNameColumn");
        System.out.println("Last divName in column: " + lastName);

        assertTrue(lastName.contains("testColumn_fullName"));

        deleteLastEmployee();
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
