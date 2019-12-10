package com.trello.qa;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BordsCreationTest extends TestBase {

    @Test(enabled = false)
    public void testCreathionBordFromHomePage() {
        clickOnWebElement(By.cssSelector("[data-test-id='header-create-menu-button']"));
        selectCreateTeamFromDropDon(By.cssSelector("[data-test-id='header-create-board-button']"));
        typeTextInTheField(By.cssSelector("[data-test-id=\"create-board-title-input\"]"), "Test Board");
        //-----------------board type selection - with or without a team--------------------

        clickOnWebElement(By.xpath("//button[@class='W6rMLOx8U0MrPx']//span[@name='down']"));

        if (s == 0) {
            clickOnWebElement(By.xpath("//div[@id='layer-manager-popover']//li[1]//button[1]"));
        } else
            clickOnWebElement(By.xpath("//nav[@class='SdlcRrTVPA8Y3K']//li[2]//button[1]"));
        //clickOnWebElement(By.xpath("//span[@class='_1uK2vQ_aMRS2NU'][contains(text(),'test_can_be_deleted')]"));
//-----------------board type selection - with or without a team--------------------
//span[@class='_1uK2vQ_aMRS2NU']//span[@name='check']

        clickOnWebElement(By.xpath("//button[@class='_1Lkx3EjS3wCrs7']//span[@name='down']"));

        if (s1 == 0) {

            clickOnWebElement(By.xpath("//li[1]//button[1]//span[1]//div[1]"));
        } else {
            clickOnWebElement(By.xpath("//div[@id='layer-manager-popover']//li[2]//button[1]"));

        }
//-------------------------------fon---------------------------------------------------
        clickOnWebElement(By.xpath("//div[@id='layer-manager-overlay']//li[2]"));
        //-------------------------------creat------------------------------------
        clickOnWebElement(By.xpath("//button[@class='_3UeOvlU6B5KUnS uj9Ovoj4USRUQz _2MgouXHqRQDP_5']"));


        Assert.assertTrue(isElementPresent(By.xpath("//div[@class='board-header-btn mod-board-name inline-rename-board js-rename-board']")), "sdfsdf");
    }

}


