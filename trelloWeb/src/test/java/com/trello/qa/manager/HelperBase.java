package com.trello.qa.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperBase {

    WebDriver driver;

    public HelperBase(WebDriver driver) {

        this.driver = driver;
    }

    //-----------------------------COMMON METHODS--------------------------------------
    public void click(By locator) {

        driver.findElement(locator).click();
    }

    public boolean isElementPresent(By locator) {

        return driver.findElements(locator).size() > 0;
    }

    public int sizeList(By locator) {

        return driver.findElements(locator).size();

    }

    public void returnToHome() {
        //    "//a[@href='/']"
        //span[@name='house']
        if (isElementPresent(By.cssSelector("._3gUubwRZDWaOF0._2WhIqhRFBTG7Ry._2NubQcQM83YCVV"))) {
            new WebDriverWait(driver, 15).until(ExpectedConditions.
                    stalenessOf(driver.findElement(By.cssSelector("._3gUubwRZDWaOF0._2WhIqhRFBTG7Ry._2NubQcQM83YCVV"))));
            click(By.cssSelector("a[href='/']"));
            click(By.cssSelector("a[href='/']"));
        } else
            click(By.cssSelector("a[href='/']"));
    }

    public void clickXorCancel() {

    }

    void findElement(By locator) {

    }

    public boolean Visible(By locator) {

        return driver.findElement(locator).isDisplayed();
    }

    public void clickButtonPlusUp() {

        click(By.cssSelector("[data-test-id='header-create-menu-button']"));
    }

    public void fillTeamCreationForm(String teamName, String description) throws InterruptedException {

        typeTextInTheFieldNameBoard(By.cssSelector("[data-test-id='header-create-team-name-input']"), teamName);
        driver.findElement(By.className("css-1yqjdp6")).click();
        Thread.sleep(2000);
        //driver.findElement(By.xpath("//div[@class='css-dmzcl._1T1MG_BX1zeaq8']")).click();
        //driver.findElement(By.className("css-1yqjdp6")).click();
        driver.findElement(By.xpath("//*[contains(text(),'Sales')]")).click();
        Thread.sleep(2000);

        typeTextInTheFieldNameBoard(By.cssSelector("textarea"), description);
    }

    public void typeTextInTheFieldNameBoard(By locator, String text) {

        driver.findElement(locator).click();
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void waitForElementAndClick(By locator, int time) {

        new WebDriverWait(driver, time)
                .until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
}
