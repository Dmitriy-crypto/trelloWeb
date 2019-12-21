package com.trello.qa.tests;

import org.testng.annotations.Test;

public class TeamModificationTest extends TestBase {

    @Test
    public void testRenameTeam() throws InterruptedException {

        app.getTeamHelper().clickOnFirstTeam();
        app.getTeamHelper().openSettings();
        app.getTeamHelper().initEditTeamProfile();
        app.getTeamHelper().changeTeamProfile();
        app.getTeamHelper().confirmEditTeam();
    }
}
