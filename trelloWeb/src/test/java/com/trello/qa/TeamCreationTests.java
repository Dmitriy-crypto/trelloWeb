package com.trello.qa;
//one upload start project

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TeamCreationTests extends TestBase {

    @Test(enabled = true)
    public void testTeamCreationFromButtonOnHeader() throws InterruptedException {

        int beforeCountTeams = getTeamsCount();
        System.out.println(beforeCountTeams);
        clickOnWebElement(By.cssSelector("[data-test-id='header-create-menu-button']"));
        Thread.sleep(3000);
        selectCreateSomethingFromDropDown(By.cssSelector("[data-test-id='header-create-team-button']"));
        Thread.sleep(3000);
        fillTeamCreationForm(teamName, description);
        Thread.sleep(3000);
        clickContinueButton();
        Thread.sleep(3000);
        clickOnWebElement(By.xpath("//a[@class='eg0KI5SqghoOFd']"));
//        return to home page
        int afterCountTeams = getTeamsCount();
        System.out.println(afterCountTeams);
        Assert.assertEquals(afterCountTeams + 1, beforeCountTeams);
        // Assert.assertTrue(isUserLoggedIn(By.xpath("//a[@class='button-link tabbed-pane-header-details-edit js-edit-profile']")), "ass");
    }

    public int getTeamsCount() {

        return driver.findElements(By.xpath("//*[@class='NC6qaILF7dGKjb']/../li")).size();
    }

    @Test(enabled = false)
    public void testTeamCancelCreationFromButtonOnHeader() {

        clickOnPlusButtonOnHeader();
        selectCreateSomethingFromDropDown(By.cssSelector("[data-test-id='header-create-board-button']"));
        fillTeamCreationForm(teamName, description);
        clickXorCancel();
        //Assert.assertTrue(isUserLoggedIn(), "ass");
    }

}
