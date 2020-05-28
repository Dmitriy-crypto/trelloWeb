package com.trello.qa.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {


    public SessionHelper(WebDriver driver) {

        super(driver);
    }

    public void clickContinueButton() {

        click(By.cssSelector("[type=submit]"));
    }

    public boolean isUserLoggedIn() {

        return isElementPresent(By.cssSelector("[data-test-id='header-member-menu-button']"));
    }

    public void loginToTrello(String email, String password) throws InterruptedException {

        click(By.cssSelector("[href='/login']"));
        //typeTextInTheFieldNameBoard(By.cssSelector("[type=email]"), email);
        typeTextInTheFieldNameBoard(By.xpath("//input[@id='user']"), email);
//        typeTextInTheField(By.cssSelector("[type=password]"), password);
        click(By.id("login"));
        Thread.sleep(3000);
        click(By.id("login-submit"));
        Thread.sleep(3000);
        typeTextInTheFieldNameBoard(By.id("password"), password);
        Thread.sleep(3000);
        click(By.id("login-submit"));
    }

    public void openSite(String url) {

        driver.navigate().to(url);
    }

    public void refreshPage() {

        driver.navigate().refresh();

    }
}
