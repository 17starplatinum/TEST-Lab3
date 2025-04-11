package ru.itmo.cs.kdot.lab3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.itmo.cs.kdot.lab3.models.HomePage;
import ru.itmo.cs.kdot.lab3.models.WhoisPage;
import ru.itmo.cs.kdot.lab3.utils.Util;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BlogTest {
    //https://www.domaintools.com/resources/blog/

    private WebDriver webDriver;

    @BeforeEach
    void setUp() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
        webDriver.quit();
    }

    @Test
    void checkResources() {
        WebElement btn = webDriver.findElement(By.xpath("//div[@id='menu-item-26430']"));
        btn.click();
        Util.waitUntilPageLoads(webDriver, Duration.ofSeconds(1));
        WebElement caption = webDriver.findElement(By.xpath("//div[@class='av-special-heading-tag']/strong"));
        assertEquals("Resources", caption.getText());
    }
}
