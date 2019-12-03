package com.trello.qa;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TeamCreationTests extends TestBase {
    @Test
    public void TeamCreation() {
        Assert.assertTrue(isUserLoggedIn(), "ass");

    }

    public boolean isUserLoggedIn() {
        return isElementPresent(By.cssSelector("[data-test-id='header-member-menu-button']"));
    }

    private boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;

    }
//checin

}
