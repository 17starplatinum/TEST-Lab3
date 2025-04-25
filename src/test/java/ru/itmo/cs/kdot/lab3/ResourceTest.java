package ru.itmo.cs.kdot.lab3;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import ru.itmo.cs.kdot.lab3.models.ArticlePage;
import ru.itmo.cs.kdot.lab3.models.HomePage;
import ru.itmo.cs.kdot.lab3.models.ResourcePage;
import ru.itmo.cs.kdot.lab3.utils.Util;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResourceTest {

    @BeforeAll
    static void prepareDrivers() {
        Util.prepareDrivers();
    }

    @AfterAll
    static void killDrivers() {
        Util.getDrivers().forEach(WebDriver::quit);
    }

    @Test
    void checkResources() {
        Util.getDrivers().forEach(this::executeWithCapabilities);
    }

    @Test
    void checkArticle() {
        Util.getDrivers().forEach(this::executeMaterialSelection);
    }

    private void executeWithCapabilities(WebDriver webDriver) {
        HomePage homePage = new HomePage(webDriver);
        ResourcePage resourcePage = homePage.getResourcePage();
        String caption = resourcePage.getCaption();
        assertEquals("Resources", caption);
    }

    private void executeMaterialSelection(WebDriver webDriver) {
        HomePage homePage = new HomePage(webDriver);
        ResourcePage resourcePage = homePage.getResourcePage();
        String title = resourcePage.getResourceTitle();
        ArticlePage articlePage = resourcePage.getResource();
        String articleTitle = articlePage.getResourceTitle();
        assertEquals(title, articleTitle);
    }
}
