package com.webtests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestTemplate {
    public ChromeDriver chromeDriver;

    @Before
    public void before() {

        System.setProperty(
                "webdriver.chrome.driver",
                "/Users/Nikita/Work/FinalProject/src/main/resources/chromedriver"
        );

        chromeDriver = new ChromeDriver();

        System.out.println("===== " + "test started" + " =====");
    }

    @After
    public void after() {
        chromeDriver.quit();
        System.out.println("===== " + "test finished" + " =====");
    }


}
