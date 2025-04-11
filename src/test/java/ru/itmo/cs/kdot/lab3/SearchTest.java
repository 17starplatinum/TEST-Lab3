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

public class SearchTest {
    private WebDriver webDriver;

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        webDriver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
        webDriver.quit();
    }

    @Test
    void checkWhois() {
        Util.getDrivers().forEach(this::executeForFailure);
        Util.getDrivers().forEach(this::executeWithCapabilities);
    }

    private void executeForFailure(WebDriver webDriver) {
        HomePage homePage = new HomePage(webDriver);
        WhoisPage whoisPage = homePage.getWhoisPage();
        whoisPage.getWebDriver().get(whoisPage.getWebDriver().getCurrentUrl());
        WebElement form = webDriver.findElement(By.xpath("//input[@placeholder='Enter a domain or IP address...']"));
        form.sendKeys("#######################");
        WebElement btn = webDriver.findElement(By.xpath("//span[text()='Search']"));
        btn.click();
        WebElement caption = webDriver.findElement(By.xpath("//div[@class='sc-jxOSlx lmqPbm']"));
        assertEquals("Whois Lookup", caption.getText());
    }

    private void executeWithCapabilities(WebDriver driver) {
        HomePage homePage = new HomePage(webDriver);
        WhoisPage whoisPage = homePage.getWhoisPage();
        whoisPage.getWebDriver().get(whoisPage.getWebDriver().getCurrentUrl());
        WebElement form = webDriver.findElement(By.xpath("//input[@placeholder='Enter a domain or IP address...']"));
        form.sendKeys("horselaugh.com");
        WebElement btn = webDriver.findElement(By.xpath("//span[text()='Search']"));
        btn.click();
        WebElement caption = webDriver.findElement(By.xpath("//div[@id='root']body/div[1]/div/div/h1/span"));
        assertEquals(" for Horselaugh.com", caption.getText());
    }
}
