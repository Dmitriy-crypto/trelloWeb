package com.trello.qa;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TeamDeletionTests extends TestBase {

    @Test
    public void deleteTeamFromLeftNavMenu() {

        int before = getTeamsCount();
        clickOnFirstTeam();
        openSettings();
        deleteTeam();
        int after = getTeamsCount();
        Assert.assertEquals(after, before - 1);
    }


}
