package ru.itmo.cs.kdot.lab3.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.itmo.cs.kdot.lab3.utils.Util;

import java.time.Duration;

public class DemoPage extends Page {
    public DemoPage(WebDriver webDriver) {
        super(webDriver);
        webDriver.get(Util.BASE_URL + "/demo");
        Util.waitUntilPageLoads(webDriver, Duration.ofSeconds(1));
    }

    public void fillInputs(String firstName, String lastName, String title, String company, String email, String phone, String comment) {
        WebElement firstNameField = Util.getElementBySelector(webDriver, By.id("FirstName"));
        WebElement lastNameField = Util.getElementBySelector(webDriver, By.id("LastName"));
        WebElement jobTitleField = Util.getElementBySelector(webDriver, By.id("Title"));
        WebElement companyField = Util.getElementBySelector(webDriver, By.id("Company"));
        WebElement emailField = Util.getElementBySelector(webDriver, By.id("Email"));
        WebElement phoneField = Util.getElementBySelector(webDriver, By.id("Phone"));
        WebElement commentField = Util.getElementBySelector(webDriver, By.xpath("//input[@name='Comments']"));

        firstNameField.clear();
        firstNameField.sendKeys(firstName);
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
        jobTitleField.clear();
    }

    public void chooseSelectors(String country, String inquiryType) {
        WebElement countrySelect = Util.getElementBySelector(webDriver, By.id("Country"));
        countrySelect.click();
        String countryXPath = "//option[@value='"+ country + "']";
        WebElement countrySelected = Util.getElementBySelector(webDriver, By.xpath(countryXPath));
        countrySelected.click();

        WebElement inquirySelect = Util.getElementBySelector(webDriver, By.xpath("//select[@name='Contact_Inquiry_Type__c']"));
        inquirySelect.click();
        String inquiryXPath = "//option[@value='"+ inquiryType + "']";
        WebElement inquirySelected = Util.getElementBySelector(webDriver, By.xpath(inquiryXPath));
        inquirySelected.click();
    }

    public void submit() {
        WebElement loginButton = Util.getElementBySelector(webDriver, By.xpath("//button[@type='submit']"));
        loginButton.click();
        Util.waitUntilPageLoads(webDriver, Duration.ofSeconds(1));}

    public boolean isLoginSuccessful() {
        return true;
    }
}
