package com.trello.qa;
//one upload start project

import org.testng.Assert;
import org.testng.annotations.Test;

public class TeamCreationTests extends TestBase {
    @Test
    public void testTeamCreationFromButtonOnHeader() {

        clickOnPlusButtonOnHeader();
        selestCreateTeamFromDropDoun();
        fillTeamCreationForm();
        clickContinueButtun();
        Assert.assertTrue(isUserLoggedIn(), "ass");

    }


}
