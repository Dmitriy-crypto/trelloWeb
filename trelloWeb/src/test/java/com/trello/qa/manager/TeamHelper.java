package com.trello.qa.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class TeamHelper extends HelperBase {

    //------------------Variables for teams fill----------------------------------------
    public String teamName = "test11 - " + (int) System.currentTimeMillis();
    public String description = "descr Learn_delete_ok";
    // WebDriverWait driverWait;
    public String name2Team = "name2";
    public String desc = "desc";


    public TeamHelper(WebDriver driver) {

        super(driver);

    }

    //------------------------COMMON METHODS FOR CREAT------------------------------------------


    //---------------------------------METHODS FOR TEAMS-----------------------------------------------
    public String getTeamNameFromPage() {


        new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h1.u-inline")));
        return driver.findElement(By.cssSelector("h1.u-inline")).getText();
    }

    public int getTeamsCount() {

        new WebDriverWait(driver, 10).until(ExpectedConditions.
                presenceOfAllElementsLocatedBy(By.xpath("//*[@class='NC6qaILF7dGKjb']/../li")));
        return sizeList(By.xpath("//*[@class='NC6qaILF7dGKjb']/../li"));
    }

    public void deleteTeam() {

        driver.manage().window().fullscreen();
        new WebDriverWait(driver, 15).until(elementToBeClickable(By.cssSelector(".quiet-button")));
        click(By.cssSelector(".window-module.u-gutter"));

        new WebDriverWait(driver, 15).until(elementToBeClickable(By.cssSelector(".js-confirm.full.negate")));
        new WebDriverWait(driver, 15).until(elementToBeClickable(By.cssSelector(".js-confirm.full.negate")));
        click(By.cssSelector(".js-confirm.full.negate"));

        new WebDriverWait(driver, 15).until(elementToBeClickable(By.cssSelector("a[href='/']")));
        click(By.cssSelector("a[href='/']"));

    }

    public void openSettings() throws InterruptedException {

        new WebDriverWait(driver, 15).
                until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".icon-gear.icon-sm._2aV_KY1gTq1qWc")));
        new WebDriverWait(driver, 15).
                until(ExpectedConditions.elementToBeClickable(By.cssSelector(".icon-gear.icon-sm._2aV_KY1gTq1qWc")));

        click(By.cssSelector(".icon-gear.icon-sm._2aV_KY1gTq1qWc"));
        Thread.sleep(1000);
    }

    public void clickOnFirstTeam() {
//
        new WebDriverWait(driver, 15).until(elementToBeClickable(By.xpath("//*[@class='NC6qaILF7dGKjb']/../li")));
        click(By.xpath("//*[@class='NC6qaILF7dGKjb']/../li"));
    }

    public void initEditTeamProfile() {

        //click(By.cssSelector(".js-edit-profile"));// option
        waitForElementAndClick(By.cssSelector(".js-edit-profile"), 10);

    }

    public void changeTeamProfile() {

        typeTextInTheFieldNameBoard(By.xpath("//input[@name='displayName']"), name2Team);
        typeTextInTheFieldNameBoard(By.xpath("//textarea[@name='desc']"), desc);

    }

    public void confirmEditTeam() {

        click(By.cssSelector(".primary.wide.js-submit-profile"));
    }
}

