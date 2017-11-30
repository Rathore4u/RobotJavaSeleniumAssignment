package com.crossover.automation.utilities;

import org.openqa.selenium.By;


public final class BasicUtilities extends WebDriverInitialization {

    public static boolean verifyElementExists(By locator) {
        if (locator != null) {
            return driver.findElement(locator).isDisplayed() ? true : false;
        } else {
            return false;
        }
    }
}
