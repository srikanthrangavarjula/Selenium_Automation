package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Base_CommontoAll {
   public static WebDriver driver;
    public void openbrowser(String url){
        driver.get(url);
        driver.manage().window().maximize();
    }
    public void closebrowser(){
        driver.quit();
    }
}
