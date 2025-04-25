package ru.itmo.cs.kdot.lab3.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import ru.itmo.cs.kdot.lab3.utils.Util;

import java.time.Duration;

public class DemoPage extends Page {
    public DemoPage(WebDriver webDriver) {
        super(webDriver);
        webDriver.manage().window().maximize();
        webDriver.get(Util.BASE_URL + "/demo");
        Util.waitUntilPageLoads(webDriver, Duration.ofSeconds(1));
    }

    public void fillInputs(String firstName, String lastName, String title, String company, String email, String phone, String comment) {
        WebElement firstNameField = Util.getElementBySelector(webDriver, By.xpath("//input[@id='FirstName']"));
        WebElement lastNameField = Util.getElementBySelector(webDriver, By.xpath("//input[@id='LastName']"));
        WebElement jobTitleField = Util.getElementBySelector(webDriver, By.xpath("//input[@id='Title']"));
        WebElement companyField = Util.getElementBySelector(webDriver, By.xpath("//input[@id='Company']"));
        WebElement emailField = Util.getElementBySelector(webDriver, By.xpath("//input[@id='Email']"));
        WebElement phoneField = Util.getElementBySelector(webDriver, By.xpath("//input[@id='Phone']"));
        WebElement commentField = Util.getElementBySelector(webDriver, By.xpath("//textarea[@name='commentCapture']"));

        firstNameField.clear();
        firstNameField.sendKeys(firstName);
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
        jobTitleField.clear();
        jobTitleField.sendKeys(title);
        companyField.clear();
        companyField.sendKeys(company);
        emailField.clear();
        emailField.sendKeys(email);
        phoneField.clear();
        phoneField.sendKeys(phone);
        commentField.clear();
        commentField.sendKeys(comment);
    }

    public void chooseSelectors(String country, String inquiryType) {
        WebElement countrySelect = Util.getElementBySelector(webDriver, By.id("Country"));
        Actions actions = new Actions(webDriver);
        actions.moveToElement(countrySelect).click().perform();
        String countryXPath = "//option[@value='" + country + "']";
        WebElement countrySelected = Util.getElementBySelector(webDriver, By.xpath(countryXPath));
        countrySelected.click();

        WebElement inquirySelect = Util.getElementBySelector(webDriver, By.xpath("//select[@name='Contact_Inquiry_Type__c']"));
        inquirySelect.click();
        String inquiryXPath = "//option[@value='" + inquiryType + "']";
        WebElement inquirySelected = Util.getElementBySelector(webDriver, By.xpath(inquiryXPath));
        inquirySelected.click();
    }

    public void submit() {
        WebElement loginButton = Util.getElementBySelector(webDriver, By.xpath("//button[@type='submit']"));
        loginButton.click();
        Util.waitUntilPageLoads(webDriver, Duration.ofSeconds(1));
    }
}
