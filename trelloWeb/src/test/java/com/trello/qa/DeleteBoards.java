package com.trello.qa;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteBoards extends TestBase {

    @Test()
    public void deleteAllPersonalBoards() throws InterruptedException {

        int i;//count delete boards

        returnToHome();

        int a = getNumbersPersonalBoards();

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n\nNumber boards before removal1: " + getNumbersPersonalBoards());

        //------------delete all boards---------------------------------------------------------------
        for (i = 0; (a + 1) > 1; a--, i++) {
            selectFirstPersonalBoard();
            closeTheBoard();
            deleteBoard();
        }
        getNumbersPersonalBoards();
        Assert.assertEquals(getNumbersPersonalBoards(), a);
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n" + "Number boards after removal: " + getNumbersPersonalBoards());
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@\n Deleted Personal Boards = " + i);
    }

}
