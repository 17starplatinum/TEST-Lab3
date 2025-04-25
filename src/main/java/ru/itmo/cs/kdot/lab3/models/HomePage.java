package ru.itmo.cs.kdot.lab3.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import ru.itmo.cs.kdot.lab3.utils.Util;

import java.time.Duration;

public class HomePage extends Page {

    public HomePage(WebDriver webDriver) {
        super(webDriver);
        webDriver.manage().window().maximize();
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

    public ResourcePage getResourcePage() {
        WebElement btn = webDriver.findElement(By.xpath("//ul[@id='menu-main-menu-large-b-dev']/li[6]/a"));
        btn.click();
        Util.waitUntilPageLoads(webDriver, Duration.ofSeconds(1));
        return new ResourcePage(webDriver);
    }
    public VideoTutorialPage getVideoPage() {
        WebElement btn = webDriver.findElement(By.xpath("//div[@id='av_section_5']/div/div/div/div/div/div/div[1]/div/a"));
        Actions actions = new Actions(webDriver);
        actions.moveToElement(btn).click().perform();
        Util.waitUntilPageLoads(webDriver, Duration.ofSeconds(1));
        return new VideoTutorialPage(webDriver);
    }
}
