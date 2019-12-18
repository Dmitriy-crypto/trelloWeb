package com.trello.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class ApplicationManager {

    //-------------------Variables-------------------------------------
    public static String url = "https://trello.com/";
    public static String email = "dmitriy.stadnikov@yahoo.com";
    public static String password = "75Dmitriy.2013Eva";
    //------------------Variables for teams fill----------------------------------------
    public String teamName = "test11 - " + (int) System.currentTimeMillis();
    public String description = "descr Learn_delete_ok";
    //----------------------------Variables for boards fill------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------
    public String boardName = "Board off test - " + (int) System.currentTimeMillis();// name board to creat
    public String x = "23";
    WebDriver driver;
    WebDriverWait driverWait;
    boolean no_team = true;//option selection
    boolean privet_team = true;//option selection not work
    //''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
    boolean enable_background_random = true;// enable random background selection
    //else
    int background_selection = 1;// start number underground off board
    //'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
    int numberBoards = 3;// number of boards to creat
    int n; //board selection by position in "public void selectPersonalBoardByNumber"

    public void init() throws InterruptedException {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        //driver.manage().window().fullscreen();
        openSite(url);
        loginToTrello(email, password);
    }

    public void stop() {

        driver.quit();
    }

    //------------------Methods OPEN AND LOGIN SITE---------------------------------------------------
    public void loginToTrello(String email, String password) throws InterruptedException {

        click(By.cssSelector("[href='/login']"));
        typeTextInTheFieldNameBoard(By.cssSelector("[type=email]"), email);
//        typeTextInTheField(By.cssSelector("[type=password]"), password);
        click(By.id("login"));
        Thread.sleep(3000);
        click(By.id("login-submit"));
        Thread.sleep(3000);
        typeTextInTheFieldNameBoard(By.id("password"), password);
        Thread.sleep(3000);
        click(By.id("login-submit"));
    }

    public void openSite(String url) {

        driver.navigate().to(url);
    }

    public void clickContinueButton() {

        click(By.cssSelector("[type=submit]"));
    }

    public boolean isUserLoggedIn() {

        return isElementPresent(By.cssSelector("[data-test-id='header-member-menu-button']"));
    }

    //-----------------------------COMMON METHODS--------------------------------------
    public void click(By locator) {

        driver.findElement(locator).click();
    }

    public boolean isElementPresent(By locator) {

        return driver.findElements(locator).size() > 0;
    }

    public int sizeList(By locator) {

        return driver.findElements(locator).size();

    }

    public void returnToHome() {
        //    "//a[@href='/']"
        //span[@name='house']
        if (isElementPresent(By.cssSelector("._3gUubwRZDWaOF0._2WhIqhRFBTG7Ry._2NubQcQM83YCVV"))) {
            new WebDriverWait(driver, 15).until(ExpectedConditions.
                    stalenessOf(driver.findElement(By.cssSelector("._3gUubwRZDWaOF0._2WhIqhRFBTG7Ry._2NubQcQM83YCVV"))));
            click(By.cssSelector("a[href='/']"));
            click(By.cssSelector("a[href='/']"));
        } else
            click(By.cssSelector("a[href='/']"));
    }

    //------------------------COMMON METHODS FOR CREAT------------------------------------------
    public void selectCreateSomethingFromDropDown(By locator) {

        driver.findElement(locator).click();
    }

    public void clickXorCancel() {

    }

    public void selectCreateBoardFromDropDown() {

        click(By.cssSelector("[data-test-id='header-create-board-button']"));
    }

    void findElement(By locator) {

    }

    public boolean Visible(By locator) {

        return driver.findElement(locator).isDisplayed();
    }

    public void clickButtonPlusUp() {

        click(By.cssSelector("[data-test-id='header-create-menu-button']"));
    }

    //---------------------------------METHODS FOR TEAMS-----------------------------------------------
    public String getTeamNameFromPage() {

        new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h1.u-inline")));
        return driver.findElement(By.cssSelector("h1.u-inline")).getText();
    }

    public int getTeamsCount() {

        new WebDriverWait(driver, 10).until(ExpectedConditions.
                presenceOfAllElementsLocatedBy(By.xpath("//*[@class='NC6qaILF7dGKjb']/../li")));
        return driver.findElements(By.xpath("//*[@class='NC6qaILF7dGKjb']/../li")).size();
    }

    public void deleteTeam() {

        driver.manage().window().fullscreen();
        new WebDriverWait(driver, 15).until(elementToBeClickable(By.cssSelector(".quiet-button")));
        click(By.cssSelector(".window-module.u-gutter"));

        new WebDriverWait(driver, 15).until(elementToBeClickable(By.cssSelector(".js-confirm.full.negate")));
        new WebDriverWait(driver, 15).until(elementToBeClickable(By.cssSelector(".js-confirm.full.negate")));
        click(By.cssSelector(".js-confirm.full.negate"));

        new WebDriverWait(driver, 15).until(elementToBeClickable(By.cssSelector("a[href='/']")));
        click(By.cssSelector("a[href='/']"));

    }

    public void openSettings() throws InterruptedException {

        new WebDriverWait(driver, 15).
                until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".icon-gear.icon-sm._2aV_KY1gTq1qWc")));
        new WebDriverWait(driver, 15).
                until(ExpectedConditions.elementToBeClickable(By.cssSelector(".icon-gear.icon-sm._2aV_KY1gTq1qWc")));

        click(By.cssSelector(".icon-gear.icon-sm._2aV_KY1gTq1qWc"));
        Thread.sleep(1000);
    }

    public void clickOnFirstTeam() {

        new WebDriverWait(driver, 15).until(elementToBeClickable(By.xpath("//*[@class='NC6qaILF7dGKjb']/../li")));
        click(By.xpath("//*[@class='NC6qaILF7dGKjb']/../li"));
    }

    public void fillTeamCreationForm(String teamName, String description) {

        typeTextInTheFieldNameBoard(By.cssSelector("[data-test-id='header-create-team-name-input']"), teamName);
        typeTextInTheFieldNameBoard(By.cssSelector("textarea"), description);
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

    public void typeTextInTheFieldNameBoard(By locator, String text) {

        driver.findElement(locator).click();
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
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
}
