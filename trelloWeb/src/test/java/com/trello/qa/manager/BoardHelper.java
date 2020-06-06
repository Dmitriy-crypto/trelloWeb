package com.trello.qa.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BoardHelper extends HelperBase {

    //----------------------------Variables for boards fill------------------------------------------------------
    public String x = "23";
    //------------------------------------------------------------------------------------------------------------
    public String boardName = "Board off test - " + (int) System.currentTimeMillis();// name board to creat
    boolean no_team = true;//option selection
    boolean privet_team = true;//option selection not work
    //else
    int background_selection = 1;// start number underground off board
    boolean enable_background_random = true;// enable random background selection

    public BoardHelper(WebDriver driver) {

        super(driver);
    }

    public void selectCreateBoardFromDropDown() {

        click(By.cssSelector("[data-test-id='header-create-board-button']"));
    }

    //----------------------------METHODS FOR BOARDS-----------------------------------------
    public void createBoard() throws InterruptedException {

        clickButtonPlusUp();// button create " + "

        Thread.sleep(1000);
        String boardName1 = "";
        boardName1 = "#-" + x + " " + boardName;

        selectCreateSomethingFromDropDown(By.cssSelector("[data-test-id='header-create-board-button']"));
        typeTextInTheFieldNameBoard(By.cssSelector("[data-test-id=\"create-board-title-input\"]"), boardName1);
        //----------------board type selection - with or without a team--------------------
        /*Thread.sleep(2000);
        click(By.xpath("//button[@class='W6rMLOx8U0MrPx']//span[@name='down']"*//*button ^ select *//*));
        Thread.sleep(2000);
        if (no_team) {

            click(By.xpath("//div[@id='layer-manager-popover']//li[1]//button[1]"));
        } else
            click(By.xpath("//nav[@class='SdlcRrTVPA8Y3K']//li[2]//button[1]"));
        Thread.sleep(1000);
        click(By.xpath("//button[@class='_1Lkx3EjS3wCrs7']//span[@name='down']"));
        if (privet_team) {
            Thread.sleep(1000);
            click(By.xpath("//li[1]//button[1]//span[1]//div[1]"));
            //clickOnWebElement(By.cssSelector("//*[@class='_2BQG4yPMt5s_hu _3qi72H5bh1Hw2k _2BsMHO2GghWoia _3CXWmcvfj_w5yC _1Hfz_OCLW086D8']"));
            Thread.sleep(1000);
        } else {
            //clickOnWebElement(By.cssSelector("button.subtle-chooser-trigger.unstyled-button.vis-chooser-trigger > span.icon-sm.icon-down.subtle-chooser-trigger-dropdown-icon.light:nth-child(2)"));
            click(By.xpath("//div[@id='layer-manager-popover']//li[2]//button[1]"));
            //clickOnWebElement(By.xpath("//button[@class='_1Lkx3EjS3wCrs7']//span[@name='down']"));
            Thread.sleep(5000);
            //clickOnWebElement(By.xpath("//div[@id='layer-manager-popover']//li[2]//button[1]"));
            //clickOnWebElement(By.xpath("//span[@name='public']"));
            //clickOnWebElement(By.xpath("//body/div[@id='trello-root']/div[@id='chrome-container']/div[@class='js-react-root']/div[@id='layer-manager-popover']/div[@class='Y34HN84mGuwAaM _1-EJ9-6xaTaAf-']/div[@class='_3n2uNSrVwAmo1u']/nav[@class='_2R1DnMySK1mTDa']/ul/li[2]/button[1]/span[1]"));
            click(By.xpath("//div[@class='pop-over mod-no-header is-shown']//li[2]//a[1]//span[2]"));

            Thread.sleep(12000);
            //clickOnWebElement(By.xpath("//button[@class='_3UeOvlU6B5KUnS _2MgouXHqRQDP_5 _3ZPeWh5QQj47DA']"));
            //clickOnWebElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[4]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]"));
            //clickOnWebElement(By.cssSelector("._3UeOvlU6B5KUnS._2MgouXHqRQDP_5._3ZPeWh5QQj47DA"));
            // class="_3UeOvlU6B5KUnS _2MgouXHqRQDP_5 _3ZPeWh5QQj47DA"

        }*/
//-------------------------------background--------------------------------------------------

        if (enable_background_random) {
            background_selection = (int) (Math.random() * 8 + 1);
        }
        click(By.xpath("//div[@id='layer-manager-overlay']//li[" + background_selection + "]"));
        //-------------------------------create board------------------------------------
        click(By.cssSelector("[data-test-id='create-board-submit-button']"));
        //-----------------------------------
        Thread.sleep(1000);
    }

    //'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
    public void createBoards(int numberBoards) throws InterruptedException {


        for (int x = 1; numberBoards > 0; numberBoards--, x++) {

            clickButtonPlusUp();// button create " + "

            Thread.sleep(1000);
            String boardName1 = "";
            boardName1 = "#-" + x + " " + boardName;

            selectCreateSomethingFromDropDown(By.cssSelector("[data-test-id='header-create-board-button']"));
            typeTextInTheFieldNameBoard(By.cssSelector("[data-test-id=\"create-board-title-input\"]"), boardName1);
            //----------------board type selection - with or without a team--------------------
            Thread.sleep(2000);
            click(By.xpath("//button[@class='W6rMLOx8U0MrPx']//span[@name='down']"/*button ^ select */));
            Thread.sleep(2000);
            if (no_team) {

                click(By.xpath("//div[@id='layer-manager-popover']//li[1]//button[1]"));
            } else
                click(By.xpath("//nav[@class='SdlcRrTVPA8Y3K']//li[2]//button[1]"));
            Thread.sleep(1000);
            click(By.xpath("//button[@class='_1Lkx3EjS3wCrs7']//span[@name='down']"));
            if (privet_team) {
                Thread.sleep(1000);
                click(By.xpath("//li[1]//button[1]//span[1]//div[1]"));
                //clickOnWebElement(By.cssSelector("//*[@class='_2BQG4yPMt5s_hu _3qi72H5bh1Hw2k _2BsMHO2GghWoia _3CXWmcvfj_w5yC _1Hfz_OCLW086D8']"));
                Thread.sleep(1000);
            } else {
                click(By.xpath("//li[1]//button[1]//span[1]//div[1]"));
                //clickOnWebElement(By.xpath("//div[@id='layer-manager-popover']//li[2]//button[1]"));
                //clickOnWebElement(By.xpath("//button[@class='_1Lkx3EjS3wCrs7']//span[@name='down']"));
                Thread.sleep(2000);
                //clickOnWebElement(By.xpath("//div[@id='layer-manager-popover']//li[2]//button[1]"));
                //clickOnWebElement(By.xpath("//span[@name='public']"));
                //clickOnWebElement(By.xpath("//body/div[@id='trello-root']/div[@id='chrome-container']/div[@class='js-react-root']/div[@id='layer-manager-popover']/div[@class='Y34HN84mGuwAaM _1-EJ9-6xaTaAf-']/div[@class='_3n2uNSrVwAmo1u']/nav[@class='_2R1DnMySK1mTDa']/ul/li[2]/button[1]/span[1]"));
                click(By.cssSelector("//*[@name='public']/."));

                Thread.sleep(2000);
                //clickOnWebElement(By.xpath("//button[@class='_3UeOvlU6B5KUnS _2MgouXHqRQDP_5 _3ZPeWh5QQj47DA']"));
                click(By.cssSelector("//*[@class='X6LMWvod566P68']//button[1]"));

            }
//-------------------------------background--------------------------------------------------

            if (enable_background_random) {
                background_selection = (int) (Math.random() * 8 + 1);
            }
            click(By.xpath("//div[@id='layer-manager-overlay']//li[" + background_selection + "]"));
            //-------------------------------create board------------------------------------
            click(By.cssSelector("[data-test-id='create-board-submit-button']"));
            //-----------------------------------
            Thread.sleep(1000);
        }
        //System.out.println("Created " + (x - 1) + " boards.");

    }


    public int getNumbersPersonalBoards() {//number of boards personal all
        return sizeList(By.xpath("//span[@class='icon-lg icon-member']/../../..//ul//li")) - 1;
    }

    public void selectFirstPersonalBoard() {

        click(By.xpath("//span[@class='icon-lg icon-member']/../../..//ul//li"));
    }

    public void selectPersonalBoardByNumber(int n) {

        click(By.xpath("//span[@class='icon-lg icon-member']/../../..//ul//li[" + n + "]"));
    }


    public void fillBoardCreationForm(String boardName, String description) {

        typeTextInTheFieldNameBoard(By.cssSelector("[data-test-id='create-board-title-input']"), boardName);
        if (isElementPresent(By.cssSelector(".W6rMLOx8U0MrPx"))) {
            click(By.cssSelector(".W6rMLOx8U0MrPx"));
            click(By.xpath("//nav[@class='SdlcRrTVPA8Y3K']//li[1]"));//no team
        }
    }


    public void deleteBoard() throws InterruptedException {


        click(By.xpath("//input[@class='js-confirm full negate']"));// button CLOSE additionally
        Thread.sleep(1000);
        click(By.xpath("//a[@class='quiet js-delete']"));//permanently delete
        Thread.sleep(1000);
        click(By.xpath("//input[@class='js-confirm full negate']"));// button CLOSE additionally
        returnToHome();
    }

    public void closeTheBoard() {

        if (Visible(By.xpath("//a[@class='board-header-btn mod-show-menu js-show-sidebar']"))) { //button MENU
            click(By.xpath("//a[@class='board-header-btn mod-show-menu js-show-sidebar']"));
        } else {
            click(By.xpath("//a[@class='board-menu-navigation-item-link js-open-more']"));// button MORE down
        }
        click(By.xpath("//a[@class='board-menu-navigation-item-link js-close-board']"));// button close board down
    }

    public boolean isPersonalBoards() {

        return isElementPresent(By.xpath("//*[@class='icon-lg icon-member']/../../.."));
    }

    public void selectCreateSomethingFromDropDown(By locator) {

        click(locator);
    }

    public void createBoards1(int numberBoards) throws InterruptedException {


        for (int x = 1; numberBoards > 0; numberBoards--, x++) {

            clickButtonPlusUp();// button create " + "

            Thread.sleep(1000);
            String boardName1 = "";
            boardName1 = "#-" + x + " " + boardName;

            selectCreateSomethingFromDropDown(By.cssSelector("[data-test-id='header-create-board-button']"));
            typeTextInTheFieldNameBoard(By.cssSelector("[data-test-id=\"create-board-title-input\"]"), boardName1);
            //----------------board type selection - with or without a team--------------------
            Thread.sleep(2000);
            click(By.xpath("//button[@class='W6rMLOx8U0MrPx']//span[@name='down']"/*button ^ select */));
            Thread.sleep(2000);
            if (no_team) {

                click(By.xpath("//div[@id='layer-manager-popover']//li[1]//button[1]"));
            } else
                click(By.xpath("//nav[@class='SdlcRrTVPA8Y3K']//li[2]//button[1]"));
            Thread.sleep(1000);
            click(By.xpath("//button[@class='_1Lkx3EjS3wCrs7']//span[@name='down']"));
            if (privet_team) {
                Thread.sleep(1000);
                click(By.xpath("//li[1]//button[1]//span[1]//div[1]"));
                //clickOnWebElement(By.cssSelector("//*[@class='_2BQG4yPMt5s_hu _3qi72H5bh1Hw2k _2BsMHO2GghWoia _3CXWmcvfj_w5yC _1Hfz_OCLW086D8']"));
                Thread.sleep(1000);
            } else {
                click(By.xpath("//li[1]//button[1]//span[1]//div[1]"));
                //clickOnWebElement(By.xpath("//div[@id='layer-manager-popover']//li[2]//button[1]"));
                //clickOnWebElement(By.xpath("//button[@class='_1Lkx3EjS3wCrs7']//span[@name='down']"));
                Thread.sleep(2000);
                //clickOnWebElement(By.xpath("//div[@id='layer-manager-popover']//li[2]//button[1]"));
                //clickOnWebElement(By.xpath("//span[@name='public']"));
                //clickOnWebElement(By.xpath("//body/div[@id='trello-root']/div[@id='chrome-container']/div[@class='js-react-root']/div[@id='layer-manager-popover']/div[@class='Y34HN84mGuwAaM _1-EJ9-6xaTaAf-']/div[@class='_3n2uNSrVwAmo1u']/nav[@class='_2R1DnMySK1mTDa']/ul/li[2]/button[1]/span[1]"));
                click(By.cssSelector("//*[@name='public']/."));

                Thread.sleep(2000);
                //clickOnWebElement(By.xpath("//button[@class='_3UeOvlU6B5KUnS _2MgouXHqRQDP_5 _3ZPeWh5QQj47DA']"));
                click(By.cssSelector("//*[@class='X6LMWvod566P68']//button[1]"));

            }
//-------------------------------background--------------------------------------------------

            if (enable_background_random) {
                background_selection = (int) (Math.random() * 8 + 1);
            }
            click(By.xpath("//div[@id='layer-manager-overlay']//li[" + background_selection + "]"));
            //-------------------------------create board------------------------------------
            click(By.cssSelector("[data-test-id='create-board-submit-button']"));
            //-----------------------------------
            Thread.sleep(1000);
        }
        //System.out.println("Created " + (x - 1) + " boards.");

    }
}