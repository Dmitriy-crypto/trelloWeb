package com.trello.qa;
//one upload start project

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamCreationTests extends TestBase {

    @BeforeClass
    public void ensurePrecondition() throws InterruptedException {

        if (!app.isUserLoggedIn()) {
            app.loginToTrello(ApplicationManager.email, ApplicationManager.password);
        }
    }

    @BeforeMethod
    public void isOnHomePage() {

        if (!app.isPersonalBoards()) {
            app.returnToHome();
        }
    }


    @Test()
    public void testTeamCreationFromButtonOnHeader() throws InterruptedException {

        int beforeCountTeams = app.getTeamsCount();
        System.out.println("testTeamCreationFromButtonOnHeader beforeCountTeams = " + beforeCountTeams);
        app.clickButtonPlusUp();
        app.selectCreateSomethingFromDropDown(By.cssSelector("[data-test-id='header-create-team-button']"));
        Thread.sleep(1000);
        app.fillTeamCreationForm(app.teamName, app.description);
        Thread.sleep(2000);
        app.clickContinueButton();
        Thread.sleep(1000);
        app.click(By.xpath("//a[@class='eg0KI5SqghoOFd']"));//click on the inscription "return to home page"
        String createdTeamName = app.getTeamNameFromPage();
        Assert.assertEquals(createdTeamName.toLowerCase(), app.teamName.toLowerCase());
        app.returnToHome();
        int afterCountTeams = app.getTeamsCount();
        System.out.println("testTeamCreationFromButtonOnHeader afterCountTeams = " + afterCountTeams);
        Assert.assertEquals(afterCountTeams, beforeCountTeams + 1);
        // Assert.assertTrue(isUserLoggedIn(By.xpath("//a[@class='button-link tabbed-pane-header-details-edit js-edit-profile']")), "ass");
    }

    @Test
    public void testCreatBoardFromButtonPlusLeft() throws InterruptedException {

        int beforeCountTeams = app.getTeamsCount();
        System.out.println("testTeamCreationFromButtonOnHeader beforeCountTeams = " + beforeCountTeams);
        app.click(By.cssSelector("[data-test-id='home-navigation-create-team-button']"));
        app.fillTeamCreationForm(app.teamName, app.description);
        Thread.sleep(3000);
        app.clickContinueButton();
        Thread.sleep(3000);
        app.click(By.xpath("//a[@class='eg0KI5SqghoOFd']"));//click on the inscription "return to home page"
        String createdTeamName = app.getTeamNameFromPage();
        Assert.assertEquals(createdTeamName.toLowerCase(), app.teamName.toLowerCase());
        app.returnToHome();
        System.out.println(app.getTeamsCount());
        Assert.assertEquals(app.getTeamsCount(), beforeCountTeams + 1);

    }

    @Test(enabled = false)
    public void testTeamCancelCreationFromButtonOnHeader() {

        app.clickButtonPlusUp();
        app.selectCreateSomethingFromDropDown(By.cssSelector("[data-test-id='header-create-board-button']"));
        app.fillTeamCreationForm(app.teamName, app.description);
        app.clickXorCancel();
        //Assert.assertTrue(isUserLoggedIn(), "ass");
    }
}
