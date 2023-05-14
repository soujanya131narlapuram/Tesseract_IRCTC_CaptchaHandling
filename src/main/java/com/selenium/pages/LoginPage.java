package com.selenium.pages;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.Tesseract1;
import net.sourceforge.tess4j.TesseractException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

public class LoginPage {
    WebDriver driver;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'LOGIN')]")
    WebElement loginBtn;

    @CacheLookup
    @FindBy(xpath= "/html[1]/body[1]/app-root[1]/app-home[1]/div[3]/app-login[1]/p-dialog[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]/form[1]/div[1]/input[1]")
    WebElement username;

    @CacheLookup
    @FindBy(xpath = "/html[1]/body[1]/app-root[1]/app-home[1]/div[3]/app-login[1]/p-dialog[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]/form[1]/div[2]/input[1]")
    WebElement password;

    @CacheLookup
    @FindBy(xpath="//body/app-root[1]/app-home[1]/div[3]/app-login[1]/p-dialog[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]/form[1]/div[4]/div[1]/app-captcha[1]/div[1]/div[1]/div[2]/span[1]/img[1]")
    WebElement captcha;

    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void handleCaptcha() throws InterruptedException, IOException, TesseractException {


        Thread.sleep(1000);

        loginBtn.click();
        Thread.sleep(1000);
        username.sendKeys("testingtestdatablz@gmail.com");
        Thread.sleep(1000);
        password.sendKeys("testing123");
        Thread.sleep(1000);


        String path="C:\\Users\\ANIL\\AppData\\Local\\Temp\\CaptchaHandling_IRCTC_Terract\\src\\Screenshot\\captcha.png";
        File src=captcha.getScreenshotAs(OutputType.FILE);
        FileHandler.copy(src,new File(path));

        Tesseract1 img=new Tesseract1();
        img.setDatapath("D:\\Tesseract\\tessdata");
        String captchaText=img.doOCR(new File(path));
        System.out.println(captchaText);

    }

}
