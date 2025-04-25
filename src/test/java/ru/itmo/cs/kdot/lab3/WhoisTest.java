package ru.itmo.cs.kdot.lab3;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.itmo.cs.kdot.lab3.models.HomePage;
import ru.itmo.cs.kdot.lab3.models.ResultPage;
import ru.itmo.cs.kdot.lab3.models.WhoisPage;
import ru.itmo.cs.kdot.lab3.utils.Util;

import java.time.Duration;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WhoisTest {

    @BeforeAll
    static void prepareDrivers() {
        Util.prepareDrivers();
    }

    @AfterAll
    static void killDrivers() {
        Util.getDrivers().forEach(WebDriver::quit);
    }

    @Test
    void checkWhois() {
        Util.getDrivers().forEach(this::executeForFailure);
        Util.getDrivers().forEach(this::executeWithCapabilities);
    }

    private void executeForFailure(WebDriver webDriver) {
        HomePage homePage = new HomePage(webDriver);
        WhoisPage whoisPage = homePage.getWhoisPage();
        whoisPage.getWebDriver().get(Objects.requireNonNull(whoisPage.getWebDriver().getCurrentUrl()));
        WebElement form = webDriver.findElement(By.xpath("//input[@placeholder='Enter a domain or IP address...']"));
        form.sendKeys("#######################");
        WebElement btn = webDriver.findElement(By.xpath("//span[text()='Search']"));
        btn.click();
        WebElement caption = webDriver.findElement(By.xpath("//form/div[1]"));
        assertEquals("Whois Lookup", caption.getText());
    }

    private void executeWithCapabilities(WebDriver webDriver) {
        HomePage homePage = new HomePage(webDriver);
        WhoisPage whoisPage = homePage.getWhoisPage();

        ResultPage resultPage = whoisPage.getResultPage("horselaugh.com");
        /*
        ВНИМАНИЕ: КОСТЫЛЬ
        Делается для обхода капчи. Установлен таймаут, чтобы вручную его решить.
        Обычно рекомендуется через хук или через клон сайта делать. Но так как этот сайт настолько уёбищное говно, то ¯\_(ツ)_/¯.
         */
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        String caption = resultPage.getTitle();
        assertEquals("for Horselaugh.com", caption);
    }
}
