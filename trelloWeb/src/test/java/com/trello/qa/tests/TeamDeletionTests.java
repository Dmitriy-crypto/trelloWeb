package com.trello.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class TeamDeletionTests extends TestBase {

    @Test
    public void deleteTeamFromLeftNavMenu() throws InterruptedException {

        int i;//count delete boards
        int before = app.getTeamHelper().getTeamsCount();
        System.out.println(before);
        for (i = 0; (before) >= 1; before--, i++) {
            //for (i = 0; (before + 1) > 1; before--, i++) {
            app.getTeamHelper().clickOnFirstTeam();
            app.getTeamHelper().openSettings();
            app.getTeamHelper().deleteTeam();
        }
        System.out.println("number deleted  " + i);
        app.getSessionHelper().refreshPage();
        int after = app.getTeamHelper().getTeamsCount();
        System.out.println(after);
/*if(before==0){
    before=1;
}*/

        Assert.assertEquals(after, before);
    }


}
