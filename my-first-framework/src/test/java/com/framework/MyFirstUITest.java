package com.framework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
    public static final String USERNAME = "andrejs-ps";
    WebDriver driver;
    @BeforeEach
    void setup() {
        // Create the driver object
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions().addArguments("start-fullscreen");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterEach
    void cleanUp() {
        driver.close();
    }

    @Test
    void userNameIsCorrectOnOverviewTab() {
        // Arrange
        driver.get(BASE_URL + USERNAME);

        // Act
        String actualUserName = driver.findElement(By.className("p-nickname")).getText();

        // Assert
        assertEquals(USERNAME, actualUserName);
    }

    @Test
    void repoLinkGoesToCorrectRepo() throws InterruptedException {
        // Arrange
        driver.get(BASE_URL + USERNAME);

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
        driver.get(BASE_URL + USERNAME);

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
