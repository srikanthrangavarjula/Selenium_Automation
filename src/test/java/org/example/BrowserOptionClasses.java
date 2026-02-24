package org.example;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class BrowserOptionClasses extends Base_CommontoAll{

    public static void main(String[] args) throws InterruptedException{

        EdgeOptions options = new EdgeOptions();
        //Firefox option, chromeoptions

        //options.addArguments("--window-size=800,600");
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        driver = new EdgeDriver(options);
        Thread.sleep(3000);
        driver.quit();
    }
}
