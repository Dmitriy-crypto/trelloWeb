package com.trello.qa;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager();

    //-------------------login ahd password-----------------------------
//    public static String email = "elena.telran@yahoo.com";
//    public static String password = "12345.com";

    //-------------------End variables-------------------------------------------

    @BeforeSuite
    public void setUp() throws InterruptedException {

        app.init();
    }

    @AfterSuite
    public void tearDown() {

        app.stop();
    }

 /* public void confirmBoardCreation(By locator) {
//By.xpath("//button[@class='_3UeOvlU6B5KUnS uj9Ovoj4USRUQz _2MgouXHqRQDP_5']
    //By.cssSelector("[data-test-id='create-board-submit-button']"
    clickOnWebElement(locator);
  }*/


}
