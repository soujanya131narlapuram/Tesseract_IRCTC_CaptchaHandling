package com.selenium.irctc.test;

import com.selenium.baseclass.BaseClass;
import com.selenium.pages.LoginPage;
import net.sourceforge.tess4j.TesseractException;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class IrctcTest extends BaseClass {

LoginPage login;

    @BeforeTest
    public void init(){
        setup();
        login=new LoginPage(driver);

    }

    @Test
    public void handlingTextCaptcha() throws TesseractException, IOException, InterruptedException {

        login.handleCaptcha();

        Thread.sleep(3000);

    }
    @AfterTest
    public void closingBrowser(){
        tearDown();
    }
}
