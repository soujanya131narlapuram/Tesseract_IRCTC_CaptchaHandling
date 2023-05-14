package com.selenium.baseclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BaseClass {

    public WebDriver driver;


    public void setup(){


        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--disable-notifications");
        driver=new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.get("https://www.irctc.co.in/nget/train-search");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    public void tearDown(){
        driver.close();

    }
}
