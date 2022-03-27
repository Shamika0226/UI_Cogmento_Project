package com.Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import java.util.concurrent.TimeUnit;

public class WebDriverManager {
    public static String loginUrl;
    public static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }
    public static void setDriver(WebDriver driver) {
        WebDriverManager.driver = driver;
    }

    @BeforeClass
    public static void browserSetup(String url){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers//chromedriver.exe");
        driver = new ChromeDriver();
        loginUrl="https://ui.cogmento.com/";
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        System.out.println("Browser has started");

    }

    @AfterClass
    public static void browserTearDown(){

        driver.quit();
    }
}
