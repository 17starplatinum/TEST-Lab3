package ru.itmo.cs.kdot.lab3.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.itmo.cs.kdot.lab3.utils.Util;

import java.time.Duration;

public class ShoppingCartPage extends Page {
    private static final String NEW_URL = Util.BASE_URL.split("//")[0] + "secure." + Util.BASE_URL.split("//")[1] + "/shopping-cart";
    public ShoppingCartPage(WebDriver webDriver) {
        super(webDriver);
        webDriver.get(NEW_URL);
        Util.waitUntilPageLoads(webDriver, Duration.ofSeconds(1));
    }

    public boolean isDisplayedPrices() {
        WebElement title = Util.getElementBySelector(webDriver, By.xpath("//h1[text()='Purchase with Confidence']"));
        return title.isDisplayed();
    }
}
