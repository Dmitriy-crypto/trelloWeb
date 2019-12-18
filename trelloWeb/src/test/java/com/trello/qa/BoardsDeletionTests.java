package com.trello.qa;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardsDeletionTests extends TestBase {

    @Test()
    public void deleteAllPersonalBoards() throws InterruptedException {

        int i;//count delete boards

        app.returnToHome();

        int a = app.getNumbersPersonalBoards();

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n\nNumber boards before removal1: " + app.getNumbersPersonalBoards());

        //------------delete all boards---------------------------------------------------------------
        for (i = 0; (a) + 1 > 1; a--, i++) {
            //for (i = 0; (a + 1) > 1; a--, i++) {
            app.selectFirstPersonalBoard();
            app.closeTheBoard();
            app.deleteBoard();

        }
        app.getNumbersPersonalBoards();
        Assert.assertEquals(app.getNumbersPersonalBoards(), a);
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n" + "Number boards after removal: " + app.getNumbersPersonalBoards());
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@\n Deleted Personal Boards = " + i);
    }

}
