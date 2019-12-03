package com.trello.qa;
//one upload start project

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TeamCreationTests extends TestBase {
    @Test
    public void testTeamCreationFromButtonOnHeader() {
        String teamName = "Dmitriy_qa_learn";
        String description = "descr Learn";
        clickOnPlusButtonOnHeader();
        selestCreateTeamFromDropDoun();
        fillTeamCreationForm("s", "");
        clickContinueButtun();
        Assert.assertTrue(isUserLoggedIn(), "ass");

    }

    public void clickContinueButtun() {
        click(By.cssSelector("[type=submit]"));
    }

    public void fillTeamCreationForm(String teamName, String description) {
        type(By.cssSelector("[data-test-id='header-create-team-name-input']"), teamName);
        type(By.cssSelector("textarea"), description);
    }

    public void selestCreateTeamFromDropDoun() {
        click(By.cssSelector("[data-test-id='header-create-team-button']"));

    }

    public void clickOnPlusButtonOnHeader() {
        click(By.cssSelector("[data-test-id='header-create-menu-button']"));
    }


}
