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
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Selenium_Locators {

    @Test
    @Owner("Srikanth R")
    @Description("TC#1: Verify error message with invalid login credentials")
    @Severity(SeverityLevel.BLOCKER)
    public void verifyErrorMessageWithInvalidCredentials() throws InterruptedException {

        EdgeOptions edgoptions = new EdgeOptions();
        edgoptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgoptions);
        driver.get("https://app.vwo.com/#/login");

        WebElement email_input_box = driver.findElement(By.id("login-username"));
        email_input_box.sendKeys("admin@admin.com");
        WebElement email_pwd_box = driver.findElement(By.name("password"));
        email_pwd_box.sendKeys("admin1234");
        WebElement login_button = driver.findElement(By.id("js-login-btn"));
        login_button.click();
        Thread.sleep(2000);
        WebElement error_message = driver.findElement(By.className("notification-box-description"));
        System.out.println(error_message.getText());

        Assert.assertEquals(error_message.getText(),"Your email, password, IP address or location did not match");
        driver.quit();


    }
}
