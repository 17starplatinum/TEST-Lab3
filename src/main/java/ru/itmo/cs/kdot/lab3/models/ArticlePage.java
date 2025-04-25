package ru.itmo.cs.kdot.lab3.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.itmo.cs.kdot.lab3.utils.Util;

public class ArticlePage extends Page {
    public ArticlePage(WebDriver webDriver, String url) {
        super(webDriver);
        webDriver.get(Util.BASE_URL + "/resources/" + url);
    }

    public String getResourceTitle() {
        WebElement title = webDriver.findElement(By.xpath("//h1[@class='entry-title']"));
        return title.getText();
    }
}
