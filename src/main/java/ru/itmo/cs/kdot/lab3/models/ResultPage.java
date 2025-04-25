package ru.itmo.cs.kdot.lab3.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ru.itmo.cs.kdot.lab3.utils.Util;

public class ResultPage extends Page {
    private static final String NEW_URL = Util.BASE_URL.split("//")[0] + "whois." + Util.BASE_URL.split("//")[1];

    public ResultPage(WebDriver webDriver, String url) {
        super(webDriver);
        webDriver.get(NEW_URL + "/" + url);
    }

    public String getTitle() {
        WebElement caption = webDriver.findElement(By.xpath("//h1[@class='title']/span"));
        return caption.getText();
    }
}
