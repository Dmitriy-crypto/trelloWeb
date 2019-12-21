package com.trello.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardsDeletionTests extends TestBase {

    @Test()
    public void deleteAllPersonalBoards() throws InterruptedException {

        int i;//count delete boards

        app.getBoardHelper().returnToHome();

        int a = app.getBoardHelper().getNumbersPersonalBoards();

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n\nNumber boards before removal1: " + app.getBoardHelper().getNumbersPersonalBoards());

        //------------delete all boards---------------------------------------------------------------
        for (i = 0; (a) + 1 > 1; a--, i++) {
            //for (i = 0; (a + 1) > 1; a--, i++) {
            app.getBoardHelper().selectFirstPersonalBoard();
            app.getBoardHelper().closeTheBoard();
            app.getBoardHelper().deleteBoard();

        }
        app.getBoardHelper().getNumbersPersonalBoards();
        Assert.assertEquals(app.getBoardHelper().getNumbersPersonalBoards(), a);
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n" + "Number boards after removal: " + app.getBoardHelper().getNumbersPersonalBoards());
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@\n Deleted Personal Boards = " + i);
    }

}
