package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriver.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.assertj.*;
import static org.assertj.core.api.Assertions.assertThat;

public class TestClass extends Base_CommontoAll{

    @Test
    public void test_openvwologin(){
            driver = new EdgeDriver();
            openbrowser("https://app.vwo.com/");
            System.out.println(driver.getTitle());
            System.out.println(driver.getCurrentUrl());
            assertThat(driver.getCurrentUrl()).isNotNull().isNotBlank().isEqualTo("https://app.vwo.com/#/login");

            if(driver.getPageSource().contains("Sign in to VWO platform")){
                Assert.assertTrue(true);
                System.out.println("Test case successful");
            }
            else{
            Assert.fail("Test case is not successful");
            }
            closebrowser();
    }

}
