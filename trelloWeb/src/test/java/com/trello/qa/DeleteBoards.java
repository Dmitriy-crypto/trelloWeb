package com.trello.qa;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteBoards extends TestBase {

    @Test()
    public void deleteAllPersonalBoards() throws InterruptedException {

        createBoard(numberBoards);
        int a;//number boards before removal
        int b;// number boards after removal
        int c;
        int i;
        Thread.sleep(3000);
        clickOnWebElement(By.xpath("//span[@name='house']"));//click on a button Home
        Thread.sleep(2000);
        clickOnWebElement(By.xpath("//span[@name='house']"));//click on a button Home
        a = sizeList(By.xpath("//span[@class='icon-lg icon-member']/../../..//ul//li"));//number of boards all before removal
        c = a;
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n\nNumber boards before removal1: " + (c - 1));
        //------------delete all boards---------------------------------------------------------------
        for (i = 0; a > 1; a--, i++) {
            // click/select the first board  in the block : Personal boards
            clickOnWebElement(By.xpath("//span[@class='icon-lg icon-member']/../../..//ul//li"/*"//div[@class='all-boards']//div[2]//ul[1]//*[@class='boards-page-board-section-list-item'][1]"*/));
            if (Visible(By.xpath("//a[@class='board-header-btn mod-show-menu js-show-sidebar']"))) { //button MENU
                clickOnWebElement(By.xpath("//a[@class='board-header-btn mod-show-menu js-show-sidebar']"));
            } else {
                clickOnWebElement(By.xpath("//a[@class='board-menu-navigation-item-link js-open-more']"));// button MORE down
            }
            clickOnWebElement(By.xpath("//a[@class='board-menu-navigation-item-link js-close-board']"));// button close board down
            Thread.sleep(2000);
            clickOnWebElement(By.xpath("//input[@class='js-confirm full negate']"));// button CLOSE additionally
            Thread.sleep(3000);
            clickOnWebElement(By.xpath("//a[@class='quiet js-delete']"));//permanently delete
            Thread.sleep(2000);
            clickOnWebElement(By.xpath("//input[@class='js-confirm full negate']"));// button CLOSE additionally
            Thread.sleep(3000);
            clickOnWebElement(By.xpath("//a[@class='_2ZNy4w8Nfa58d1 _2ZNy4w8Nfa58d1 _1WD42rQsKIT-I6']"));//click on a button Home
            //clickOnWebElement(By.xpath("//span[@name='house']"));//click on a button Home
        }
        b = sizeList(By.xpath("//span[@class='icon-lg icon-member']/../../..//ul//li"));
        Assert.assertEquals(b, a);
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n" + "Number boards after removal: " + (b - 1) + "\nWOOOU Tests pass");
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@\n Deleted boards = " + i);
    }

}
