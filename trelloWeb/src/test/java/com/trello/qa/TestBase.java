package com.trello.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {

    WebDriver driver;
    //-------------------Variables-------------------------------------

    public static String url = "https://trello.com/";

    //-------------------login ahd password-----------------------------
//    public static String email = "elena.telran@yahoo.com";
//    public static String password = "12345.com";


    public static String email = "dmitriy.stadnikov@yahoo.com";
    public static String password = "75Dmitriy.2013Eva";

    //------------------Variables for teams fill----------------------------------------
    public String teamName = "test_can_be_deleted";
    public String description = "descr Learn_delete_ok";

    //----------------------------Variables for boards fill------------------------------------------------------
    public String boardName = "board off test, can_be_deleted";
    public int s = 1;
    public int s1 = 0;
    int size;

    //-------------------End variables-------------------------------------------

    @BeforeMethod
    public void setUp() throws InterruptedException {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //driver.manage().window().fullscreen();

        openSite(url);
        logInToTrello(email, password);


    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public boolean isUserLoggedIn(By locator) {
        return isElementPresent(locator);
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;

    }

    public int sizeList(By locator) {
        size = driver.findElements(locator).size();
        return size;


    }

    //------------------Methods---------------------------------------------------

    public void logInToTrello(String email, String password) throws InterruptedException {
        clickOnWebElement(By.cssSelector("[href='/login']"));
        typeTextInTheField(By.cssSelector("[type=email]"), email);
//        typeTextInTheField(By.cssSelector("[type=password]"), password);
        clickOnWebElement(By.id("login"));
        Thread.sleep(3000);
        clickOnWebElement(By.id("login-submit"));
        Thread.sleep(3000);
        typeTextInTheField(By.id("password"), password);
        Thread.sleep(3000);
        clickOnWebElement(By.id("login-submit"));

    }

    public void clickOnWebElement(By locator) {
        driver.findElement(locator).click();
    }

    public void typeTextInTheField(By locator, String text) {
        driver.findElement(locator).click();
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void openSite(String url) {
        driver.navigate().to(url);
    }

    public void clickContinueButton() {
        clickOnWebElement(By.cssSelector("[type=submit]"));
    }

    public void fillTeamCreationForm(String teamName, String description) {
        typeTextInTheField(By.cssSelector("[data-test-id='header-create-team-name-input']"), teamName);
        typeTextInTheField(By.cssSelector("textarea"), description);
    }

    public void selectCreateTeamFromDropDon(By locator) {
        driver.findElement(locator).click();

    }

    public void clickOnPlusButtonOnHeader() {
        clickOnWebElement(By.cssSelector("[data-test-id='header-create-menu-button']"));
    }

    public void clickXorCancel() {
    }

    public void selectCreateBoardFromDropDown() {
        clickOnWebElement(By.cssSelector("[data-test-id='header-create-board-button']"));
    }

    public void fillBoardCreationForm(String boardName, String description) {

        typeTextInTheField(By.cssSelector("[data-test-id='create-board-title-input']"), boardName);
        if (isElementPresent(By.cssSelector(".W6rMLOx8U0MrPx"))) {
            clickOnWebElement(By.cssSelector(".W6rMLOx8U0MrPx"));
            clickOnWebElement(By.xpath("//nav[@class='SdlcRrTVPA8Y3K']//li[1]"));//no team
        }
    }

    public void confirmBoardCreation() {
        clickOnWebElement(By.cssSelector("[data-test-id='create-board-submit-button']"));
    }

    void findElement(By locator) {
    }
}
