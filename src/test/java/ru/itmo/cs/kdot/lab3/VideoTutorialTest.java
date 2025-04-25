package ru.itmo.cs.kdot.lab3;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.itmo.cs.kdot.lab3.models.HomePage;
import ru.itmo.cs.kdot.lab3.models.VideoTutorialPage;
import ru.itmo.cs.kdot.lab3.utils.Util;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

class VideoTutorialTest {
    @BeforeAll
    static void prepareDrivers() {
        Util.prepareDrivers();
    }

    @AfterAll
    static void killDrivers() {
        Util.getDrivers().forEach(WebDriver::quit);
    }

    @Test
    void checkVideoTutorial() {
        Util.getDrivers().forEach(this::executeWithCapabilities);
    }

    private void executeWithCapabilities(WebDriver webDriver) {
        HomePage homePage = new HomePage(webDriver);
        VideoTutorialPage videoPage = homePage.getVideoPage();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//div[@class='avia-iframe-wrap']/iframe")));
        videoPage.playVideo();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        String playTime = webDriver.findElement(By.xpath("//span[@class='ThumbnailPreview_module_time__11395132']")).getText();
        videoPage.playVideo();
        assertTrue(playTime.isEmpty());
    }
}
