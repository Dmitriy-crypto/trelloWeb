package com.trello.qa.tests;
//one upload start project

import com.trello.qa.manager.ApplicationManager;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamCreationTests extends TestBase {

    @BeforeClass
    public void ensurePrecondition() throws InterruptedException {

        if (!app.getSessionHelper().isUserLoggedIn()) {
            app.getSessionHelper().loginToTrello(ApplicationManager.email, ApplicationManager.password);
        }
    }

    @BeforeMethod
    public void isOnHomePage() {

        if (!app.getBoardHelper().isPersonalBoards()) {
            app.getTeamHelper().returnToHome();
        }
    }


    @Test()
    public void testTeamCreationFromButtonOnHeader() throws InterruptedException {

        int beforeCountTeams = app.getTeamHelper().getTeamsCount();
        System.out.println("testTeamCreationFromButtonOnHeader beforeCountTeams = " + beforeCountTeams);
        app.getTeamHelper().clickButtonPlusUp();
        app.getBoardHelper().selectCreateSomethingFromDropDown(By.cssSelector("[data-test-id='header-create-team-button']"));
        Thread.sleep(1000);
        app.getTeamHelper().fillTeamCreationForm(app.getTeamHelper().teamName, app.getTeamHelper().description);
        Thread.sleep(2000);
        app.getSessionHelper().clickContinueButton();
        Thread.sleep(1000);
        app.getTeamHelper().click(By.xpath("//a[@class='eg0KI5SqghoOFd']"));//click on the inscription "return to home page"
       // String createdTeamName = app.getTeamHelper().getTeamNameFromPage();
       // Assert.assertEquals(createdTeamName.toLowerCase(), app.getTeamHelper().teamName.toLowerCase());
        app.getTeamHelper().returnToHome();
        int afterCountTeams = app.getTeamHelper().getTeamsCount();
        System.out.println("testTeamCreationFromButtonOnHeader afterCountTeams = " + afterCountTeams);
        Assert.assertEquals(afterCountTeams, beforeCountTeams + 1);
        // Assert.assertTrue(isUserLoggedIn(By.xpath("//a[@class='button-link tabbed-pane-header-details-edit js-edit-profile']")), "ass");
    }

    @Test(enabled = false)
    public void testCreatBoardFromButtonPlusLeft() throws InterruptedException {

        int beforeCountTeams = app.getTeamHelper().getTeamsCount();
        System.out.println("testTeamCreationFromButtonOnHeader beforeCountTeams = " + beforeCountTeams);
        app.getTeamHelper().click(By.cssSelector("[data-test-id='home-navigation-create-team-button']"));
        app.getTeamHelper().fillTeamCreationForm(app.getTeamHelper().teamName, app.getTeamHelper().description);
        Thread.sleep(3000);
        app.getSessionHelper().clickContinueButton();
        Thread.sleep(3000);
        app.getTeamHelper().click(By.xpath("//a[@class='eg0KI5SqghoOFd']"));//click on the inscription "return to home page"
        String createdTeamName = app.getTeamHelper().getTeamNameFromPage();
        Assert.assertEquals(createdTeamName.toLowerCase(), app.getTeamHelper().teamName.toLowerCase());
        app.getTeamHelper().returnToHome();
        System.out.println(app.getTeamHelper().getTeamsCount());
        Assert.assertEquals(app.getTeamHelper().getTeamsCount(), beforeCountTeams + 1);

    }

    @Test(enabled = false)
    public void testTeamCancelCreationFromButtonOnHeader() throws InterruptedException {

        app.getTeamHelper().clickButtonPlusUp();
        app.getBoardHelper().selectCreateSomethingFromDropDown(By.cssSelector("[data-test-id='header-create-board-button']"));
        app.getTeamHelper().fillTeamCreationForm(app.getTeamHelper().teamName, app.getTeamHelper().description);
        app.getTeamHelper().clickXorCancel();
        //Assert.assertTrue(isUserLoggedIn(), "ass");
    }
}
