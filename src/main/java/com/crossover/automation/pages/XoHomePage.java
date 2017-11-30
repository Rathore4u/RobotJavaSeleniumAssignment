package com.crossover.automation.pages;

import com.crossover.automation.utilities.BasicUtilities;
import com.crossover.automation.utilities.WebDriverInitialization;
import org.apache.commons.logging.impl.Log4JLogger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class XoHomePage extends WebDriverInitialization implements Locators {

    Log4JLogger log = new Log4JLogger();

    public void openUrl(String url){
        driver.get(url);
    }

    public void verifyHomePageOpen(){
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.id(Locators.HOME_PAGE_XO_LOGO_ID)));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(Locators.HOME_PAGE_LANDING_URL, currentUrl);
        Assert.assertTrue("Home Page could not be verified to be open", BasicUtilities.verifyElementExists(By.id(Locators.HOME_PAGE_XO_LOGO_ID)));
    }

    public void openCandidatesMenu(){
        driver.findElements(By.cssSelector(Locators.HOME_PAGE_FOR_CANDIDATES)).get(1).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locators.JOBS_PAGE_SEE_AVAIALABLE_JOBS)));
    }

    public void verifyCandidatesPageOpened() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locators.JOBS_PAGE_SEE_AVAIALABLE_JOBS)));
    }

    public void openCandidatesPage(String hyperlinkText) {
        if("See Available Jobs".equals(hyperlinkText)) {
            driver.findElement(By.xpath(Locators.JOBS_PAGE_SEE_AVAIALABLE_JOBS)).click();
        }else{
            log.info("Given hyperlink text is not available or invalid option to click ");
        }
    }

    public void verifyJobsSegmentOpened(){
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locators.JOBS_PAGE_SEARCH_INPUT)));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("Jobs page url is not matching to expected url ", Locators.JOBS_PAGE_URL, currentUrl);
    }

}