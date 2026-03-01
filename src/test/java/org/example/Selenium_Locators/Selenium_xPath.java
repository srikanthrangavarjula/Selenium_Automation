package org.example.Selenium_Locators;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.example.Base_CommontoAll;
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
import java.util.List;
import java.util.Set;

public class Selenium_xPath extends Base_CommontoAll {

    @Test
    @Owner("Srikanth R")
    @Description("Test katalon page")
    public void test_katalon_login() throws InterruptedException {

        ChromeOptions options = new  ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        WebElement makeappointment = driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
        makeappointment.click();

        List<WebElement> username_email = driver.findElements(By.xpath("//input[@placeholder='username']"));
        username_email.get(1).sendKeys("John Doe");

        List<WebElement> password = driver.findElements(By.xpath("//input[@placeholder='Password']"));
        password.get(1).sendKeys("ThisIsNotAPassword");
        Thread.sleep(1000);

        WebElement login = driver.findElement(By.xpath("//button[@id='btn-login']"));
        login.click();

        String currenturl = driver.getCurrentUrl();
        Assert.assertTrue(currenturl.contains("appointment"));

        driver.quit();
    }
}
