package ru.itmo.cs.kdot.lab3.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.itmo.cs.kdot.lab3.utils.Util;

import java.time.Duration;

public class HomePage extends Page {

    public HomePage(WebDriver webDriver) {
        super(webDriver);
        webDriver.get(Util.BASE_URL);
        Util.waitUntilPageLoads(webDriver, Duration.ofSeconds(1));
    }

    public DemoPage getDemoPage() {
        WebElement btn = Util.getElementBySelector(webDriver, By.xpath("//a[@class='avia-button  avia-icon_select-yes-left-icon avia-color-orange avia-size-medium']"));
        btn.click();
        Util.waitUntilPageLoads(webDriver, Duration.ofSeconds(1));
        return new DemoPage(webDriver);
    }

    public WhoisPage getWhoisPage() {
        WebElement btn = Util.getElementBySelector(webDriver, By.xpath("//div[@class='header-inner']/div[3]/div/ul/li[3]"));
        btn.click();
        Util.waitUntilPageLoads(webDriver, Duration.ofSeconds(1));
        return new WhoisPage(webDriver);
    }

    public SearchPage getSearchPage() {
        WebElement btn = Util.getElementBySelector(webDriver, By.xpath("//div[@class='header-inner']/div[3]/div/ul/li[1]"));
        btn.click();
        Util.waitUntilPageLoads(webDriver, Duration.ofSeconds(1));
        return new SearchPage(webDriver);
    }
}
