package ru.itmo.cs.kdot.lab3.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import ru.itmo.cs.kdot.lab3.utils.Util;

import java.time.Duration;

public class ResourcePage extends Page {
    public ResourcePage(WebDriver webDriver) {
        super(webDriver);
        webDriver.get(Util.BASE_URL + "/resources");
    }

    public String getCaption() {
        WebElement caption = webDriver.findElement(By.xpath("//h1[@class='av-special-heading-tag ']/strong"));
        return caption.getText();
    }

    public ArticlePage getResource() {
        WebElement resource = webDriver.findElement(By.xpath("//div[@id='av_section_2']/div/div/div/div/div[2]/div/div[1]/div/div[2]/div[1]/h4/a"));
        Actions actions = new Actions(webDriver);
        actions.moveToElement(resource).click().perform();
        Util.waitUntilPageLoads(webDriver, Duration.ofSeconds(1));
        return new ArticlePage(webDriver, "blog/dti-inaugural-domain-intelligence-report-summary/");
    }

    public String getResourceTitle() {
        WebElement resource = webDriver.findElement(By.xpath("//div[@id='av_section_2']/div/div/div/div/div[2]/div/div[1]/div/div[2]/div[1]/h4/a"));
        return resource.getText().replace("\" ", "");
    }
}
