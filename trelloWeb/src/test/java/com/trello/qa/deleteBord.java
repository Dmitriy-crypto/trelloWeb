package com.trello.qa;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class deleteBord extends TestBase {


    @Test()
    public void deleteBord() throws InterruptedException {
        int a, b;

        clickOnWebElement(By.xpath("//a[@class='_2ZNy4w8Nfa58d1 _2ZNy4w8Nfa58d1 _1WD42rQsKIT-I6']"));
        //for (int x = 0; x < 9; x = x + 1)


        a = sizeList(By.xpath("//*[@class='boards-page-board-section-list']//li"));

        System.out.println(a);

        for (; a > 1; ) {


            //div[@class='all-boards']//div[2]//ul[1]
            //clickOnWebElement(By.xpath("//div[@class='all-boards']//div[2]//ul[1]//li[1]"));
            clickOnWebElement(By.xpath("//*[@class='boards-page-board-section-list']//li[1]"));

            if (isElementPresent(By.xpath("//a[@class='board-header-btn mod-show-menu js-show-sidebar']"))) {
                clickOnWebElement(By.xpath("//a[@class='board-header-btn mod-show-menu js-show-sidebar']"));
            }


            clickOnWebElement(By.xpath("//a[@class='board-menu-navigation-item-link js-open-more']"));
            Thread.sleep(3000);
            clickOnWebElement(By.xpath("//a[@class='board-menu-navigation-item-link js-close-board']"));
            clickOnWebElement(By.xpath("//input[@class='js-confirm full negate']"));
            Thread.sleep(3000);
            clickOnWebElement(By.xpath("//a[@class='quiet js-delete']"));
            Thread.sleep(3000);
            clickOnWebElement(By.xpath("//input[@class='js-confirm full negate']"));
            Thread.sleep(3000);
            clickOnWebElement(By.xpath("//a[@class='_2ZNy4w8Nfa58d1 _2ZNy4w8Nfa58d1 _1WD42rQsKIT-I6']"));
            Thread.sleep(3000);
            System.out.println(b = sizeList(By.xpath("//*[@class='boards-page-board-section-list']//li")));
            a--;
            Assert.assertEquals(a, b);

        }
//div[@class='all-boards']//div[2]//ul[1]


    }


}
