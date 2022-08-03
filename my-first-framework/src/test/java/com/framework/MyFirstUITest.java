package com.framework;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class MyFirstUITest {


    public static final String BASE_URL = "https://github.com/";
    //public static final String USERNAME = "andrejs-ps";
    static WebDriver driver;
    @BeforeAll
    static void setup() {
        // Create the driver object
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions().addArguments("start-fullscreen");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterAll
    static void cleanUp() {
        driver.close();
    }

    @Test
    void userNameIsCorrectOnOverviewTab() {
        // Arrange
        String user = "andrejs-ps";
        driver.get(BASE_URL + user);

        // Act
        String actualUserName = driver.findElement(By.className("p-nickname")).getText();

        // Assert
        assertEquals(user, actualUserName);
    }

    @Test
    void repoLinkGoesToCorrectRepo() throws InterruptedException {
        // Arrange
        String user = "andrejs-ps";
        driver.get(BASE_URL + user);

        // Act
        String repo = "automated-tests-in-java-with-fluent-interface-using-webdriver-selenium";
        WebElement repoLink = driver.findElement(By.linkText(repo));
        repoLink.click();
        Thread.sleep(500);
        String actualUrl = driver.getCurrentUrl();

        // Assertion
        assertEquals("https://github.com/andrejs-ps/" + repo, actualUrl);
    }

    @Test
    void numberOfReposMatchesTheCount() throws InterruptedException {
        // Arrange
        String user = "andrejs-ps";
        driver.get(BASE_URL + user);

        // Act
        driver.findElement(By.cssSelector("a[data-tab-item=repositories]")).click();
        Thread.sleep(500);
        String textOfRepos = driver.findElement(By.className("Counter")).getText();
        int numOfRepos = Integer.parseInt(textOfRepos);
        List<WebElement> repoList = driver.findElements(By.xpath("//div[@id='user-repositories-list']//li"));

        // Assert
        assertEquals(numOfRepos, repoList.size());
    }
}
