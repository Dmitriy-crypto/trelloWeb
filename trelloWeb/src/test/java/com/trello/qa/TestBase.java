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

  public String boardName1 = "board off test ";

  public int s = 0;

  public int s1 = 0;

  int size;

  int numberBoards = 3;

  //-------------------End variables-------------------------------------------
  @BeforeMethod
  public void setUp() throws InterruptedException {

    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    //driver.manage().window().fullscreen();
    openSite(url);
    logInToTrello(email, password);
    Thread.sleep(2000);
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
    typeTextInTheFieldNameBoard(By.cssSelector("[type=email]"), email);
//        typeTextInTheField(By.cssSelector("[type=password]"), password);
    clickOnWebElement(By.id("login"));
    Thread.sleep(3000);
    clickOnWebElement(By.id("login-submit"));
    Thread.sleep(3000);
    typeTextInTheFieldNameBoard(By.id("password"), password);
    Thread.sleep(3000);
    clickOnWebElement(By.id("login-submit"));
  }

  public void clickOnWebElement(By locator) {

    driver.findElement(locator).click();
  }

  public void typeTextInTheFieldNameBoard(By locator, String text) {

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

    typeTextInTheFieldNameBoard(By.cssSelector("[data-test-id='header-create-team-name-input']"), teamName);
    typeTextInTheFieldNameBoard(By.cssSelector("textarea"), description);
  }

  public void selectCreateSomethingFromDropDown(By locator) {

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

    typeTextInTheFieldNameBoard(By.cssSelector("[data-test-id='create-board-title-input']"), boardName);
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

  public boolean Visible(By locator) {

    return driver.findElement(locator).isDisplayed();
  }

  public void createBoard(int numberBoards) throws InterruptedException {

    int x;
    for (x = 1; numberBoards > 0; numberBoards--, x++) {
      boardName = "";
      boardName = "# " + boardName1 + "-" + x;
      // button create " + "
      clickOnWebElement(By.cssSelector("[data-test-id='header-create-menu-button']"));
      Thread.sleep(2000);
      // select: board or team or business team
      selectCreateSomethingFromDropDown(By.cssSelector("[data-test-id='header-create-board-button']"));
      typeTextInTheFieldNameBoard(By.cssSelector("[data-test-id=\"create-board-title-input\"]"), boardName);
      //----------------board type selection - with or without a team--------------------
      clickOnWebElement(By.xpath("//button[@class='W6rMLOx8U0MrPx']//span[@name='down']"/*button ^ select */));
      if (s == 0) {
        clickOnWebElement(By.xpath("//div[@id='layer-manager-popover']//li[1]//button[1]"));
      } else
        clickOnWebElement(By.xpath("//nav[@class='SdlcRrTVPA8Y3K']//li[2]//button[1]"));
      clickOnWebElement(By.xpath("//button[@class='_1Lkx3EjS3wCrs7']//span[@name='down']"));
      if (s1 == 0) {
        clickOnWebElement(By.xpath("//li[1]//button[1]//span[1]//div[1]"));
      } else {
        clickOnWebElement(By.xpath("//div[@id='layer-manager-popover']//li[2]//button[1]"));
      }
//-------------------------------fon---------------------------------------------------
      // clickOnWebElement(By.xpath("//div[@id='layer-manager-overlay']//li[2]"));
      //-------------------------------create board------------------------------------
      clickOnWebElement(By.xpath("//button[@class='_3UeOvlU6B5KUnS uj9Ovoj4USRUQz _2MgouXHqRQDP_5']"));
      //-----------------------------------
      Thread.sleep(2000);
    }
    System.out.println("Created " + x + " boards.");
  }

}
