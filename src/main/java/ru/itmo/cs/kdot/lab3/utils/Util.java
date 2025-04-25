package ru.itmo.cs.kdot.lab3.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Util {

    private Util() {
        throw new IllegalStateException("Utility class");
    }

    public static final String CHROME_SYSTEM_PROPERTY_NAME = "webdriver.chrome.driver";
    public static final String CHROME_SYSTEM_PROPERTY_PATH = System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe";
    public static final String BASE_URL = "https://domaintools.com";

    public static void prepareDrivers() {
        System.setProperty(CHROME_SYSTEM_PROPERTY_NAME, CHROME_SYSTEM_PROPERTY_PATH);
    }

    public static List<WebDriver> getDrivers() {
        List<WebDriver> drivers = new ArrayList<>();
        drivers.add(getChromeDriver());
        return drivers;
    }

    private static ChromeDriver getChromeDriver() {
        return new ChromeDriver();
    }

    public static WebElement getElementBySelector(WebDriver driver, By selector) {
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofMillis(300));
        return driverWait.until(ExpectedConditions.visibilityOfElementLocated(selector));
    }

    public static void waitUntilPageLoads(WebDriver driver, Duration timeout) {
        WebDriverWait waitDriver = new WebDriverWait(driver, timeout);
        waitDriver.until(webDriver -> Objects.equals(((JavascriptExecutor) webDriver).executeScript("return document.readyState"), "complete"));
    }
}
