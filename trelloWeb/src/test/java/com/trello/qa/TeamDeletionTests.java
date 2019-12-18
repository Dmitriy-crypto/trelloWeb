package com.trello.qa;

import org.testng.annotations.Test;

public class TeamDeletionTests extends TestBase {

    @Test
    public void deleteTeamFromLeftNavMenu() throws InterruptedException {

        int i;//count delete boards
        int before = app.getTeamsCount();
        /*System.out.println(before);
        for (i = 0; (before )>=1; before--, i++) {
        //for (i = 0; (before + 1) > 1; before--, i++) {
            app.clickOnFirstTeam();
            app.openSettings();
            app.deleteTeam();
        }
        System.out.println("number deleted  "+i);
        refreshPage();*/
        int after = app.getTeamsCount();
        System.out.println(after);
/*if(before==0){
    before=1;
}*/

        //Assert.assertEquals(after, before );
    }

    private void refreshPage() {

        app.driver.navigate().refresh();

    }


}
