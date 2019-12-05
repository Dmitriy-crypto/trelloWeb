package com.trello.qa;
//one upload start project


import org.testng.Assert;
import org.testng.annotations.Test;

public class TeamCreationTests extends TestBase {


    @Test(enabled = true)
    public void testTeamCreationFromButtonOnHeader() {

        clickOnPlusButtonOnHeader();
        selectCreateTeamFromDropDon();
        fillTeamCreationForm(teamName, description);
        clickContinueButton();
        Assert.assertTrue(isUserLoggedIn(), "ass");

    }

    @Test(enabled = false)
    public void testTeamCancelCreationFromButtonOnHeader() {

        clickOnPlusButtonOnHeader();
        selectCreateTeamFromDropDon();
        fillTeamCreationForm(teamName, description);
        clickXorCancel();
        Assert.assertTrue(isUserLoggedIn(), "ass");

    }


}
