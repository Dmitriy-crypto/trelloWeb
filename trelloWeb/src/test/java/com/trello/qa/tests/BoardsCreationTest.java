package com.trello.qa.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardsCreationTest extends TestBase {

    @Test(enabled = true)
    public void testCreationBoardsFromHomePage() throws InterruptedException {

        app.getBoardHelper().createBoards(app.numberBoards);
        Assert.assertTrue(app.getBoardHelper().isElementPresent(By.xpath("//div[@class='board-header-btn mod-board-name inline-rename-board js-rename-board']")), "sdfsdf");
    }

    @Test
    public void testCreationBoardFromHomePage() throws InterruptedException {

        app.getBoardHelper().createBoard();
    }
}


