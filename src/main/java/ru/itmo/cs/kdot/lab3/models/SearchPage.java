package ru.itmo.cs.kdot.lab3.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.itmo.cs.kdot.lab3.utils.Util;

import java.time.Duration;

public class SearchPage extends Page {
    public SearchPage(WebDriver webDriver) {
        super(webDriver);
        webDriver.get(Util.BASE_URL + "/?s");
    }

    public boolean isDisplayingSearchResults(String searchTerm) {
        WebElement title = Util.getElementBySelector(webDriver, By.xpath("//h4[text()=' Results for: ']"));
        return title.isDisplayed();
    }
}
