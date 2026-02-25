package org.example.Selenium_Locators;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class Windowhandling_LinkText_PartialLink_TagName {

    @Test
    @Owner("Srikanth R")
    @Description("TC#1: Verify error message with invalid login credentials")
    @Severity(SeverityLevel.BLOCKER)
    public void Link_PartialLinktext() throws InterruptedException {

        ChromeOptions edgoptions = new ChromeOptions();
        edgoptions.addArguments("--incognito");
        edgoptions.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(edgoptions);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://app.vwo.com/#/login");

        String mainwindow = driver.getWindowHandle();
        WebElement a_freetrail_link = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Start a free")));
        a_freetrail_link.click();

        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String> allwindows = driver.getWindowHandles();
        for(String individualwindow:allwindows)
        {
            if(!individualwindow.equals(mainwindow))
            {
                driver.switchTo().window(individualwindow);
            }
        }

        WebElement business_email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
        business_email.sendKeys("admin");
        
        try {
            WebElement acceptCookies = wait.until(ExpectedConditions.elementToBeClickable(By.id("onetrust-accept-btn-handler")));
            acceptCookies.click();
        } catch (Exception e) {}
        
        WebElement consent_checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.name("gdpr_consent_checkbox")));
        consent_checkbox.click();
        WebElement submit_button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Create a Free Trial Account']")));
        submit_button.click();

        WebElement error_message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space()='The email address you entered is incorrect.']")));
        Assert.assertEquals(error_message.getText(),"The email address you entered is incorrect.");
        driver.quit();


    }
}