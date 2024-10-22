package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    @BeforeMethod
    public void start() {
        driver.set(new FirefoxDriver());
        getDriver().get("https://www.trendyol.com");
        getDriver().findElement(By.className("modal-close")).click();
        getDriver().findElement(By.id("onetrust-accept-btn-handler")).click();
    }

    @AfterMethod
    public void stop() {
        getDriver().quit();
    }
}
