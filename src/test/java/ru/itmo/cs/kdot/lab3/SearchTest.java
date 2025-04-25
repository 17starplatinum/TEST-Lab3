package ru.itmo.cs.kdot.lab3;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.itmo.cs.kdot.lab3.models.HomePage;
import ru.itmo.cs.kdot.lab3.models.SearchPage;
import ru.itmo.cs.kdot.lab3.utils.Util;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class SearchTest {
    @BeforeAll
    static void prepareDrivers() {
        Util.prepareDrivers();
    }

    @AfterAll
    static void killDrivers() {
        Util.getDrivers().forEach(WebDriver::quit);
    }

    @Test
    void checkSearch() {
        Util.getDrivers().forEach(this::executeForFailure);
        Util.getDrivers().forEach(this::executeWithCapabilities);
    }

    private void executeForFailure(WebDriver webDriver) {
        HomePage homePage = new HomePage(webDriver);
        SearchPage searchPage = homePage.getSearchPage();
        searchPage.getWebDriver().get(Objects.requireNonNull(searchPage.getWebDriver().getCurrentUrl()));
        WebElement field = webDriver.findElement(By.xpath("//form/div/input"));
        field.sendKeys("asgfqifbjkqfbieuqgfeq");
        WebElement btn = webDriver.findElement(By.xpath("//form/div/button"));
        btn.click();
        WebElement caption = webDriver.findElement(By.xpath("//div[@class='h4']"));
        assertEquals("No results for: asgfqifbjkqfbieuqgfeq", caption.getText());
    }

    private void executeWithCapabilities(WebDriver webDriver) {
        HomePage homePage = new HomePage(webDriver);
        SearchPage searchPage = homePage.getSearchPage();
        searchPage.getWebDriver().get(Objects.requireNonNull(searchPage.getWebDriver().getCurrentUrl()));
        WebElement field = webDriver.findElement(By.xpath("//form/div/input"));
        field.sendKeys("Russia");
        WebElement btn = webDriver.findElement(By.xpath("//form/div/button"));
        btn.click();
        WebElement caption = webDriver.findElement(By.xpath("//div[@class='h4']"));
        assertEquals("152 Results for: Russia", caption.getText());
    }
}
