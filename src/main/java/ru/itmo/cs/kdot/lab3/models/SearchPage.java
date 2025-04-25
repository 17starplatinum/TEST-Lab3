package ru.itmo.cs.kdot.lab3.models;

import org.openqa.selenium.WebDriver;
import ru.itmo.cs.kdot.lab3.utils.Util;

public class SearchPage extends Page {
    public SearchPage(WebDriver webDriver) {
        super(webDriver);
        webDriver.manage().window().maximize();
        webDriver.get(Util.BASE_URL + "/?s");
    }
}
