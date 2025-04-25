package ru.itmo.cs.kdot.lab3;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.itmo.cs.kdot.lab3.models.DemoPage;
import ru.itmo.cs.kdot.lab3.models.HomePage;
import ru.itmo.cs.kdot.lab3.utils.Util;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DemoTest {
    @BeforeAll
    static void prepareDrivers() {
        Util.prepareDrivers();
    }

    @AfterAll
    static void killDrivers() {
        Util.getDrivers().forEach(WebDriver::quit);
    }

    @Test
    void checkDemo() {
        Util.getDrivers().forEach(this::executeForFailure);
        Util.getDrivers().forEach(this::executeWithCapabilities);
    }

    private void executeForFailure(WebDriver webDriver) {
        HomePage homePage = new HomePage(webDriver);
        DemoPage demoPage = homePage.getDemoPage();
        webDriver.switchTo().frame(webDriver.findElement(By.xpath("//div[@id='connect-now']/iframe")));
        demoPage.fillInputs("????", "???????", "хуй", "PMC Ryodan", "efnioefniweniofwe", "+75658765416", "");
        demoPage.chooseSelectors("AF", "Brand Protection");
        demoPage.submit();
        webDriver.switchTo().defaultContent();
        assertEquals("Take the Next Step, Request a Demo.", webDriver.findElement(By.xpath("//div[@id='demo']/h1")).getText());
    }

    private void executeWithCapabilities(WebDriver webDriver) {
        HomePage homePage = new HomePage(webDriver);
        DemoPage demoPage = homePage.getDemoPage();
        webDriver.switchTo().frame(webDriver.findElement(By.xpath("//div[@id='connect-now']/iframe")));
        demoPage.fillInputs("Ariguun", "Bolorbold", "Intern", "Yandex", "ariguunbolorbold@yandex.ru", "+75658765416", "");
        demoPage.chooseSelectors("RU", "Fraud");
        demoPage.submit();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String message = webDriver.findElement(By.xpath("//h1/span")).getText();
        webDriver.switchTo().defaultContent();
        assertEquals("Thank You", message);
    }
}
