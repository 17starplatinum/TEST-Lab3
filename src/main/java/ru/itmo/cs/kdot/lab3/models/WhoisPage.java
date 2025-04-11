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
        webDriver.get(NEW_URL);
        Util.waitUntilPageLoads(webDriver, Duration.ofSeconds(1));
    }

    public ShoppingCartPage getShoppingCartPage() {
        WebElement btn = Util.getElementBySelector(webDriver, By.xpath("//a[@class='MuiTypography-root-143 MuiLink-root-138 MuiLink-underlineHover-140 Linkstyles__Container-sc-18r150c-0 urfVZ Buttonstyles__Link-sc-17xhqrw-2 joVtAb MuiTypography-colorPrimary-166']"));
        btn.click();
        Util.waitUntilPageLoads(webDriver, Duration.ofSeconds(1));
        return new ShoppingCartPage(webDriver);
    }
}
