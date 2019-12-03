package com.trello.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {

    WebDriver driver;

    public static String url = "https://trello.com/";
    public static String email = "elena.telran@yahoo.com";
    public static String password = "12345.com";
    
    //public static String email = "dmitriy.stadnikov@yahoo.com";
    //public static String password = "75dmitriy.13Eva";

    @BeforeMethod
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

//driver.manage().window().fullscreen();

        openSite(url);
        login(email, password);


    }

    public void login(String email, String password) {
        //click(By.cssSelector("[href='/login]'"));
        click(By.cssSelector("[href='/login']"));
        type(By.cssSelector("[type=email]"), email);
        type(By.cssSelector("[type=password]"), password);
        click(By.id("login"));

    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }


    public void type(By locator, String text) {
        driver.findElement(locator).click();
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);


    }

    //----------------------------------------------------------------------------
    public void openSite(String url) {
        driver.navigate().to(url);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public boolean isUserLoggedIn() {
        return isElementPresent(By.cssSelector("[data-test-id='header-member-menu-button']"));
    }

    private boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;

    }
}
