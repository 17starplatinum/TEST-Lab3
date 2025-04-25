package ru.itmo.cs.kdot.lab3.models;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.itmo.cs.kdot.lab3.utils.Util;

import java.time.Duration;

public class WhoisPage extends Page {
    @Getter
    private static final String NEW_URL = Util.BASE_URL.split("//")[0] + "research." + Util.BASE_URL.split("//")[1];
    public WhoisPage(WebDriver webDriver) {
        super(webDriver);
        webDriver.manage().window().maximize();
        webDriver.get(NEW_URL);
        Util.waitUntilPageLoads(webDriver, Duration.ofSeconds(1));
    }

    public ResultPage getResultPage(String url) {
        WebElement form = webDriver.findElement(By.xpath("//input[@placeholder='Enter a domain or IP address...']"));
        form.sendKeys(url);
        WebElement btn = webDriver.findElement(By.xpath("//span[text()='Search']"));
        btn.click();
        Util.waitUntilPageLoads(webDriver, Duration.ofSeconds(1));
        return new ResultPage(webDriver, url);
    }
}
