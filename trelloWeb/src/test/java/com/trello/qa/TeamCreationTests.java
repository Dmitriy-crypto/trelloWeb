package com.trello.qa;
//one upload start project
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TeamCreationTests extends TestBase {
    @Test
    public void TeamCreation() {
        Assert.assertTrue(isUserLoggedIn(), "ass");

    }


}
