package ru.itmo.cs.kdot.lab3.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static ru.itmo.cs.kdot.lab3.utils.Util.BASE_URL;

public class VideoTutorialPage extends Page {
    public VideoTutorialPage(WebDriver webDriver) {
        super(webDriver);
        webDriver.get(BASE_URL + "/indicators-over-cocktails");
    }

    public void playVideo() {
        WebElement playButton = webDriver.findElement(By.xpath("//div[@class='ControlBar_module_controlBarWrapper__293a16b4']/div/button"));
        playButton.click();
    }
}
