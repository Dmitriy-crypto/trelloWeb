package com.trello.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class TeamDeletionTests extends TestBase {

    @Test
    public void deleteTeamFromLeftNavMenu() throws InterruptedException {

        int i;//count delete boards
        int before = app.getTeamHelper().getTeamsCountDelete();
        System.out.println(before+" numbers teams before For");
        if(!(before ==0)){
        for (i = 0; (before) >= 1; before--, i++) {
            //for (i = 0; (before + 1) > 1; before--, i++) {
            System.out.println(before+"numbers team in For ");
            app.getTeamHelper().clickOnFirstTeam();
            app.getTeamHelper().openSettings();
            app.getTeamHelper().deleteTeam();
        }
        System.out.println("number teams deleted  " + i);

/*if(before==0){
    before=1;
}*/}  app.getSessionHelper().refreshPage();

        app.getTeamHelper().after = app.getTeamHelper().getTeamsCountDelete();
        //System.out.println(before+" numbers teams after For");
        System.out.println("numbers teams after method delete in For"+app.getTeamHelper().after);

        Assert.assertEquals(app.getTeamHelper().after, before);
    }


}
