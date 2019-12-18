package com.trello.qa;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
public class BoardsCreationTest extends TestBase {

  @Test(enabled = true)
  public void testCreationBoardsFromHomePage() throws InterruptedException {

      app.createBoards(app.numberBoards);
      Assert.assertTrue(app.isElementPresent(By.xpath("//div[@class='board-header-btn mod-board-name inline-rename-board js-rename-board']")), "sdfsdf");
  }

  @Test
  public void testCreationBoardFromHomePage() throws InterruptedException {

      app.createBoard();
  }
}


