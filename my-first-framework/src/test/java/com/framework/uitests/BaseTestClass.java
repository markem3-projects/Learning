package com.framework.uitests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import static com.testframework.DriverFactory.getChromeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class BaseTestClass {

    public static final String BASE_URL = "https://github.com/";
    //public static final String USERNAME = "andrejs-ps";
    static WebDriver driver;
    @BeforeAll
    static void setup() {
        driver = getChromeDriver();
    }

    @AfterAll
    static void cleanUp() {
        driver.close();
    }
}
