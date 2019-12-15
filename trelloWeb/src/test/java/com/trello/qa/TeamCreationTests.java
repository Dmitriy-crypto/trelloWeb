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

        if (!isUserLoggedIn()) {
            loginToTrello(email, password);
        }
    }

    @BeforeMethod
    public void isOnHomePage() {

        if (!isPersonalBoards()) {
            returnToHome();
        }
    }


    @Test()
    public void testTeamCreationFromButtonOnHeader() throws InterruptedException {

        int beforeCountTeams = getTeamsCount();
        System.out.println(beforeCountTeams);
        clickButtonPlusUp();
        selectCreateSomethingFromDropDown(By.cssSelector("[data-test-id='header-create-team-button']"));
        Thread.sleep(1000);
        fillTeamCreationForm(teamName, description);
        Thread.sleep(2000);
        clickContinueButton();
        Thread.sleep(1000);
        click(By.xpath("//a[@class='eg0KI5SqghoOFd']"));//click on the inscription "return to home page"
        String createdTeamName = getTeamNameFromPage();
        Assert.assertEquals(createdTeamName.toLowerCase(), teamName.toLowerCase());
        returnToHome();
        int afterCountTeams = getTeamsCount();
        System.out.println(afterCountTeams);
        Assert.assertEquals(afterCountTeams, beforeCountTeams + 1);
        // Assert.assertTrue(isUserLoggedIn(By.xpath("//a[@class='button-link tabbed-pane-header-details-edit js-edit-profile']")), "ass");
    }

    @Test()
    public void testCreatBoardFromButtonPlusLeft() throws InterruptedException {

        int beforeCountTeams = getTeamsCount();
        click(By.cssSelector("[data-test-id='home-navigation-create-team-button']"));
        fillTeamCreationForm(teamName, description);
        Thread.sleep(3000);
        clickContinueButton();
        Thread.sleep(3000);
        click(By.xpath("//a[@class='eg0KI5SqghoOFd']"));//click on the inscription "return to home page"
        String createdTeamName = getTeamNameFromPage();
        Assert.assertEquals(createdTeamName.toLowerCase(), teamName.toLowerCase());
        returnToHome();
        System.out.println(getTeamsCount());
        Assert.assertEquals(getTeamsCount(), beforeCountTeams + 1);

    }

    @Test(enabled = false)
    public void testTeamCancelCreationFromButtonOnHeader() {

        clickButtonPlusUp();
        selectCreateSomethingFromDropDown(By.cssSelector("[data-test-id='header-create-board-button']"));
        fillTeamCreationForm(teamName, description);
        clickXorCancel();
        //Assert.assertTrue(isUserLoggedIn(), "ass");
    }
}
