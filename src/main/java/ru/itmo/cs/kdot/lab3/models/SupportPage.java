package ru.itmo.cs.kdot.lab3.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.itmo.cs.kdot.lab3.utils.Util;

import java.time.Duration;

public class SupportPage extends Page {
    public SupportPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void open() {

        webDriver.get(Util.BASE_URL + "/support");
        Util.waitUntilPageLoads(webDriver, Duration.ofSeconds(1));
    }

    public boolean isDisplayingSearchResults() {
        WebElement title = Util.getElementBySelector(webDriver, By.xpath("//h1[@class='ep-item-grid-item-inner column-inner']"));
        return title.isDisplayed();
    }
}
