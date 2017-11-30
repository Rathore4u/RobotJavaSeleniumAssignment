package com.crossover.automation.pages;

import com.crossover.automation.utilities.BasicUtilities;
import com.crossover.automation.utilities.WebDriverInitialization;
import org.apache.commons.logging.impl.Log4JLogger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.python.modules.thread.thread;

import java.util.List;
import java.util.logging.Logger;

public class JobsPage extends WebDriverInitialization implements Locators {

    Logger log = Logger.getLogger(JobsPage.class.getName());

    public void focusOnSearchField() {
        driver.findElement(By.xpath(Locators.JOBS_PAGE_SEARCH_INPUT)).click();
    }

    public void verifyFocusOnSearchInputText() {
        Assert.assertTrue("Search Input doesn't exist or not visible ", BasicUtilities.verifyElementExists(By.xpath(Locators.JOBS_PAGE_SEARCH_INPUT)));
    }

    public void searchText(String searchKey) {
        driver.findElement(By.xpath(Locators.JOBS_PAGE_SEARCH_INPUT)).clear();
        driver.findElement(By.xpath(Locators.JOBS_PAGE_SEARCH_INPUT)).sendKeys(searchKey);
        driver.findElement(By.xpath(Locators.JOBS_PAGE_SEARCH_BUTTON)).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locators.JOBS_PAGE_RESET_BUTTON)));
    }

    public void verifyResults(String verifyTerm) {
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locators.JOBS_PAGE_RESULT_LIST)));
        List<WebElement> searchResultList = driver.findElements(By.xpath(Locators.JOBS_PAGE_RESULT_LIST));
        int counter = 0;
        for (WebElement searchResult : searchResultList) {
            if (searchResult.getText() != null && !searchResult.getText().isEmpty()) {
                if (searchResult.getText().contains(verifyTerm)) {
                    counter++;
                } else {
                    log.info("Title not having given term text is: " + searchResult.getText());
                }
            }
        }
        log.info("Total Results which had this term in their job title were: " + counter);
        Assert.assertTrue("This particular result does not have expected search term to verify in title ", counter > 0);
    }

    public void resetResults() {
        driver.findElement(By.xpath(Locators.JOBS_PAGE_RESET_BUTTON)).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.attributeToBe(By.xpath(Locators.JOBS_PAGE_SEARCH_BUTTON), "disabled", "true"));
    }

    public void selectJobCategory(String categoryName) {
        driver.findElement(By.xpath(Locators.JOBS_PAGE_CATEGORY_DROPDOWN)).click();
        String xpathCategory = "//span[@class='ui-select-choices-row-inner']/div/span[contains(text(),'"+categoryName+"')]";
        driver.findElement(By.xpath(xpathCategory)).click();
        List<WebElement> searchResultList = driver.findElements(By.xpath(Locators.JOBS_PAGE_RESULT_LIST));
        int counter = 0;
        for (WebElement searchResult : searchResultList) {
            if (searchResult.getText() != null && !searchResult.getText().isEmpty()) {
                if (searchResult.getText().contains(categoryName)) {
                    counter++;
                } else {
                    log.info("Title not having given term text is: " + searchResult.getText());
                }
            }
        }
        log.info("Total Results which had this term in their job title were: " + counter);
        Assert.assertTrue("This particular result does not have expected search term to verify in title ", counter > 0);

    }

    public void openHomePageFromJobsPage() {
        driver.findElement(By.xpath(Locators.JOBS_PAGE_XO_LOGO)).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locators.JOBS_PAGE_XO_LOGO)));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(Locators.HOME_PAGE_ALTERNATE_URL, currentUrl);
        Assert.assertTrue("Home Page could not be verified to be open", BasicUtilities.verifyElementExists(By.xpath(Locators.JOBS_PAGE_XO_LOGO)));
    }
}
